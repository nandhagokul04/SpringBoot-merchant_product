package org.jsp.springboot.merchantbootapp.controller;

import java.util.List;

import org.jsp.springboot.merchantbootapp.dto.Product;
import org.jsp.springboot.merchantbootapp.dto.ResponseStructure;
import org.jsp.springboot.merchantbootapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/products")
public class ProductController {
	@Autowired
	private ProductService productservice;
	
	@PostMapping("/{merchant_id}")
	public ResponseEntity<ResponseStructure<Product>> save(@RequestBody Product product,@PathVariable(name="merchant_id")int mid) {
		return productservice.save(product,mid);
	}
	@GetMapping("/{id}")
	public  ResponseEntity<ResponseStructure<Product>> findbyid(@PathVariable(name="id")int id){
		return productservice.findbyid(id);
	}
	@PutMapping("/{mid}")
	public  ResponseEntity<ResponseStructure<Product>> update(@RequestBody Product product,@PathVariable (name="mid") int mid){
		return productservice.update(product,mid);
	}
	@GetMapping("/find-by-merchant-id/{merchant_id}")
	public ResponseEntity<ResponseStructure<List<Product>>> findproductbymerchantid(@PathVariable(name = "merchant_id") int id) {
		return productservice.findbymerchntid(id);
	}
	
	

}
