package com.example.demo.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoriesDTO {
    int id;
    String Sport;
    String DepartureСategory;
    String TravelDate;
    String Price;
    String Place;
    Boolean Photograph;
    String Schedule;
    String FullName;
    int age;
    int weight;
    Boolean Allergies;
    String Role;
}
