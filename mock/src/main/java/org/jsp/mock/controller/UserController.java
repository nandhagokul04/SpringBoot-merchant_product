package org.jsp.mock.controller;


import org.jsp.mock.dto.ResponseStructure;
import org.jsp.mock.dto.User;
import org.jsp.mock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping(value =  "/user")
public class UserController {
	@Autowired
  private UserService userservice;
	
	@PostMapping
	 public ResponseStructure<User> save(@RequestBody User user) {
		return  userservice.save(user);
	 }
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> update(@RequestBody User user) {
		//TODO: process PUT request
		return userservice.update(user);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> findbyid(@PathVariable int id) {
		return userservice.findbyid(id);
	}
	@PostMapping("/verify-by-phn")
	public ResponseEntity<ResponseStructure<User>> verifybyphn(@RequestParam(name = "phonen")long phone,@RequestParam(name = "pass")String pass) {
		return userservice.verifybyphn(phone, pass);
	}
	@PostMapping("/verify-by-mail")
	public ResponseEntity<ResponseStructure<User>> verifybymail(@RequestParam(name = "mail")String mail,@RequestParam(name = "pass")String pass) {
		return userservice.verifybymail(mail, pass);
	}
	
	
}
