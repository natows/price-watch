package com.pricewatch.demo.repository;
import com.pricewatch.demo.model.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductRepository extends JpaRepository<Product, Long> {
    //optional find by id juz chyba domyslnie?

    
}
