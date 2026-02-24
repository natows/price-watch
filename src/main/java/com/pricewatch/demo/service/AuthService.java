package com.pricewatch.demo.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import com.pricewatch.demo.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.pricewatch.demo.model.entity.*;

@Service 
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public User getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth instanceof AnonymousAuthenticationToken){
            return null;
        }
        return userRepository.findByUsername(auth.getName()).orElseThrow(() -> new RuntimeException("user not found"));
    }

    public Long getCurrentUserId(){
        return getCurrentUser().getId(); 
    }
}
