package com.motivus.Exercise.service;

import com.motivus.Exercise.model.UserAuth;
import com.motivus.Exercise.repository.UserAuthRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    private final UserAuthRepository userAuthRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserAuthRepository userAuthRepository, PasswordEncoder passwordEncoder) {
        this.userAuthRepository = userAuthRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpiration;


    public UserAuth registerUser(String username, String password, String role) {
        UserAuth user = new UserAuth();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        return userAuthRepository.save(user);
    }

    public Optional<UserAuth> findByUsername(String username) {
        return userAuthRepository.findByUsername(username);
    }

    public List<UserAuth> getAllUsers(){
        return userAuthRepository.findAll();
    }
    public void deleteUser(Long id){
        userAuthRepository.deleteById(id);
    }

    public UserAuth updateUser(Long id, UserAuth user){
        user.setId(id);
        return userAuthRepository.save(user);
    }
}
