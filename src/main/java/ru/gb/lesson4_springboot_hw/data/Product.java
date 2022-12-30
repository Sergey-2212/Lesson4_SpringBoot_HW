package ru.gb.lesson4_springboot_hw.data;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String title;
    private Double cost;
    private static Long count = 1L;

    public Product(String title, Double cost) {
        this.id = count++;
        this.title = title;
        this.cost = cost;
    }
}
