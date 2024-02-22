package org.jsp.mock.service;

import java.util.Optional;

import org.jsp.mock.Exception.IdNotFoundException;
import org.jsp.mock.Exception.InvalidDataException;
import org.jsp.mock.dao.UserDao;
import org.jsp.mock.dto.ResponseStructure;
import org.jsp.mock.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userdao;
	
	public ResponseStructure<User> save(User user){
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("User saved");
		structure.setData(userdao.save(user));
		structure.setStatuscosde(HttpStatus.OK.value());
		return structure;
	}
	public ResponseEntity<ResponseStructure<User>> update(User user){
		Optional<User> opuser=userdao.findbyid(user.getId());
		if(opuser.isPresent()) {
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("User saved");
		structure.setData(userdao.save(user));
		structure.setStatuscosde(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException("Please enter a vlaid ID");
	}
	public ResponseEntity<ResponseStructure<User>> findbyid(int id){
		Optional<User> opuser=userdao.findbyid(id);
		if(opuser.isPresent()) {
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("User saved");
		structure.setData(opuser.get());
		structure.setStatuscosde(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		throw new  IdNotFoundException("Please enter a vlaid ID");
	}
	public ResponseEntity<ResponseStructure<User>> verifybyphn(long phn,String pass){
		Optional<User> opuser=userdao.verifybyphn(phn, pass);
		if(opuser.isPresent()) {
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("User saved");
		structure.setData(opuser.get());
		structure.setStatuscosde(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		throw new InvalidDataException("Invalid data entered");
	}
	public ResponseEntity<ResponseStructure<User>> verifybymail(String mail,String pass){
		Optional<User> opuser=userdao.verifybymail(mail, pass);
		if(opuser.isPresent()) {
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("User saved");
		structure.setData(opuser.get());
		structure.setStatuscosde(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		throw new InvalidDataException("Invalid data entered");
	}
	

}
