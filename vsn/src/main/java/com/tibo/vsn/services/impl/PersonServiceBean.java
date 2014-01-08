package com.tibo.vsn.services.impl;

import com.tibo.vsn.model.Person;
import com.tibo.vsn.model.Person_;
import com.tibo.vsn.services.api.PersonServiceLocal;
import com.tibo.vsn.services.api.PersonServiceRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Thibault on 12/17/13.
 */
@Stateless(name = "PersonServiceEJB")
//@Path("person")
@Transactional(Transactional.TxType.REQUIRED)
public class PersonServiceBean implements PersonServiceLocal, PersonServiceRemote {

    @PersistenceContext
    private EntityManager entityManager;

    public PersonServiceBean() {
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void addPerson(Person person) {
        entityManager.persist(person);
    }

    @Override
//    @GET
//    @Produces("text/json")
    public Person getPersonById(long id) {
        return entityManager.find(Person.class, id);
    }

    @Override
//    @GET
//    @Produces("text/json")
    public List<Person> findPersonsByName(String firstName, String lastName) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = builder.createQuery(Person.class);
        Root<Person>  root = query.from(Person.class);
        query.where(builder.and(builder.like(root.get(Person_.firstName), firstName),
                                builder.like(root.get(Person_.lastName), lastName)));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Person> getPersons() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = builder.createQuery(Person.class);
        Root<Person>  root = query.from(Person.class);
        return entityManager.createQuery(query).getResultList();
    }
}
