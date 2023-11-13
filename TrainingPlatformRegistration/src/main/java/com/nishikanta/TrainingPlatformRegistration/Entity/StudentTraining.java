package com.nishikanta.TrainingPlatformRegistration.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

import java.time.LocalDateTime;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class StudentTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date enrollmentDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private TrainingSchedule trainingSchedule;
    
    public StudentTraining() {
		
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
 

}
