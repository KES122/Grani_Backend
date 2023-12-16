package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "questionnaires")
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_of_sport")
    private String typeOfSport;

    @Column(name = "departure_category")
    private String departureCategory;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "photograph")
    private boolean photograph;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "photo")
    private String photo;

    // Другие поля, конструкторы, геттеры, сеттеры и т.д.

    // Геттеры и сеттеры для полей
    public void setId(Long id) {
        this.id = id;
    }
    public String getTypeOfSport() {
        return typeOfSport;
    }

    public void setTypeOfSport(String typeOfSport) {
        this.typeOfSport = typeOfSport;
    }

    public String getDepartureCategory() {
        return departureCategory;
    }

    public void setDepartureCategory(String departureCategory) {
        this.departureCategory = departureCategory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean getPhotograph() {
        return photograph;
    }

    public void setPhotograph(boolean photograph) {
        this.photograph = photograph;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}