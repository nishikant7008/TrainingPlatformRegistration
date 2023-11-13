package com.nishikanta.TrainingPlatformRegistration;

import org.junit.jupiter.api.Test;

import com.nishikanta.TrainingPlatformRegistration.Entity.Course;
import com.nishikanta.TrainingPlatformRegistration.Repository.CourseRepository;
import com.nishikanta.TrainingPlatformRegistration.Service.CourseService;
import com.nishikanta.TrainingPlatformRegistration.Service.CourseServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService = new CourseServiceImpl();

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllCourses() {
        List<Course> courses = Arrays.asList(
                new Course(1L, "Math"),
                new Course(2L, "History")
        );
        when(courseRepository.findAll()).thenReturn(courses);

        List<Course> result = courseService.getAllCourses();

        // Assert
        assertEquals(courses.size(), result.size());
        verify(courseRepository, times(1)).findAll();
    }

    @Test
    void getCourseById() {

        Long courseId = 1L;
        Course course = new Course(courseId, "Math");
        when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));
        Course result = courseService.getCourseById(courseId);

        // Assert
        assertEquals(course, result);
        verify(courseRepository, times(1)).findById(courseId);
    }

    @Test
    void createCourse() {
        Course courseToCreate = new Course(null, "Chemistry");
        Course createdCourse = new Course(3L, "Chemistry");

        when(courseRepository.save(courseToCreate)).thenReturn(createdCourse);

        Course result = courseService.createCourse(courseToCreate);

        // Assert
        assertEquals(createdCourse, result);
        verify(courseRepository, times(1)).save(courseToCreate);
    }

    @Test
    void updateCourse() {
        Long courseId = 1L;
        Course existingCourse = new Course(courseId, "Math");
        Course updatedCourseInfo = new Course(null, "Physics");
        Course updatedCourse = new Course(courseId, "Physics");

        when(courseRepository.findById(courseId)).thenReturn(Optional.of(existingCourse));
        when(courseRepository.save(existingCourse)).thenReturn(updatedCourse);

        Course result = courseService.updateCourse(courseId, updatedCourseInfo);

        // Assert
        assertEquals(updatedCourse, result);
        verify(courseRepository, times(1)).findById(courseId);
        verify(courseRepository, times(1)).save(existingCourse);
    }

    @Test
    void deleteCourse() {
        Long courseId = 1L;
        Course courseToDelete = new Course(courseId, "Math");

        when(courseRepository.findById(courseId)).thenReturn(Optional.of(courseToDelete));

        courseService.deleteCourse(courseId);

        // Assert
        verify(courseRepository, times(1)).findById(courseId);
        verify(courseRepository, times(1)).delete(courseToDelete);
    }
}