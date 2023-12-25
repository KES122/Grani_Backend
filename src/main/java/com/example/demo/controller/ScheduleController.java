package com.example.demo.controller;


import com.example.demo.entity.Schedule;
import com.example.demo.repository.ScheduleRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/schedule")
@Tag(name = "Schedule")

public class ScheduleController {
    private final ScheduleRepository scheduleRepository;
    @GetMapping
    public List<Schedule> addSchedule(){
        return scheduleRepository.findAll();
    }
    @Operation(summary = "Создание расписания", responses = {
            @ApiResponse(responseCode = "200", description = "Успешно создано",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Schedule.class))}),
            @ApiResponse(responseCode = "400", description = "Неверный запрос",
                    content = @Content),
    })
    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleRepository.save(schedule);
    }
    @Operation(summary = "Удаление расписания по ID", responses = {
            @ApiResponse(responseCode = "204", description = "Успешно удалено"),
            @ApiResponse(responseCode = "404", description = "Расписание не найдено",
                    content = @Content),
    })

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        scheduleRepository.deleteById(id);
    }
    @Operation(summary = "Обновление расписания по ID", responses = {
            @ApiResponse(responseCode = "200", description = "Успешно обновлено",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Schedule.class)) }),
            @ApiResponse(responseCode = "404", description = "Расписание не найдено",
                    content = @Content),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(
            @PathVariable Long id,
            @RequestBody Schedule updatedSchedule
    ) {
        return scheduleRepository.findById(id)
                .map(schedule -> {
                    schedule.setWeekDay(updatedSchedule.getWeekDay());
                    schedule.setEventName(updatedSchedule.getEventName());
                    schedule.setTime(updatedSchedule.getTime());
                    schedule.setDuration(updatedSchedule.getDuration());
                    scheduleRepository.save(schedule);
                    return ResponseEntity.ok(schedule);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}


