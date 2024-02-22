package org.jsp.springboot.merchantbootapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.springboot.merchantbootapp.dto.Product;
import org.jsp.springboot.merchantbootapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	 private ProductRepository productrepository;
	
	public Product save(Product product) {
		 return productrepository.save(product);
	}
	public Optional<Product> findbyid(int id) {
		return productrepository.findById(id);
	}
	public Optional<List<Product>> findbymerchantid(int id){
		return productrepository.findbymerchantid(id);
	}
	

}
