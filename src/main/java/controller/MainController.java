package controller;

import com.example.demo.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @GetMapping("/api/show")
    public String showUsers() {
        List<User> users = userRepository.findAll();
        return objectMapper.writeValueAsString(users);
    }

    @PostMapping(value = "/api/register", consumes = "application/json")
    public void registerUser(@RequestBody User user) {
        log.info("New user registered: " + userRepository.save(user));
        if (userRepository.findByPassword(user.getPassword()) != null) {
            // Если пользователь с таким паролем уже существует
            throw new IllegalArgumentException("This password is taken");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            // Если пользователь с таким же email уже существует
            throw new IllegalArgumentException("Email should be unique");
        }
        log.info("New user registered: " + userRepository.save(user));
    }

    @PostMapping(value = "/api/login", consumes = "application/json")
    public String loginUser(@RequestBody User user) {
        User foundUser = userRepository.findByEmail(user.getEmail());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return "Login successful";
        }
        return "Login failed";
    }

    @GetMapping("/api/user")
    public User getUserById(@RequestParam int id) {
        return userRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/api/delete")
    public void deleteUser(@RequestParam int id) {
        userRepository.deleteById(id);
    }

    @PutMapping(value = "/api/update", consumes = "application/json")
    public String updateUser(@RequestBody User user) {
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user).toString();
        }
        return "No such user";
    }
}
