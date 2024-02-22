package org.jsp.mock.Exception;

import org.jsp.mock.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler  {

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleIDNF(IdNotFoundException exceptipon){
		ResponseStructure<String> str=new ResponseStructure<>();
		str.setMessage("ID not found");
		str.setData("Invalid ID Entered");
		str.setStatuscosde(HttpStatus.NOT_FOUND.value());
		return  new ResponseEntity<ResponseStructure<String>>(str,HttpStatus.NOT_FOUND) ;
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleID(InvalidDataException exceptipon){
		ResponseStructure<String> str=new ResponseStructure<>();
		str.setMessage("ID not found");
		str.setData("Invalid ID Entered");
		str.setStatuscosde(HttpStatus.NOT_FOUND.value());
		return  new ResponseEntity<ResponseStructure<String>>(str,HttpStatus.NOT_FOUND) ;
	}
}
