package org.jsp.mock.repository;

import org.jsp.mock.dto.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
