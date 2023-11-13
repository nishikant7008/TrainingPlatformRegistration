package com.nishikanta.TrainingPlatformRegistration.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String studentName;
    @ManyToMany(mappedBy = "students")
    private List<TrainingSchedule> trainingSchedules;
    @OneToMany(mappedBy = "student")
    private List<StudentTraining> studentTrainings;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public Student(Long studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
}


