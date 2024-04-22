package com.example.customermanagementthymeleaf.service;


import com.example.customermanagementthymeleaf.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICustomerService {
    List<Customer>findAll ();
    void save(Customer customer);
    void remove(int id);
    Customer findById(int id);
    void update(int id,Customer customer);
    }