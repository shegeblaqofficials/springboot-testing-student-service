package me.olaosebikan.student.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import me.olaosebikan.student.service.entity.Student;
import me.olaosebikan.student.service.repository.StudentRepository;
import static org.assertj.core.api.BDDAssertions.then;

import java.util.Arrays;

@DataJpaTest
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@DisplayName("Get Student By Name")
	@Test
	void testGetStudentByName_returnsStudentDetails() {

		/// given
		Student storedStudent = testEntityManager.persistAndFlush(new Student(null, "Gideon"));

		// when
		Student student = studentRepository.getStudentByName("Gideon");

		// then
		then(student.getId()).isNotNull();
		then(student.getName()).isEqualTo(storedStudent.getName());
	}

	@DisplayName("Get Average Age of Active Students")
	@Test
	void testAvgAgeForActiveStudents_calculateAvgAge() {

		// given
		Student gideon = Student.builder().name("Gideon").active(true).age(20).build();
		Student ethan = Student.builder().name("Ethan").active(false).age(35).build();
		Student alex = Student.builder().name("Alex").active(true).age(30).build();
		Arrays.asList(gideon, ethan, alex).forEach(testEntityManager::persistAndFlush);

		// when
		Double avgAge = studentRepository.getAvgAgeForActiveStudents();

		// then
		then(avgAge).isEqualTo(25);

	}
}
