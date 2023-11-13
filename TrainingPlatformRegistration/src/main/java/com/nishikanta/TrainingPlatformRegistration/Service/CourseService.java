package com.nishikanta.TrainingPlatformRegistration.Service;

import java.util.List;

import com.nishikanta.TrainingPlatformRegistration.Entity.Course;

public interface CourseService {
    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course createCourse(Course course);

    Course updateCourse(Long id, Course course);

    void deleteCourse(Long id);
}

