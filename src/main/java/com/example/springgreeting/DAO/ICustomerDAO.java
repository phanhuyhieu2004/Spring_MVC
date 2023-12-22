package com.example.springgreeting.DAO;

import com.example.springgreeting.Model.Customer;

import java.util.List;

public interface ICustomerDAO {
    List<Customer> getAllCustomer();

    Customer getCustomerById(int id);
}
