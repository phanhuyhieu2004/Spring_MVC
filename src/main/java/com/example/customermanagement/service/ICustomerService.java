package com.example.customermanagement.service;


import com.example.customermanagement.model.Customer;

import java.util.List;


import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void remove(int id);
}