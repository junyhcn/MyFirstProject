package com.accp.springboot.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accp.springboot.entity.Result;
import com.accp.springboot.entity.Student;
import com.accp.springboot.service.StudentService;
import com.accp.springboot.util.ResultUtil;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@Value("${city}")
	private String city;
	@RequestMapping(value={"/say","talk"},method=RequestMethod.GET)
	public String say(){
		return "Hello SpringBoot";
	}
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(){
		return "index";
	}
	
	@RequestMapping(value="/find/{id}",method=RequestMethod.GET)
	public Student find(@PathVariable("id") Integer id)throws Exception{
		Student s=this.studentService.getStudent(id);
	   return s;	
	}
	
	@RequestMapping(value="/path/{id}",method=RequestMethod.GET)
	public String pathVar(@PathVariable("id") Integer id){
		return "pathVariable"+id;
	}
	
	//@RequestMapping(value="/param",method=RequestMethod.GET)
	//@PostMapping(value="/param")
	@GetMapping(value="/param")
	public String param(@RequestParam(value="id",required=false,defaultValue="0") Integer id){
		Student s=this.studentService.findOne(1);
		return "param:"+s.getName();
	}
	@GetMapping(value="/addStud")
	public Result<Student> addStudent(@Valid Student stud,BindingResult br){
		Result result=new Result();
		if(br.hasErrors()){
			/*System.out.println(br.getFieldError().getDefaultMessage());
			
			result.setCode(1);
			result.setMsg(br.getFieldError().getDefaultMessage());
			return result;*/
		return ResultUtil.fail(1,br.getFieldError().getDefaultMessage());
			
		}
		this.studentService.saveStudent(stud);
		return ResultUtil.success(stud);
		/*System.out.println(stud);
		result.setCode(0);
		result.setMsg("成功");
		result.setData(stud);
		return result;*/
	}
	@GetMapping(value="/listStud")
	public String  listStudent(){
	 System.out.println("ListStudent");
	 Iterable<Student> it=this.studentService.findAll();
	 for(Student s:it){
		 System.out.println(s);
	 }
		return "ListStudent";
	}
	
	@GetMapping(value="/updateStud")
	public String  updateStudent(Student s){
	    Student stud=this.studentService.findOne(s.getId());
	    stud.setAddr(s.getAddr());
	    stud.setAge(s.getAge());
	    stud.setName(s.getName());
	    this.studentService.updateStudent(stud);
	    
		return "updateStudent";
	}
	
	
	@GetMapping(value="/deleteStud/{id}")
	public String  deleteStudent(@PathVariable("id") Integer id){
	     this.studentService.deleteStudent(id);
		return "DeleteStudent";
	}
	
	@GetMapping(value="/findStud/{age}")
	public String  findStudent(@PathVariable("age") Integer age){
		 Iterable<Student> it=this.studentService.findByAge(age);
		 for(Student s:it){
			 System.out.println(s);
		 }
		return "FindStudent";
	}
}
