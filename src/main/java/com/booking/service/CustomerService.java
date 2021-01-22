package com.booking.service;

import com.booking.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer findById(Long id);

}
