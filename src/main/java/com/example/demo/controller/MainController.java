package com.example.demo.controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "User")
public class MainController {

    private final UserRepository userRepository;
    @Operation(
            summary = "Get all users",
            description = "Retrieve a list of all users"
    )
    @GetMapping("/api/show")
    public List<User> showUsers() {
        return userRepository.findAll();
    }

    @Operation(
            summary = "Register a new user",
            description = "Register a new user with provided information"
    )
    @PostMapping("/api/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        userRepository.save(User.builder()
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build());
        return ResponseEntity.status(HttpStatus.CREATED).body("New user registered");
    }

    @Operation(
            summary = "Login user",
            description = "Authenticate user based on email and password"
    )
    @PostMapping("/api/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        User foundUser = userRepository.findByEmail(user.getEmail());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
    }

    @Operation(
            summary = "Get user by ID",
            description = "Retrieve user by their ID"
    )
    @GetMapping("/api/user/{id}")
    public ResponseEntity<User> getUserById(@Parameter(description = "User ID") @PathVariable int id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Delete user",
            description = "Delete user by their ID"
    )
    @DeleteMapping("/api/delete/{id}")
    public ResponseEntity<String> deleteUser(@Parameter(description = "User ID") @PathVariable int id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok("User deleted");
    }

    @Operation(
            summary = "Update user information",
            description = "Update user information by their ID"
    )
    @PutMapping("/api/update/{id}")
    public ResponseEntity<String> updateUser(
            @Parameter(description = "User ID") @PathVariable int id,
            @RequestBody User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            userRepository.save(user);
            return ResponseEntity.ok("User updated");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such user");
    }
}
