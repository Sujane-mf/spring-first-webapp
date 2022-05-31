package ru.geekbrains.repositories;

import org.springframework.stereotype.Controller;
import ru.geekbrains.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class ProductsRepository {
    private List<Product> products;

    @PostConstruct
    public void init(){
        this.products = new ArrayList<>();
        products.add(new Product(1L,"Milk",5));
        products.add(new Product(2L,"Book",10));
        products.add(new Product(3L,"Box",1));
        products.add(new Product(4L,"Plate",7));
        products.add(new Product(5L,"Cup",3));

    }
    // метод для просмотра всего списка товаров
    public List<Product> showAll(){
        return Collections.unmodifiableList(products);
    }

    // метод для поиска товаров по ID
    public Product getProductByID(Long id){return products.stream().filter(s -> s.getId().equals(id)).findFirst().get();}

    // метод для создания товара
    public void createProduct(Product product){
        products.add(product);
    }

    // метод для увеличения цены товара
    public void increaseTheCost(long id){
        getProductByID(id).setCost(getProductByID(id).getCost()+1);
    }

    //метод для уменьшения цены товара
    public void decreaseTheCost(long id){
        getProductByID(id).setCost(getProductByID(id).getCost()-1);
    }

}
