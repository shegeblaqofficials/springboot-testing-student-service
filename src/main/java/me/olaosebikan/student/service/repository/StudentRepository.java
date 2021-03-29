package me.olaosebikan.student.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import me.olaosebikan.student.service.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	Student getStudentByName(String name);

	@Query("select avg (age) from Student where active = true ")
	Double getAvgAgeForActiveStudents();

}
