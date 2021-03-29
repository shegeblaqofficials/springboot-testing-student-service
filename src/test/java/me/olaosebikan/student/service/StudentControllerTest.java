package me.olaosebikan.student.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import me.olaosebikan.student.service.entity.Student;
import me.olaosebikan.student.service.service.StudentService;
import static org.mockito.ArgumentMatchers.anyLong;

@WebMvcTest
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private StudentService studentService;

	@DisplayName("Fetch Student By Id")
	@Test
	void getStudent_returnedStoredStudents() throws Exception {

		/// given
		given(studentService.getStudentById(anyLong())).willReturn(
					Student.builder()
					.id(1l)
					.name("Gideon")
					.age(25).build());

		/// when ///then
		mockMvc.perform(get("/students/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("id").value(1l))
				.andExpect(jsonPath("name").value("Gideon"))
				.andExpect(jsonPath("age").value(25));

	}

}
