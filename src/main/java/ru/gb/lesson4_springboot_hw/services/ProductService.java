package ru.gb.lesson4_springboot_hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.lesson4_springboot_hw.data.Product;
import ru.gb.lesson4_springboot_hw.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    @Autowired
    public void setRepository(ProductRepository repository) {
        this.productRepository = repository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void deleteProductById(Long id) {
        productRepository.deleteProduct(id);
    }

    public void changeCost(Long id, Integer delta) {
        System.out.println("ProdServ: Id - " + id + " delta - " + delta);
        Product product = productRepository.getProductById(id);
        productRepository.updateCostById(id, product.getCost() + delta); //протестировать
    }

    public void addNewProduct(String productTitle, Double productCost) {
        productRepository.addNewProduct(new Product(productTitle, productCost));
    }
}
