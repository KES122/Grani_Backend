package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import com.example.demo.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.EventRepository;

import java.util.List;

@Api(description = "Иллюстрация работы")
@RestController
@RequestMapping (EventController.PATH)
@RequiredArgsConstructor
public class EventController{

    public static final String PATH = "/api";

    @Autowired
    private EventRepository eventRepository;

    @ApiOperation("Найти всё")
    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @ApiOperation("Найти id")
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @ApiOperation("Сохранить всё")
    @PostMapping
    public Event createEvent(@RequestBody Event event)
    {
        return eventRepository.save(event);
    }


    @ApiOperation("Найти Имя, Дату и Локацию")
    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
        Event existingEvent = eventRepository.findById(id).orElse(null);
        if (existingEvent != null) {
            // Используйте сеттеры для обновления значений
            existingEvent.setName(updatedEvent.getName());
            existingEvent.setDate(updatedEvent.getDate());
            existingEvent.setLocation(updatedEvent.getLocation());
            return eventRepository.save(existingEvent);
        } else {
            return null;
        }
    }

    @ApiOperation("Удалить id")
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventRepository.deleteById(id);
    }
}
