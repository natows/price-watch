package com.pricewatch.demo.service;

import com.pricewatch.demo.exception.UserNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import com.pricewatch.demo.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.pricewatch.demo.model.entity.*;

import java.util.Optional;

@Service 
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public Optional<User> getCurrentUserOptional(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth instanceof AnonymousAuthenticationToken){
            return Optional.empty();
        }
        return userRepository.findByUsername(auth.getName());
    }

    public User getCurrentUserOrThrow(){
        return getCurrentUserOptional().orElseThrow(UserNotFoundException::new);
    }

    public Long getCurrentUserId(){
        return getCurrentUserOrThrow().getId();
    }


}
