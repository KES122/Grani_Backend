package com.example.demo.controller;

import com.example.demo.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
    // Можете добавить дополнительные методы запросов, если необходимо
}