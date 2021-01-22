package com.booking.service.impl;

import com.booking.dao.CustomerRepository;
import com.booking.exception.CommonException;
import com.booking.model.Customer;
import com.booking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()) {
            throw new CommonException("Not found customer id: " + id);
        }
        return customer.get();
    }
}
