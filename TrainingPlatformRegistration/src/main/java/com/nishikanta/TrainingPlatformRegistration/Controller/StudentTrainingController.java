package com.nishikanta.TrainingPlatformRegistration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nishikanta.TrainingPlatformRegistration.Entity.StudentTraining;
import com.nishikanta.TrainingPlatformRegistration.Service.StudentTrainingService;

import java.util.List;

@RestController
@RequestMapping("/api/student-trainings")
public class StudentTrainingController {

    @Autowired
    private StudentTrainingService studentTrainingService;

    @GetMapping
    public List<StudentTraining> getAllStudentTrainings() {
        return studentTrainingService.getAllStudentTrainings();
    }

    @GetMapping("/{id}")
    public StudentTraining getStudentTrainingById(@PathVariable Long id) {
        return studentTrainingService.getStudentTrainingById(id);
    }

    @PostMapping
    public StudentTraining createStudentTraining(@RequestBody StudentTraining studentTraining) {
        return studentTrainingService.createStudentTraining(studentTraining);
    }

    @PutMapping("/{id}")
    public StudentTraining updateStudentTraining(@PathVariable Long id, @RequestBody StudentTraining studentTraining) {
        return studentTrainingService.updateStudentTraining(id, studentTraining);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentTraining(@PathVariable Long id) {
        studentTrainingService.deleteStudentTraining(id);
    }
}

