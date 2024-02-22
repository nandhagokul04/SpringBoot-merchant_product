package org.jsp.springboot.merchantbootapp.Exception;

public class IdNotFountException extends RuntimeException {
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Invalid ID!";
	}

}
