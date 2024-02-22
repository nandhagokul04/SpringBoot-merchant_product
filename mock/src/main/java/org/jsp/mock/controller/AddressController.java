package org.jsp.mock.controller;

import org.jsp.mock.dto.Address;
import org.jsp.mock.dto.ResponseStructure;
import org.jsp.mock.dto.User;
import org.jsp.mock.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value =  "/address")
public class AddressController {
	@Autowired
	  private AddressService service;
	
	
	@PostMapping("/{uid}")
	 public ResponseEntity<ResponseStructure<Address>> save(@RequestBody Address address,@PathVariable int uid) {
		return service.save(address,uid);
	 }
	@PutMapping("/{uid}")
	 public ResponseEntity<ResponseStructure<Address>> update(@RequestBody Address address,@PathVariable int uid) {
		return service.save(address,uid);
	 }
	 
}
