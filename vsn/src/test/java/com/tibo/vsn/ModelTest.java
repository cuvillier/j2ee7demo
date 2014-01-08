package com.tibo.vsn;

import com.tibo.vsn.model.Person;
import com.tibo.vsn.services.api.PersonServiceLocal;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePath;
import org.jboss.shrinkwrap.api.Node;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.ScopeType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.io.File;
import java.util.List;
import java.util.Map;

@RunWith(Arquillian.class)
public class ModelTest extends BaseTest {
    public static final Logger logger = LoggerFactory.getLogger(ModelTest.class);

    @Deployment(testable = true)
    public static WebArchive createDeployment() {
        try {
            System.out.println(new File(".").getAbsolutePath());

            // See ShrinkWrap resolver documentation at https://community.jboss.org/wiki/HowToIAddMavenArtifactsToMyShrinkWrapArchives
            File [] libs =  Maven.resolver().loadPomFromFile("pom.xml")
                    .importDependencies(ScopeType.COMPILE)
                    .resolve().withTransitivity().asFile();

            WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war")
                    .addPackages(true, "com.tibo.vsn")
                    .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                    .addAsLibraries(libs)
                    .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

            for(Map.Entry<ArchivePath, Node> entry: archive.getContent().entrySet()) {
                if( entry.getValue().toString().contains("lib") )
                    System.out.println(" ==> " + entry.getValue());
            }

            return archive;
        } catch(Exception e ) {
            e.printStackTrace();
            throw e instanceof RuntimeException ? (RuntimeException)e: new RuntimeException(e);
        }
    }

//    @EJB
//    private PersonServiceLocal personService;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    @Test
    public void personService() throws Exception {
        for(Person p: (List<Person>)em.createQuery("select o from Person o").getResultList() ) {
           logger.info(p.getFirstName() + " " + p.getLastName());
        }

        for(int i = 0; i < 10; i++) {
            em.persist(new Person("a", "b-" + i));
        }

/*
        for(int i = 0; i < 100; i++) {
            Person p = new Person("Bob", "Marley" + i);
            personService.addPerson(p);
        }
*/
    }
}