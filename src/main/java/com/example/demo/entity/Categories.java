package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "Travel1")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Sport;
    private String DepartureСategory;
    private String TravelDate;
    private String Price;
    private String Place;
    private Boolean Photograph;
    private String Schedule;
    private String FullName;
    private int age;
    private int weight;
    private Boolean Allergies;
    private String Role;


    public Categories() {
    }

    // Геттеры, сеттеры, и другие методы

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", Sport='" + Sport + '\'' +
                ", DepartureСategory='" + DepartureСategory + '\'' +
                ", TravelDate='" + TravelDate + '\'' +
                ", Price='" + Price + '\'' +
                ", Place='" + Place + '\'' +
                ", Photograph='" + Photograph + '\'' +
                ", Schedule='" + Schedule + '\'' +
                ", FullName='" + FullName + '\'' +
                ", age='" + age + '\'' +
                ", weight='" + weight + '\'' +
                ", Allergies='" + Allergies + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
}