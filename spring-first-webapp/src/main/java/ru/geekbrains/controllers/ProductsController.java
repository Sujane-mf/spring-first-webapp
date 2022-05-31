package ru.geekbrains.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.model.Product;
import ru.geekbrains.services.ProductsService;

import java.util.List;

@Controller

public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    // GET http://localhost:8189/app/product/show_all
    @GetMapping("product/show_all")

    public String showProductsPage(Model model){
        model.addAttribute("products", productsService.showAll());
        return "products";
    }

    // GET http://localhost:8189/app/product/show_product/{id}
    @GetMapping("product/show_product/{id}")

    public String showProductPageById(Model model, @PathVariable Long id){
        model.addAttribute("product", productsService.getProductByID(id));
        return "product_info";
    }

    // GET http://localhost:8189/app/product/create
    @GetMapping("product/create")

    public String createProduct(){
        return "create_product";
    }

    // POST http://localhost:8189/app/product/create
    @PostMapping("product/create")

    public String saveProduct(@RequestParam long id, @RequestParam String name, @RequestParam int cost){
        productsService.createProduct(new Product(id, name,cost));
        return "redirect:/product/show_all";
    }
}
