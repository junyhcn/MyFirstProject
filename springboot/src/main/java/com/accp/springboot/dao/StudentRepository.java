package com.accp.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.accp.springboot.entity.Student;


public interface StudentRepository extends CrudRepository<Student, Integer>{

	public Iterable<Student> findByAge(Integer age);
}
