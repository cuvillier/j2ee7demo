package com.tibo.cdi.event;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CustomerServiceImpl implements CustomerService {
    private static long idgen = 0;
    private Map<Long, Customer> customers = new HashMap<>();

    @Inject @Updated
    private Event<Customer> updatedCustomerEvent;

    @Inject @Deleted
    private Event<Customer> deletedCustomerEvent;

    @Inject @Inserted
    private Event<Customer> insertedCustomerEvent;

    @Override
    public void insertCustomer(Customer customer) {
        customer.setId(idgen++);
        customers.put(customer.getId(), customer);
        insertedCustomerEvent.fire(customer);
        System.out.println(customer);
    }

    @Override
    public void deleteCustomer(long customerID) {
        Customer customer = customers.remove(customerID);
        if( customer != null ) deletedCustomerEvent.fire(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
        updatedCustomerEvent.fire(customer);
    }

    public Map<Long, Customer> getCustomers() {
        return customers;
    }
}
