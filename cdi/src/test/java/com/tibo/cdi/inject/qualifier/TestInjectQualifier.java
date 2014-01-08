package com.tibo.cdi.inject.qualifier;

import com.tibo.cdi.BaseTestCDI;
import org.junit.Assert;
import org.junit.Test;

import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

public class TestInjectQualifier extends BaseTestCDI {

    @Inject
    @BobBean
    private BeanInter bob1;

    @Inject
    @AliceBean
    private BeanInter alice1;

    @Inject
    @BeanName(BeanNameEnum.BOB)
    private BeanInter bob2;

    @Inject
    @BeanName(BeanNameEnum.ALICE)
    private BeanInter alice2;


    @Test
    public void injectBean() {
        Assert.assertNotNull(bob1);
        Assert.assertNotNull(alice1);

        Assert.assertNotNull(bob2);
        Assert.assertNotNull(alice2);
    }

    @Inject
    @BobBean
    private Instance<BeanInter> aliceInstance1;

    @Inject
    @BeanName(BeanNameEnum.BOB)
    private Instance<BeanInter> aliceInstance2;

    @Inject
    private Instance<BeanInter> aliceInstance3;

    @Test
    public void injectInstance() {
        BeanInter alice1 = aliceInstance1.get();
        Assert.assertNotNull(bob1);

        BeanInter alice2= aliceInstance2.get();
        Assert.assertNotNull(alice2);

        class AliceLiteral extends AnnotationLiteral<AliceBean> implements AliceBean {}

        BeanInter alice3 = aliceInstance3.select(new AliceLiteral()).get();
        Assert.assertNotNull(alice3);

        class AliveNameLiteral extends AnnotationLiteral<BeanName> implements BeanName{
            public BeanNameEnum value() {
                return BeanNameEnum.ALICE;
            }
        }

        BeanInter alice = aliceInstance3.select(new AliveNameLiteral()).get();
        Assert.assertNotNull(alice);
    }
}