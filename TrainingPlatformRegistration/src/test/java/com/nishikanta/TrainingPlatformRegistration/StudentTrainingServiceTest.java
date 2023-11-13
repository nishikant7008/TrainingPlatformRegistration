package com.nishikanta.TrainingPlatformRegistration;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nishikanta.TrainingPlatformRegistration.Entity.StudentTraining;
import com.nishikanta.TrainingPlatformRegistration.Repository.StudentTrainingRepository;
import com.nishikanta.TrainingPlatformRegistration.Service.StudentTrainingService;
import com.nishikanta.TrainingPlatformRegistration.Service.StudentTrainingServiceImpl;

class StudentTrainingServiceTest {

    @Mock
    private StudentTrainingRepository studentTrainingRepository;

    @InjectMocks
    private StudentTrainingService studentTrainingService = new StudentTrainingServiceImpl();

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createStudentTraining() {

        StudentTraining studentTrainingToCreate = new StudentTraining();
        StudentTraining createdStudentTraining = new StudentTraining();

        when(studentTrainingRepository.save(studentTrainingToCreate)).thenReturn(createdStudentTraining);

        StudentTraining result = studentTrainingService.createStudentTraining(studentTrainingToCreate);

        // Assert
        assertEquals(createdStudentTraining, result);
        verify(studentTrainingRepository, times(1)).save(studentTrainingToCreate);
    }

    @Test
    void updateStudentTraining() {
    	Long studentTrainingId = 1L;
        StudentTraining existingStudentTraining = new StudentTraining();
        StudentTraining updatedStudentTrainingInfo = new StudentTraining();
        StudentTraining updatedStudentTraining = new StudentTraining();

        when(studentTrainingRepository.findById(studentTrainingId)).thenReturn(Optional.of(existingStudentTraining));
        when(studentTrainingRepository.save(existingStudentTraining)).thenReturn(updatedStudentTraining);

        // Act
        StudentTraining result = studentTrainingService.updateStudentTraining(studentTrainingId, updatedStudentTrainingInfo);

        // Assert
        assertEquals(updatedStudentTraining, result);
        verify(studentTrainingRepository, times(1)).findById(studentTrainingId);
        verify(studentTrainingRepository, times(1)).save(existingStudentTraining);
    }

    @Test
    void deleteStudentTraining() {
        Long studentTrainingId = 1L;
        StudentTraining studentTrainingToDelete = new StudentTraining();

        when(studentTrainingRepository.findById(studentTrainingId)).thenReturn(Optional.of(studentTrainingToDelete));

        studentTrainingService.deleteStudentTraining(studentTrainingId);

        // Assert
        verify(studentTrainingRepository, times(1)).findById(studentTrainingId);
        verify(studentTrainingRepository, times(1)).delete(studentTrainingToDelete);
    }
}

