package com.tibo.cdi.event;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class CustomerAdapter {
    private Set<Customer> replicatedCustomers = new HashSet<>();

    public void onCustomerInserted(@Observes @Inserted Customer customer) {
        replicatedCustomers.add(customer);
    }

    public void onCustomerDeleted(@Observes @Deleted Customer customer) {
        replicatedCustomers.remove(customer);
    }

    public void onCustomerUpdated(@Observes @Updated Customer customer) {
        replicatedCustomers.add(customer);  // Set, no duplicate
    }

    public Set<Customer> getReplicatedCustomers() {
        return replicatedCustomers;
    }
}
