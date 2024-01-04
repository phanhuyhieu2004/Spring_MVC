package com.example.customermanagementthymeleaf.controller;

import com.example.customermanagementthymeleaf.model.Customer;
import com.example.customermanagementthymeleaf.model.Product;
import com.example.customermanagementthymeleaf.service.CustomerService;
import com.example.customermanagementthymeleaf.service.ICustomerService;
import com.example.customermanagementthymeleaf.service.IProductService;
import com.example.customermanagementthymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


    @Controller
    @RequestMapping("/products")
    public class ProductController {
        private final IProductService productService = new ProductService();

        @GetMapping("")
        public String index(Model model) {

            List<Product> productList = productService.findAll();
            model.addAttribute("products", productList);
            return "/indexs";
        }

        @GetMapping("/creates")
        public String create(Model model) {
            model.addAttribute("product", new Product(

            ));
            return "/creates";
        }

        @PostMapping("/saves")
        public String save(Product product) {
            product.setId((int) (Math.random() * 10000));
            productService.save(product);
            return "redirect:/products";
        }

        @GetMapping("/{id}/edits")
        public String update(@PathVariable int id, Model model) {
            model.addAttribute("product", productService.findById(id));
            return "/updates";
        }

        @PostMapping("/updates")
        public String update(Product product) {
            productService.update(product.getId(), product);
            return "redirect:/products";
        }

        @GetMapping("/{id}/deletes")
        public String delete(@PathVariable int id, Model model) {
            model.addAttribute("product", productService.findById(id));
            return "/deletes";
        }

        @PostMapping("/deletes")
        public String delete(Product product, RedirectAttributes redirect) {
            productService.remove(product.getId());
            redirect.addFlashAttribute("success", "Removed product successfully!");
            return "redirect:/products";
        }

        @GetMapping("/{id}/views")
        public String view(@PathVariable int id, Model model) {
            model.addAttribute("product", productService.findById(id));
            return "/views";
        }
        @GetMapping("/search")
        public String searchByName(@RequestParam("name") String name, Model model) {
            List<Product> searchResults = productService.searchByName(name);
            model.addAttribute("products", searchResults);
            return "/indexs";
        }
}
