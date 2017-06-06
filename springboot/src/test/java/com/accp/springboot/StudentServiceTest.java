package com.accp.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accp.springboot.entity.Student;
import com.accp.springboot.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
	@Autowired
	private StudentService studentService;
	
	@Test
	public void testFindOne(){
		Student s=studentService.findOne(1);
		System.out.println(s);
	}

}
