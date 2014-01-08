package com.tibo.cdi.event;

public interface CustomerService {
    void insertCustomer(Customer customer);
    void deleteCustomer(long customerID);
    void updateCustomer(Customer customer);
}
