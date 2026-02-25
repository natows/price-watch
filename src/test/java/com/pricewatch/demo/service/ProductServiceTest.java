package com.pricewatch.demo.service;
import com.pricewatch.demo.dto.ProductDto;
import com.pricewatch.demo.mapper.ProductMapper;
import com.pricewatch.demo.model.enumerate.Category;
import com.pricewatch.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pricewatch.demo.model.entity.User;
import com.pricewatch.demo.repository.UserRepository;
import com.pricewatch.demo.scrapper.Scrapper;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import com.pricewatch.demo.model.entity.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    ProductRepository productRepository;
    @Mock
    UserService userService;
    @Mock
    ProductMapper productMapper;
    @Mock
    Scrapper scrapper;

    @InjectMocks
    ProductService productService;

//    @Test
//    void addWatchedProduct_ShouldCreateNewAndAddProduct(){
//        Long id = 1L;
//        String name = "bialeczko KFD";
//        Category category = Category.FOOD;
//        String httpPath = "path";
//        double price = 100.0;
//        ProductDto inputProduct = new ProductDto(name,category,httpPath);
//        Product savedProduct = new Product(name,category,httpPath,price,price);
//        ProductDto returnedProduct = new ProductDto(name,category,httpPath);
//
//        when(productRepository.findByHttpPath(httpPath)).thenReturn(Optional.empty());
//        when(scrapper.scrapPrice(httpPath)).thenReturn(price);
//        when(productRepository.save(any(Product.class))).thenReturn(savedProduct);
//        when(productMapper.toDto(savedProduct)).thenReturn(returnedProduct);
//
//        ProductDto result = productService.addWatchedProduct(inputProduct);
//
//        ArgumentCaptor<Product> productCaptor = ArgumentCaptor.forClass(Product.class);
//        verify(productRepository).save(productCaptor.capture());
//
//        Product capturedProduct = productCaptor.getValue();
//        assertThat(capturedProduct.getCurrentPrice()).isEqualTo(price);
//        assertThat(capturedProduct.getProductName()).isEqualTo("bialeczko KFD");
//
//        assertEquals(name, result.getProductName());
//    }
}
