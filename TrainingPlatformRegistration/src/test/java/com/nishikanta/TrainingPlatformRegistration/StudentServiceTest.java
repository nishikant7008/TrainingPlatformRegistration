package com.nishikanta.TrainingPlatformRegistration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.nishikanta.TrainingPlatformRegistration.Entity.Student;
import com.nishikanta.TrainingPlatformRegistration.Repository.StudentRepository;
import com.nishikanta.TrainingPlatformRegistration.Service.StudentService;
import com.nishikanta.TrainingPlatformRegistration.Service.StudentServiceImpl;

class StudentServiceTest {


    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService = new StudentServiceImpl();

	
    @Test
    void createStudent() {
        // Arrange
        Student studentToCreate = new Student(null, "Nishikanta");
        Student createdStudent = new Student(3L, "Nishikanta");

        when(studentRepository.save(studentToCreate)).thenReturn(createdStudent);

        Student result = studentService.createStudent(studentToCreate);

        // Assert
        assertEquals(createdStudent, result);
        verify(studentRepository, times(1)).save(studentToCreate);
    }

    @Test
    void updateStudent() {
        // Arrange
        Long studentId = 1L;
        Student existingStudent = new Student(studentId, "sashikanta");
        Student updatedStudentInfo = new Student(null, "ram");
        Student updatedStudent = new Student(studentId, "ram");

        when(studentRepository.findById(studentId)).thenReturn(Optional.of(existingStudent));
        when(studentRepository.save(existingStudent)).thenReturn(updatedStudent);

        // Act
        Student result = studentService.updateStudent(studentId, updatedStudentInfo);

        // Assert
        assertEquals(updatedStudent, result);
        verify(studentRepository, times(1)).findById(studentId);
        verify(studentRepository, times(1)).save(existingStudent);
    }

    @Test
    void deleteStudent() {
        Long studentId = 1L;
        Student studentToDelete = new Student(studentId, "sashikanta");

        when(studentRepository.findById(studentId)).thenReturn(Optional.of(studentToDelete));
        studentService.deleteStudent(studentId);

        // Assert
        verify(studentRepository, times(1)).findById(studentId);
        verify(studentRepository, times(1)).delete(studentToDelete);
    }
}
