package com.nishikanta.TrainingPlatformRegistration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nishikanta.TrainingPlatformRegistration.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}

