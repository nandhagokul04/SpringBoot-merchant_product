package org.jsp.springboot.merchantbootapp.dto;

public class ResponseStructure<T> {
		private String message;
		private T data;
		private int statuscode;
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
		public int getStatuscode() {
			return statuscode;
		}
		public void setStatuscode(int statuscose) {
			this.statuscode = statuscose;
		}
		
}
