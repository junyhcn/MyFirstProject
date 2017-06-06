package com.accp.springboot.util;

import com.accp.springboot.entity.Result;

public class ResultUtil {
	public static Result success(Object obj){
		Result result=new Result();
		result.setCode(1);
		result.setMsg("成功");
		result.setData(obj);
		return result;
	}
	
	public static Result fail(int code,String msg){
		Result result=new Result();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(null);
		return result;
	}

}
