package com.example.customermanagementthymeleaf.controller;


import com.example.customermanagementthymeleaf.model.Customer;
import com.example.customermanagementthymeleaf.service.CustomerService;
import com.example.customermanagementthymeleaf.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

public class CustomerController {
    private final ICustomerService iCustomerService = new CustomerService();

    @GetMapping("/customers")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/index");
        List<Customer> customers = iCustomerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView createCustomer(){
        ModelAndView modelAndView=new ModelAndView("/create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;


    }
    @PostMapping("/save")
    public String save(Customer customer,RedirectAttributes redirectAttributes){
        customer.setId((int) (Math.random()*10000));

iCustomerService.save(customer);
redirectAttributes.addFlashAttribute("success","tạo thành công");
return "redirect:/customers";
    }

@GetMapping("/delete-customer/{id}")
    public String deleteCustomer(@PathVariable int id,RedirectAttributes redirectAttributes){
     try{
         Customer customer=iCustomerService.findById(id);
         iCustomerService.remove(customer.getId());
         redirectAttributes.addFlashAttribute("success","xóa thành công");
         return "redirect:/customers";

     }catch (Exception e){
         e.getMessage();
     }
     return null;
}
@GetMapping("/edit-customer/{id}")
    public String updateCustomer(@PathVariable int id,Model model){

        model.addAttribute("customer",iCustomerService.findById(id));
        return "/update";
}
@PostMapping("/edit-customer")
    public String update(Customer customer,RedirectAttributes redirectAttributes){
iCustomerService.update(customer.getId(),customer);
    redirectAttributes.addFlashAttribute("success","sửa thành công");
    return "redirect:/customers";

}
@GetMapping("/view-customer/{id}")
    public String view(@PathVariable int id,Model model){

        model.addAttribute("customer",iCustomerService.findById(id));

        return "/view";
}
}
