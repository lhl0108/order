package com.jbinfo.order.base;

import com.jbinfo.order.util.Result;

public class BaseController{
	
	public Result success(Object data){
		return new Result(data,null,true);
	}
	
	public Result success(Object data, String message){
		return new Result(data,message,true);
	}
	
	public Result error(String message){
		return new Result(null,message,false);
	}

}
