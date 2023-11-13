package com.nishikanta.TrainingPlatformRegistration.Service;

import java.util.List;

import com.nishikanta.TrainingPlatformRegistration.Entity.StudentTraining;

public interface StudentTrainingService {
    List<StudentTraining> getAllStudentTrainings();

    StudentTraining getStudentTrainingById(Long id);

    StudentTraining createStudentTraining(StudentTraining studentTraining);

    StudentTraining updateStudentTraining(Long id, StudentTraining studentTraining);

    void deleteStudentTraining(Long id);
}

