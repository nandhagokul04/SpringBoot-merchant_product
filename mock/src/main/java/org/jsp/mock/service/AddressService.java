package org.jsp.mock.service;

import java.util.Optional;

import org.jsp.mock.Exception.IdNotFoundException;
import org.jsp.mock.dao.AddressDao;
import org.jsp.mock.dao.UserDao;
import org.jsp.mock.dto.Address;
import org.jsp.mock.dto.ResponseStructure;
import org.jsp.mock.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
	@Autowired
	private AddressDao dao;
	@Autowired
	private UserDao udao;
	
	public ResponseEntity<ResponseStructure<Address>> save(Address address,int uid) {
		Optional<User> opuser=udao.findbyid(uid);
		if(opuser.isPresent()) {
			User user=opuser.get();
			user.getAddress().add(address);
			Address a=address;
			a.setUser(user);
			ResponseStructure<Address> structure=new ResponseStructure<>();
			structure.setMessage("User saved");
			structure.setData(dao.save(a));
			structure.setStatuscosde(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
			}
			throw new IdNotFoundException("Please enter a vlaid ID");
	}
	public ResponseEntity<ResponseStructure<Address>> update(Address address,int uid) {
		Optional<User> opuser=udao.findbyid(uid);
		if(opuser.isPresent()) {
			User user=opuser.get();
			user.getAddress().add(address);
			Address a=address;
			a.setUser(user);
			ResponseStructure<Address> structure=new ResponseStructure<>();
			structure.setMessage("User saved");
			structure.setData(dao.save(a));
			structure.setStatuscosde(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
			}
			throw new IdNotFoundException("Please enter a vlaid ID");
	}

}
