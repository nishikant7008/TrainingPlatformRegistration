package com.nishikanta.TrainingPlatformRegistration.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nishikanta.TrainingPlatformRegistration.Entity.Student;
import com.nishikanta.TrainingPlatformRegistration.ExceptionHandler.ResourceNotFoundException;
import com.nishikanta.TrainingPlatformRegistration.Repository.StudentRepository;

import java.util.List;
	@Service
	@Transactional
	public class StudentServiceImpl implements StudentService {

	    @Autowired
	    private StudentRepository studentRepository;

	    @Override
	    public List<Student> getAllStudents() {
	        return studentRepository.findAll();
	    }

	    @Override
	    public Student getStudentById(Long id) {
	        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
	    }

	    @Override
	    public Student createStudent(Student student) {
	        return studentRepository.save(student);
	    }

	    @Override
	    public Student updateStudent(Long id, Student student) {
	        student.setStudentId(id);
	        return studentRepository.save(student);
	    }

	    @Override
	    public void deleteStudent(Long id) {
	        studentRepository.deleteById(id);
	    }
	}
