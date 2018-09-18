package com.example.example_db_auth.controllers;

import com.example.example_db_auth.domain.Product;
import com.example.example_db_auth.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String home() {
        return "home";

    }

    @GetMapping("/main")
    public String main(Model model) {
        Iterable<Product> products = productRepository.findAll();

        model.addAttribute("products", products);
        return "main";
    }

    @PostMapping("add")
    public String add(@RequestParam String name, @RequestParam String dateOfSupply, Model model) {
        Product product = new Product(name, dateOfSupply);

        productRepository.save(product);

        Iterable<Product> products = productRepository.findAll();

        model.addAttribute("products", products);

        return "main";
    }

    @PostMapping("findByName")
    public String findByName(@RequestParam String name, Model model) {
        Iterable<Product> products;

        if (name != null && !name.isEmpty()) {
            products = productRepository.findByName(name);
        } else {
            products = productRepository.findAll();
        }

        model.addAttribute("products", products);

        return "main";
    }

    @PostMapping("deleteAllProducts")
    public String deleteAllProducts(Model model) {
        productRepository.deleteAll();
        Iterable<Product> products = productRepository.findAll();

        model.addAttribute("products", products);

        return "main";
    }
}