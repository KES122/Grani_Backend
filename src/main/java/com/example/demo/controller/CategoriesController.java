package com.example.demo.controller;

import com.example.demo.DTO.CategoriesDTO;
import com.example.demo.entity.Categories;
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
@Tag(name = "Categories")
public class CategoriesController {

    private final CategoriesRepository categoriesRepository;

    @Operation(
            summary = "Get all categories",
            description = "Retrieve a list of all categories"
    )
    @GetMapping("/api/categories")
    public List<Categories> showCategories() {
        return categoriesRepository.findAll();
    }

    @Operation(
            summary = "Create a new category",
            description = "Create a new category with provided information"
    )
    
    @PostMapping("/api/categories/create")
    public ResponseEntity<String> createCategory(@RequestBody CategoriesDTO categoriesDTO) {
        categoriesRepository.save(Categories.builder()
                .id(categoriesDTO.getId())
                .Sport(categoriesDTO.getSport())
                .DepartureСategory(categoriesDTO.getDepartureСategory())
                .TravelDate(categoriesDTO.getTravelDate())
                .Price(categoriesDTO.getPrice())
                .Place(categoriesDTO.getPlace())
                .Photograph(categoriesDTO.getPhotograph())
                .Schedule(categoriesDTO.getSchedule())
                .FullName(categoriesDTO.getFullName())
                .age(categoriesDTO.getAge())
                .weight(categoriesDTO.getWeight())
                .Allergies(categoriesDTO.getAllergies())
                .Role(categoriesDTO.getRole())
                .build());
        return ResponseEntity.status(HttpStatus.CREATED).body("New category created");
    }


    @Operation(
            summary = "Get category by ID",
            description = "Retrieve category by its ID"
    )
    @GetMapping("/api/categories/{id}")
    public ResponseEntity<Categories> getCategoryById(@Parameter(description = "Category ID") @PathVariable int id) {
        return categoriesRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Delete category",
            description = "Delete category by its ID"
    )
    @DeleteMapping("/api/categories/delete/{id}")
    public ResponseEntity<String> deleteCategory(@Parameter(description = "Category ID") @PathVariable int id) {
        categoriesRepository.deleteById(id);
        return ResponseEntity.ok("Category deleted");
    }

    @Operation(
            summary = "Update category information",
            description = "Update category information by its ID"
    )
    @PutMapping("/api/categories/update/{id}")
    public ResponseEntity<String> updateCategory(
            @Parameter(description = "Category ID") @PathVariable int id,
            @RequestBody CategoriesDTO categoriesDTO) {
        if (categoriesRepository.existsById(id)) {
            categoriesRepository.save(Categories.builder()
                    .id(id)
                    .Sport(categoriesDTO.getSport())
                    .DepartureСategory(categoriesDTO.getDepartureСategory())
                    .TravelDate(categoriesDTO.getTravelDate())
                    .Price(categoriesDTO.getPrice())
                    .Place(categoriesDTO.getPlace())
                    .Photograph(categoriesDTO.getPhotograph())
                    .Schedule(categoriesDTO.getSchedule())
                    .FullName(categoriesDTO.getFullName())
                    .age(categoriesDTO.getAge())
                    .weight(categoriesDTO.getWeight())
                    .Allergies(categoriesDTO.getAllergies())
                    .Role(categoriesDTO.getRole())
                    .build());
            return ResponseEntity.ok("Category updated");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such category");
    }
}
