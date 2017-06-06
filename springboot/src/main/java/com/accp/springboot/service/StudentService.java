package com.accp.springboot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.springboot.dao.StudentRepository;
import com.accp.springboot.entity.Student;
import com.accp.springboot.util.StudentException;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public Student findOne(Integer id) {
		return studentRepository.findOne(id);
	}

	public Iterable<Student> findAll() {
		return studentRepository.findAll();
	}

	public void saveStudent(Student s) {
		this.studentRepository.save(s);
	}

	@Transactional
	public void updateStudent(Student s) {
		this.studentRepository.save(s);
	}

	public void deleteStudent(Integer id) {
		this.studentRepository.delete(id);
	}

	public Iterable<Student> findByAge(Integer age) {
		return this.studentRepository.findByAge(age);
	}

	public Student getStudent(int id) throws Exception {
		Student s = this.studentRepository.findOne(id);
		if (s.getAge() < 20) {
			throw new StudentException(100,"年龄不合法");
		} else
			return s;
	}

}
