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
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void deleteProductById(Long id) {
        productRepository.deleteProduct(id);
    }

    public void changeCost(Long id, Integer delta) {
        Product product = productRepository.getProductById(id);
        product.setCost(product.getCost() + delta);
    }
}
