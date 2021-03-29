package me.olaosebikan.student.service;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.BDDAssertions.then;
import javax.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import me.olaosebikan.student.service.entity.Student;
import me.olaosebikan.student.service.exception.StudentNotFoundException;
import me.olaosebikan.student.service.repository.StudentRepository;
import me.olaosebikan.student.service.service.StudentService;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
public class StudentServiceTest {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentService studentService;
	
	@DisplayName("Return stored student by Id from the service layer")
	@Test
	void getStudentById_storedStudent_isReturned() {
		
		//given
		Student newStudent = studentRepository.save(new Student(null, "Gideon"));
		
		//when
		Student student = studentService.getStudentById(newStudent.getId());
		
		//then
		then(student.getName()).isEqualTo("Gideon");
		then(student.getId()).isNotNull();
	}
	
	@DisplayName("Throw Expection for missing student by id")
	@Test
	void getStudentByMissingId_isExpectionThrown() {
		
		///given
		Long id = 1234L;
		
		//when 
		Throwable throwable = catchThrowable(() -> studentService.getStudentById(id));
		
		///then
		then(throwable).isInstanceOf(StudentNotFoundException.class);
	}
}
