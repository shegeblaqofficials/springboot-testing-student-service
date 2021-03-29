package me.olaosebikan.student.service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private boolean active;

	private int age;

	public Student(Long id, String name) {
		this.id = id;
		this.name = name;
	}

}
