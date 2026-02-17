package com.pricewatch.demo.dto;
import jakarta.validation.constraints.*;
import com.pricewatch.demo.model.enumerate.*;
import lombok.*;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProductDto {
    private Long id; 

    @NotBlank(message = "Nazwij swój produkt")
    @Size(max = 50, message= "Niemożliwe że ta rzecz ma tak długą nazwę")
    private String productName;

    @NotBlank(message = "Przyporzadkuj produkt pod jakąś kategorię")
    private Category category;


    @NotBlank(message = "Chcesz dodać rzecz bez linka?")
    private String httpPath;
    
    
    private double originalPrice;

    private double currentPrice;


    //saving product constructor
    public ProductDto(String productName, Category category, String httpPath){
        this.productName = productName;
        this.category = category;
        this.httpPath = httpPath;
    }

    //all args constructor dla zwracania produktu z backendu









}
