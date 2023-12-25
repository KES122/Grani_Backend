package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;


    public User() {
    }
}
