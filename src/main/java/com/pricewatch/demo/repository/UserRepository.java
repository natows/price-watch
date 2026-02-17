package com.pricewatch.demo.repository;
import com.pricewatch.demo.model.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
    User findByEmail(String email);

    @Query("SELECT p FROM User u JOIN u.watchedProducts p WHERE u.id = :id")
    Page<Product> getUserWatchedProducts(@Param("id") Long id, Pageable pageable);
}
