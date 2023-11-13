package com.nishikanta.TrainingPlatformRegistration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nishikanta.TrainingPlatformRegistration.Entity.TrainingSchedule;
import com.nishikanta.TrainingPlatformRegistration.Service.TrainingScheduleService;

import java.util.List;

@RestController
@RequestMapping("/api/training-schedules")
public class TrainingScheduleController {

    @Autowired
    private TrainingScheduleService trainingScheduleService;

    @GetMapping
    public List<TrainingSchedule> getAllTrainingSchedules() {
        return trainingScheduleService.getAllTrainingSchedules();
    }

    @GetMapping("/{id}")
    public TrainingSchedule getTrainingScheduleById(@PathVariable Long id) {
        return trainingScheduleService.getTrainingScheduleById(id);
    }

    @PostMapping
    public TrainingSchedule createTrainingSchedule(@RequestBody TrainingSchedule trainingSchedule) {
        return trainingScheduleService.createTrainingSchedule(trainingSchedule);
    }

    @PutMapping("/{id}")
    public TrainingSchedule updateTrainingSchedule(@PathVariable Long id, @RequestBody TrainingSchedule trainingSchedule) {
        return trainingScheduleService.updateTrainingSchedule(id, trainingSchedule);
    }

    @DeleteMapping("/{id}")
    public void deleteTrainingSchedule(@PathVariable Long id) {
        trainingScheduleService.deleteTrainingSchedule(id);
    }
}

