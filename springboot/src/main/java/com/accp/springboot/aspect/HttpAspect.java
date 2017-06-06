package com.accp.springboot.aspect;


import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {
	private final static org.slf4j.Logger logger=LoggerFactory.getLogger(HttpAspect.class);

	@Pointcut("execution(* com.accp.springboot.web.StudentController.*(..))")
	private void myMethod(){}
	
	@Before("myMethod()")
	public void before(JoinPoint joinPoint){
		logger.info("before");
		ServletRequestAttributes atts=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request=atts.getRequest();
		logger.info("URL="+request.getRequestURI());
		logger.info("Method="+request.getMethod());
		
		logger.info("argu"+joinPoint.getArgs());
		logger.info("ClassName"+joinPoint.getTarget().getClass().getSimpleName());
		logger.info("ClassMethod"+joinPoint.getSignature().getName());
	}
	
	@After("myMethod()")
	public void after(){
		System.out.println("After....");
	}

	@AfterReturning(returning="object",pointcut="myMethod()")
	public void doAfter(Object object){
		logger.info("result="+object);
		
	}
}
