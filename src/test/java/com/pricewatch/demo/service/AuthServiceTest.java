package com.pricewatch.demo.service;

import com.pricewatch.demo.exception.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pricewatch.demo.model.entity.User;
import com.pricewatch.demo.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;
import com.pricewatch.demo.model.entity.*;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    @Mock
    UserRepository userRepository;

    @Mock
    Authentication authentication;

    @Mock
    SecurityContext securityContext;

    @Mock
    AnonymousAuthenticationToken anonymousAuthenticationToken;

    @InjectMocks
    AuthService authService;

    User user;
    @BeforeEach
    void setUp(){
        SecurityContextHolder.clearContext();
        user = new User("testuser", "password", "test@mail.com");
        SecurityContextHolder.setContext(securityContext);


    }

    @Test
    void getCurrentUserOrThrow_ShouldReturnUser_WhenAuthIsNotNullAndIsNotAnonymousAuthenticationToken(){
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getName()).thenReturn(user.getUsername());
        when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.of(user));


        User foundUser = authService.getCurrentUserOrThrow();

        assertThat(foundUser).isSameAs(user);
        assertThat(foundUser.getUsername()).isEqualTo(user.getUsername());
        verify(userRepository).findByUsername(user.getUsername());
    }
    @Test
    void getCurrentUserOrThrow_ShouldThrowUserNotFoundException_WhenAuthIsNull(){
        when(securityContext.getAuthentication()).thenReturn(null);

        assertThatThrownBy(() -> authService.getCurrentUserOrThrow())
                .isInstanceOf(UserNotFoundException.class)
                .hasMessage("User not found");

        verifyNoInteractions(userRepository);
    }

    @Test
    void getCurrentUserOrThrow_ShouldThrowUserNotFoundException_WhenAuthIsAnonymousAuthenticationToken(){
        when(securityContext.getAuthentication()).thenReturn(anonymousAuthenticationToken);

        assertThatThrownBy(() -> authService.getCurrentUserOrThrow())
                .isInstanceOf(UserNotFoundException.class)
                .hasMessage("User not found");

        verifyNoInteractions(userRepository);

    }

    @Test
    void getCurrentUserOrThrow_ShouldThrowUserNotFoundException_WhenUserDoesntExistInRepository(){
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getName()).thenReturn(user.getUsername());
        when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> authService.getCurrentUserOrThrow())
                .isInstanceOf(UserNotFoundException.class)
                .hasMessage("User not found");

        verify(userRepository).findByUsername(user.getUsername());
    }
}
