package com.pricewatch.demo.model.entity;
import jakarta.persistence.*;
import com.pricewatch.demo.model.enumerate.Category;
import lombok.*;



@Entity
@Table(name = "products")
@Getter @Setter @NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private String httpPath;

    @Column(nullable = false)
    private double originalPrice;

    @Column(nullable = false)
    private double currentPrice;


    public Product(String productName, Category category, String httpPath, double originalPrice, double currentPrice) {
        this.productName = productName;
        this.category = category;
        this.httpPath = httpPath;
        this.originalPrice = originalPrice;
        this.currentPrice = originalPrice; //to moze byc tricky zalezy jak dalej dziala apka
    }






}
