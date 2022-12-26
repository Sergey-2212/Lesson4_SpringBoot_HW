package ru.gb.lesson4_springboot_hw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.lesson4_springboot_hw.data.Product;
import ru.gb.lesson4_springboot_hw.services.ProductService;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/all")
    public List<Product> getAllProducts() {
       return productService.getAllProducts();
    }

    @GetMapping("/products/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/products/change_score")
    //название параметра метода в контроллере должно совпадать с названием этого параметра в GET запросе
    public void changeCost(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeCost(productId, delta);
    }
}
