package com.pricewatch.demo.service;
import com.pricewatch.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import com.pricewatch.demo.repository.*;
import com.pricewatch.demo.model.entity.*;
import com.pricewatch.demo.dto.*;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // @Transactional
    // public Product addWatchedProduct(ProductDto productDto){
        
    // }



    
}
