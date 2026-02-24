package com.pricewatch.demo.service;

import com.pricewatch.demo.scrapper.Scrapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import com.pricewatch.demo.repository.*;
import com.pricewatch.demo.model.entity.*;
import com.pricewatch.demo.dto.*;
import org.springframework.transaction.annotation.Transactional;
import com.pricewatch.demo.scrapper.*;
import com.pricewatch.demo.mapper.*;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthService authService;


    public User addProductToUserWatchList(Product product){
        User user = authService.getCurrentUser();
        user.getWatchedProducts().add(product);
        return userRepository.save(user);
    }

    
}
