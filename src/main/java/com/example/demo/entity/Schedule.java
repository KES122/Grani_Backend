package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String weekDay;
    private String eventName;
    @Column(columnDefinition = "TIME")
    private String time;
    private String duration;

    // Constructors, getters, setters, and other methods

    public Schedule() {
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", weekDay='" + weekDay + '\'' +
                ", eventName='" + eventName + '\'' +
                ", time='" + time + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}

