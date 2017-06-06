package com.accp.springboot.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.accp.springboot.entity.Result;

import ch.qos.logback.classic.Logger;

//@ControllerAdvice
public class ExceptionsHandler {
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
   public Result handle(Exception ex){
		StudentException se=null;
		if(ex instanceof StudentException){
			se=(StudentException)ex;
			return ResultUtil.fail(se.getCode(), se.getMessage());
		}else{
			 return ResultUtil.fail(-1, "未知错误");
		}
	  
   }
}
