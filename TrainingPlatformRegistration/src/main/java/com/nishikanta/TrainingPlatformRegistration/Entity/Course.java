package com.nishikanta.TrainingPlatformRegistration.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseName;
    @OneToMany(mappedBy = "course")
    private List<TrainingSchedule> trainingSchedules;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
    
    public Course(Long courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }
}

