package me.olaosebikan.student.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import me.olaosebikan.student.service.entity.Student;
import me.olaosebikan.student.service.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable Long id) {

		return studentService.getStudentById(id);
	}

}
