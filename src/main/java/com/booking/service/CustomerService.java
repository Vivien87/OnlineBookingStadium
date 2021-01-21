package com.booking.service;

import com.booking.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

}
