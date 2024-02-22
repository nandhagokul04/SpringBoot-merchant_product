package org.jsp.mock.repository;


import java.util.Optional;

import org.jsp.mock.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select u from User u where u.phone=?1 and u.password=?2")
	public Optional<User> verifybyphn(long phone,String email);
	
	@Query("select u from User u where u.email=?1 and u.password=?2")
	public Optional<User> verifybymail(String mail ,String email);
	
}
