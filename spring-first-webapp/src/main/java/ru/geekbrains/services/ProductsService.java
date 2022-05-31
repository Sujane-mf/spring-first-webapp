package ru.geekbrains.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.model.Product;
import ru.geekbrains.repositories.ProductsRepository;

import java.util.Collections;
import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> showAll(){
        return productsRepository.showAll();
    }

    public Product getProductByID(Long id){
        return productsRepository.getProductByID(id);
    }

    public void createProduct(Product product){
        productsRepository.createProduct(product);
    }
}
