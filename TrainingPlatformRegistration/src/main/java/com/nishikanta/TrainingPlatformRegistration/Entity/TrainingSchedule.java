package com.nishikanta.TrainingPlatformRegistration.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class TrainingSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToMany
    @JoinTable(
        name = "schedule_student",
        joinColumns = @JoinColumn(name = "schedule_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    @OneToMany(mappedBy = "trainingSchedule")
    private List<StudentTraining> studentTrainings;   
    
    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }
    
  

}


