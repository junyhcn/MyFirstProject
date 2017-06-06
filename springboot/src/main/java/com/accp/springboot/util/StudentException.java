package com.accp.springboot.util;

public class StudentException extends RuntimeException{
	private Integer code;
	public StudentException(Integer code,String message){
		super(message);
		this.code=code;
		
	}
	public Integer getCode() {
		return code;
	}
	

}
