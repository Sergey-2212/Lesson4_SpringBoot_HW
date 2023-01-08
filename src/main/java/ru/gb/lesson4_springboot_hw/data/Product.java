package ru.gb.lesson4_springboot_hw.data;;
import lombok.Data;
import jakarta.persistence.*;



@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
