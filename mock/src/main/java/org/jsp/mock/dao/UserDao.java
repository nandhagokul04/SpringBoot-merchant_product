package org.jsp.mock.dao;


import java.util.Optional;

import org.jsp.mock.dto.User;
import org.jsp.mock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	 private UserRepository userrepository;
	
	public User save(User user) {
		return userrepository.save(user);
	}
	public Optional<User> findbyid(int id) {
		return userrepository.findById(id);
	}
	public Optional<User> verifybyphn(long phn,String mail) {
		return userrepository.verifybyphn(phn,mail);
	}
	public Optional<User> verifybymail(String mail,String pass) {
		return userrepository.verifybymail(mail, pass);
	}
	 
}