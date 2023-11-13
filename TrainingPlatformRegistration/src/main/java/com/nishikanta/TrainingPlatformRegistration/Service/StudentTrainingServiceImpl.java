package com.nishikanta.TrainingPlatformRegistration.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nishikanta.TrainingPlatformRegistration.Entity.StudentTraining;
import com.nishikanta.TrainingPlatformRegistration.ExceptionHandler.ResourceNotFoundException;
import com.nishikanta.TrainingPlatformRegistration.Repository.StudentTrainingRepository;

import java.util.List;

@Service
@Transactional
public class StudentTrainingServiceImpl implements StudentTrainingService {

    @Autowired
    private StudentTrainingRepository studentTrainingRepository;

    @Override
    public List<StudentTraining> getAllStudentTrainings() {
        return studentTrainingRepository.findAll();
    }

    @Override
    public StudentTraining getStudentTrainingById(Long id) {
        return studentTrainingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("StudentTrainning not found with id: " + id));
    }

    @Override
    public StudentTraining createStudentTraining(StudentTraining studentTraining) {
        return studentTrainingRepository.save(studentTraining);
    }

    @Override
    public StudentTraining updateStudentTraining(Long id, StudentTraining studentTraining) {
        studentTraining.setId(id);
        return studentTrainingRepository.save(studentTraining);
    }

    @Override
    public void deleteStudentTraining(Long id) {
        studentTrainingRepository.deleteById(id);
    }
}
