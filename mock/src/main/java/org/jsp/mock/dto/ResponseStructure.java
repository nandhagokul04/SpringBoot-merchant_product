package org.jsp.mock.dto;

public class ResponseStructure<T> {
	private String message;
	private T data;
	private int statuscosde;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public int getStatuscosde() {
		return statuscosde;
	}
	public void setStatuscosde(int i) {
		this.statuscosde = i;
	}
	
	
	

}
