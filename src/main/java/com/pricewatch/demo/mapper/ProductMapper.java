package com.pricewatch.demo.mapper;

import com.pricewatch.demo.dto.ProductDto;
import com.pricewatch.demo.model.entity.*;
import org.springframework.stereotype.Component;



@Component
public class ProductMapper {

    public Product toEntity(ProductDto dto) {
        return new Product(dto.getProductName(), dto.getCategory(), dto.getHttpPath());
    }

    public ProductDto toDto(Product entity) {
        return new ProductDto(entity.getId(), entity.getProductName(), entity.getCategory(), entity.getHttpPath(), entity.getOriginalPrice(), entity.getCurrentPrice());
    }
    
}
