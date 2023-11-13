package com.nishikanta.TrainingPlatformRegistration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nishikanta.TrainingPlatformRegistration.Entity.TrainingSchedule;
import com.nishikanta.TrainingPlatformRegistration.Repository.TrainingScheduleRepository;
import com.nishikanta.TrainingPlatformRegistration.Service.TrainingScheduleService;
import com.nishikanta.TrainingPlatformRegistration.Service.TrainingScheduleServiceImpl;

class TrainingScheduleServiceTest {

    @Mock
    private TrainingScheduleRepository trainingScheduleRepository;

    @InjectMocks
    private TrainingScheduleService trainingScheduleService = new TrainingScheduleServiceImpl();

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTrainingSchedule() {
        TrainingSchedule trainingScheduleToCreate = new TrainingSchedule();
        TrainingSchedule createdTrainingSchedule = new TrainingSchedule();

        when(trainingScheduleRepository.save(trainingScheduleToCreate)).thenReturn(createdTrainingSchedule);

        TrainingSchedule result = trainingScheduleService.createTrainingSchedule(trainingScheduleToCreate);

        // Assert
        assertEquals(createdTrainingSchedule, result);
        verify(trainingScheduleRepository, times(1)).save(trainingScheduleToCreate);
    }

    @Test
    void updateTrainingSchedule() {

        Long trainingScheduleId = 1L;
        TrainingSchedule existingTrainingSchedule = new TrainingSchedule();
        TrainingSchedule updatedTrainingScheduleInfo = new TrainingSchedule();
        TrainingSchedule updatedTrainingSchedule = new TrainingSchedule();

        when(trainingScheduleRepository.findById(trainingScheduleId)).thenReturn(Optional.of(existingTrainingSchedule));
        when(trainingScheduleRepository.save(existingTrainingSchedule)).thenReturn(updatedTrainingSchedule);

        // Act
        TrainingSchedule result = trainingScheduleService.updateTrainingSchedule(trainingScheduleId, updatedTrainingScheduleInfo);

        // Assert
        assertEquals(updatedTrainingSchedule, result);
        verify(trainingScheduleRepository, times(1)).findById(trainingScheduleId);
        verify(trainingScheduleRepository, times(1)).save(existingTrainingSchedule);
    }

    @Test
    void deleteTrainingSchedule() {
      
        Long trainingScheduleId = 1L;
        TrainingSchedule trainingScheduleToDelete = new TrainingSchedule();

        when(trainingScheduleRepository.findById(trainingScheduleId)).thenReturn(Optional.of(trainingScheduleToDelete));

        // Act
        trainingScheduleService.deleteTrainingSchedule(trainingScheduleId);

        // Assert
        verify(trainingScheduleRepository, times(1)).findById(trainingScheduleId);
        verify(trainingScheduleRepository, times(1)).delete(trainingScheduleToDelete);
    }
}

