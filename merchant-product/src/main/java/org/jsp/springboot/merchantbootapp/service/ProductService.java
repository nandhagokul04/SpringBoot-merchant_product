package org.jsp.springboot.merchantbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.springboot.merchantbootapp.Exception.IdNotFountException;
import org.jsp.springboot.merchantbootapp.Exception.ProductNotFoundException;
import org.jsp.springboot.merchantbootapp.dao.MerchantDao;
import org.jsp.springboot.merchantbootapp.dao.ProductDao;
import org.jsp.springboot.merchantbootapp.dto.Merchant;
import org.jsp.springboot.merchantbootapp.dto.Product;
import org.jsp.springboot.merchantbootapp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDao productdao;
	@Autowired
	private MerchantDao merchantdao;
	
	public ResponseEntity<ResponseStructure<Product>> save(Product product,int mid){ 
		Optional<Merchant> opmerchant=merchantdao.findbyid(mid);
	ResponseStructure<Product> structure=new ResponseStructure<>();
	if(opmerchant.isPresent()) {
		Merchant merchant=opmerchant.get();
		merchant.getProducts().add(product);
		product.setMerchant(merchant);
	structure.setMessage("Product Saved");
	structure.setData(productdao.save(product));
	structure.setStatuscode(HttpStatus.ACCEPTED.value());
	return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.ACCEPTED);
	}
	
	throw new IdNotFountException();
	}
	
	public ResponseEntity<ResponseStructure<Product>> findbyid(int id){
		Optional<Product> opproduct=productdao.findbyid(id);
		ResponseStructure<Product> structure=new  ResponseStructure<>();
		if(opproduct.isPresent()) {
			structure.setMessage("Product found");
			structure.setData(opproduct.get());
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		throw new ProductNotFoundException("Invalid product ID!");
				
	}
	
	public ResponseEntity<ResponseStructure<Product>> update(Product product,int mid){
		Optional<Product> opproduct=productdao.findbyid(product.getId());
		Optional<Merchant> opmerchant=merchantdao.findbyid(mid);
		ResponseStructure<Product> structure=new  ResponseStructure<>();
		if(opproduct.isPresent()) {
			Product p=opproduct.get();
//			Merchant merchant=opmerchant.get();
			p.setBrand(product.getBrand());
			p.setCatagory(product.getCatagory());
			p.setCost(product.getCost());
			p.setDescription(product.getDescription());
			p.setId(product.getId());
			p.setImageurl(product.getImageurl());
			p.setName(product.getName());
			p.setMerchant(opmerchant.get());
			structure.setMessage("Product updated");
			structure.setData(productdao.save(p));
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		throw new IdNotFountException();
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> findbymerchntid(int id){
		Optional<List<Product>> opproduct =productdao.findbymerchantid(id);
		ResponseStructure<List<Product>> structure=new  ResponseStructure<>();
		if(opproduct.isPresent()) {
			structure.setData(opproduct.get());
			structure.setMessage("Product Found");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
		}
		throw new ProductNotFoundException("Merchant_id is  Invalid ");
		
	}
	
	
	
}
