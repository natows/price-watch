package com.pricewatch.demo.service;
import com.pricewatch.demo.scrapper.Scrapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import com.pricewatch.demo.repository.*;
import com.pricewatch.demo.service.*;
import com.pricewatch.demo.model.entity.*;
import com.pricewatch.demo.dto.*;
import org.springframework.transaction.annotation.Transactional;
import com.pricewatch.demo.scrapper.*;
import com.pricewatch.demo.mapper.*;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final Scrapper scrapper;


    @Transactional
    public Product getOrCreateProduct(ProductDto productDto){
        double scrappedPrice = getScrappedPrice(productDto.getHttpPath());

        Product product =  productRepository.findByHttpPath(productDto.getHttpPath())
                .map( existingProduct -> updatePriceIfChanged(existingProduct, scrappedPrice))     
                .orElseGet(() -> createNewProduct(productDto, scrappedPrice));
        return product;

    }

    public double getScrappedPrice(String HttpPath){
        try{
            return scrapper.scrapPrice(HttpPath);
        }
        catch (RuntimeException e){
            throw new RuntimeException("error scrapping price", e);
        }

    }

    private Product updatePriceIfChanged(Product product, double scrappedPrice){
        if (product.getCurrentPrice() != scrappedPrice){
                product.setCurrentPrice(scrappedPrice);
                //notify watchers w przyszlosci
        }
        return product;

    }


    @Transactional
    public Product createNewProduct(ProductDto productDto, double price){
        Product newProduct = new Product(productDto.getProductName(), productDto.getCategory(), productDto.getHttpPath(), price, price);
        return productRepository.save(newProduct);
    }


    



    
}
