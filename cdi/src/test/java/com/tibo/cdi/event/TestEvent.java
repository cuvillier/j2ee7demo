package com.tibo.cdi.event;

import com.tibo.cdi.BaseTestCDI;
import org.junit.Assert;
import org.junit.Test;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

public class TestEvent extends BaseTestCDI {

    @Inject
    private CustomerService service;

    @Inject
    private CustomerAdapter adapter;

    @Test
    public void testEvents() {
        Set<Customer> customers = new HashSet<>();

        for(int i = 0; i < 10; i++ ) {
            Customer customer = new Customer("bob " + i, "Marley " + i);
            service.insertCustomer(customer);
            customers.add(customer);
        }

        assertCustomers(customers);

        Customer first = customers.iterator().next();
        customers.remove(first);
        service.deleteCustomer(first.getId());
        assertCustomers(customers);

        first = customers.iterator().next();
        first.setFirstName("Alice");
        service.updateCustomer(first);
        assertCustomers(customers);
    }

    public void assertCustomers(Set<Customer> customers) {
        Set<Customer> replicatedCustomers = adapter.getReplicatedCustomers();

        Assert.assertEquals(customers.size(), replicatedCustomers.size());
        for(Customer customer: customers) {
            Assert.assertTrue(replicatedCustomers.contains(customer));
        }
    }
}
