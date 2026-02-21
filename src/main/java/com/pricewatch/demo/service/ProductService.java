package com.pricewatch.demo.service;
import com.pricewatch.demo.repository.ProductRepository;
import com.pricewatch.demo.scrapper.Scrapper;

import org.springframework.stereotype.Service;
import com.pricewatch.demo.repository.*;
import com.pricewatch.demo.model.entity.*;
import com.pricewatch.demo.dto.*;
import org.springframework.transaction.annotation.Transactional;
import com.pricewatch.demo.scrapper.*;
import com.pricewatch.demo.mapper.*;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final Scrapper scrapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper, Scrapper scrapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.scrapper = scrapper;
    }

    // @Transactional
    // public ProductDto addWatchedProduct(ProductDto productDto){
    //     double scrappedPrice = scrapper.scrapPrice(productDto.getHttpPath());
    //     Product product = new Product(productDto.getProductName(), productDto.getCategory(), productDto.getHttpPath(), scrappedPrice, scrappedPrice);
    //     Product savedProduct = productRepository.save(product);
    //     return productMapper.toDto(savedProduct);
 
    // }


    public double getProductPrice(ProductDto product){
        return scrapper.scrapPrice(product.getHttpPath());
    }



    
}
