package com.nishikanta.TrainingPlatformRegistration.Service;

import java.util.List;

import com.nishikanta.TrainingPlatformRegistration.Entity.Student;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student createStudent(Student student);

    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);
}

