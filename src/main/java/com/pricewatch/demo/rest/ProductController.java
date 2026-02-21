package com.pricewatch.demo.rest;
import lombok.*;

import org.springframework.web.bind.annotation.PostMapping;

import com.pricewatch.demo.service.*;
import com.pricewatch.demo.dto.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // @PostMapping("/add")
    // public ProductDto addWatchedProduct(@RequestBody ProductDto product) {
    //     return productService.addWatchedProduct(product);

    // }
    @PostMapping("/proba")
    public double getProductPrice(@RequestBody ProductDto product){
        return productService.getProductPrice(product);
    }

    
}
