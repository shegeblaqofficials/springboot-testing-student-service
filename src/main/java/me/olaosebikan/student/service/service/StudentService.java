package me.olaosebikan.student.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.olaosebikan.student.service.entity.Student;
import me.olaosebikan.student.service.exception.StudentNotFoundException;
import me.olaosebikan.student.service.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student getStudentById(Long id) {
		
		return studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException());
	}

}
