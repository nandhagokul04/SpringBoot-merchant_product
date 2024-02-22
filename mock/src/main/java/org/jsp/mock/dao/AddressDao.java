package org.jsp.mock.dao;

import org.jsp.mock.dto.Address;
import org.jsp.mock.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDao {
	@Autowired
		private AddressRepository addressrepository;
	
	public Address save(Address address) {
		return addressrepository.save(address);
	}
	
}
