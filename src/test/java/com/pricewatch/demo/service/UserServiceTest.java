package com.pricewatch.demo.service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pricewatch.demo.model.entity.User;
import com.pricewatch.demo.repository.UserRepository;

import static org.mockito.Mockito.*;
import com.pricewatch.demo.model.entity.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock 
    private AuthService authService;

    @InjectMocks
    private UserService userService;

    @Test 
    void addProductToUserWatchList_ShouldAddProduct(){
        Product product = new Product();
        User user = new User();
        user.setWatchedProducts(new HashSet<>());

        when(authService.getCurrentUser()).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.addProductToUserWatchList(product);

        assertThat(result.getWatchedProducts()).contains(product);
        verify(authService).getCurrentUser();
        verify(userRepository).save(user);
    }
    
}
