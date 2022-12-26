package ru.gb.lesson4_springboot_hw.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.gb.lesson4_springboot_hw.data.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product("Grain",78.0 ),
                new Product("Milk", 98.0),
                new Product("Apple", 124.55)
        ));
    }

    public Product getProductById(Long id) {
        return products.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public void deleteProduct(Long id) {
        products.removeIf(s -> s.getId().equals(id));
    }



}
