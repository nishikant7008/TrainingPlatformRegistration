package com.nishikanta.TrainingPlatformRegistration.Service;

import java.util.List;

import com.nishikanta.TrainingPlatformRegistration.Entity.TrainingSchedule;

public interface TrainingScheduleService {
    List<TrainingSchedule> getAllTrainingSchedules();

    TrainingSchedule getTrainingScheduleById(Long id);

    TrainingSchedule createTrainingSchedule(TrainingSchedule trainingSchedule);

    TrainingSchedule updateTrainingSchedule(Long id, TrainingSchedule trainingSchedule);

    void deleteTrainingSchedule(Long id);
}

