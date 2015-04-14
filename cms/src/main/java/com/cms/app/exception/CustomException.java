
package com.cms.app.exception;


public class CustomException extends RuntimeException{
		
	private static final long serialVersionUID = 1L;
	
	private Object o;
	private Exception ex;
	
	public Object getO() {
		return o;
	}

	public void setO(Object o) {
		this.o = o;
	}

	public Exception getEx() {
		return ex;
	}
	public void setEx(Exception ex) {
		this.ex = ex;
	}
	
	public CustomException(Object o,Exception ex){		
		this.o=o;		
		this.ex=ex;
	}
	
	public CustomException(){
		
	}
}
