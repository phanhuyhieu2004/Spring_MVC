package com.example.springgreeting.Controller;

import com.example.springgreeting.DAO.CustomerDAO;
import com.example.springgreeting.Model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {
    CustomerDAO customerDAO=new CustomerDAO();
    @GetMapping("/list")
    public String listCustomer(Model m){
        List<Customer> list= customerDAO.getAllCustomer();
        m.addAttribute("listCustomer",list);
        return "list";
    }
    @GetMapping("/add/{id}")
    public String customer(@PathVariable int id, Model m){


        Customer customer= customerDAO.getCustomerById(id);
        m.addAttribute("customer",customer);
        return "add";
    }
}
