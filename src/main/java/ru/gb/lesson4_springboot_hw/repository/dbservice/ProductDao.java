package ru.gb.lesson4_springboot_hw.repository.dbservice;

import ru.gb.lesson4_springboot_hw.data.Product;

import java.util.List;

public interface ProductDao {
    Product getProductById(Long id);

    List<Product> getAllProducts();

    void deleteProduct(Long id);

    void addNewProduct(Product product);

    void saveOrUpdate(Product product);
}
