package org.jsp.springboot.merchantbootapp.repository;

import java.util.Optional;

import org.jsp.springboot.merchantbootapp.dto.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MerchantRepository extends JpaRepository<Merchant, Integer>{
	@Query("select m from Merchant m where m.phone=?1 and m.password=?2")
	public Optional<Merchant> verify(long phone,String passsword);
	
	@Query("select m from Merchant m where m.name=?1")
	public Optional<Merchant>findbyname(String name);

}
