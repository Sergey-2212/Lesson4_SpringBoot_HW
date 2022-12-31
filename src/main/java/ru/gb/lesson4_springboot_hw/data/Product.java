package ru.gb.lesson4_springboot_hw.data;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private Double cost;

       public Product() {
    }

    public Product(String title, Double cost) {
        this.title = title;
        this.cost = cost;
    }
}
