package com.nishikanta.TrainingPlatformRegistration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nishikanta.TrainingPlatformRegistration.Entity.StudentTraining;

public interface StudentTrainingRepository extends JpaRepository<StudentTraining, Long> {

}

