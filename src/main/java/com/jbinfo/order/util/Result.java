package com.jbinfo.order.util;

import java.io.Serializable;

public class Result implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private Object data;  
    private String message;  
    private boolean success;  
  
    public Result() {  
        super();  
    }  
    public Result(Object data, String message, boolean success) {  
        this.data = data;  
        this.message = message;  
        this.success = success;  
    }  
    public Result(String message,boolean success) {  
        this.message = message;  
        this.success = success;  
    }  
    public Result(Object data, String message) {  
        this.data = data;  
        this.message = message;  
        this.success = true;  
    }  
    public Result(Object data) {  
        this.data = data;  
        this.success = true;  
    }
    public Object getData() {  
        return data;  
    }  
  
    public void setData(Object data) {  
        this.data = data;  
    }  
  
    public String getMessage() {  
        return message;  
    }  
  
    public void setMessage(String message) {  
        this.message = message;  
    }  
  
    public boolean isSuccess() {  
        return success;  
    }  
  
    public void setSuccess(boolean success) {  
        this.success = success;  
    }  
    
    @Override
    public String toString() {
        return "Result [data=" + data + ", message=" + message
                + ", success=" + success + "]";
    }  

}
