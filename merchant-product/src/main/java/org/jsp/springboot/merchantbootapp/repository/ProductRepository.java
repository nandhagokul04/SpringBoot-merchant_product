package org.jsp.springboot.merchantbootapp.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.springboot.merchantbootapp.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query("select p from Product p where p.merchant.id=?1")
	public Optional<List<Product>> findbymerchantid(int id);
}
