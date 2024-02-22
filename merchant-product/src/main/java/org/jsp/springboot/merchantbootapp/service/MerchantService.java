package org.jsp.springboot.merchantbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.springboot.merchantbootapp.Exception.IdNotFountException;
import org.jsp.springboot.merchantbootapp.Exception.InvalidCredentialsException;
import org.jsp.springboot.merchantbootapp.dao.MerchantDao;
import org.jsp.springboot.merchantbootapp.dto.Merchant;
import org.jsp.springboot.merchantbootapp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
	@Autowired
	private MerchantDao merchantdao;
	
	public ResponseStructure<Merchant> save(Merchant merchant) {
		ResponseStructure<Merchant> structure = new ResponseStructure<Merchant>();
		structure.setMessage("Merchant saved");
		structure.setData(merchantdao.savemerchant(merchant));
		structure.setStatuscode(HttpStatus.CREATED.value());
		return structure;
	}
	public ResponseStructure<Merchant> update( Merchant merchant) {
		ResponseStructure<Merchant> structure = new ResponseStructure<Merchant>();
		Optional<Merchant> opmerchant = merchantdao.findbyid(merchant.getId());
		if (opmerchant.isPresent()) {
			Merchant dbmerchant = opmerchant.get();
			dbmerchant.setId(merchant.getId());
			dbmerchant.setName(merchant.getName());
			dbmerchant.setEmail(merchant.getEmail());
			dbmerchant.setGst_number(merchant.getGst_number());
			dbmerchant.setPhone(merchant.getPhone());
			dbmerchant.setPassword(merchant.getPassword());
			structure.setMessage("Merchant Updated");
			structure.setData(merchantdao.savemerchant(dbmerchant));
			structure.setStatuscode(HttpStatus.CREATED.value());
			return structure;
		} 
		throw new IdNotFountException();
		}
	
	public ResponseStructure<Merchant> findbyid( int id) {
		Optional<Merchant> opmerchant = merchantdao.findbyid(id);
		ResponseStructure<Merchant> structure = new ResponseStructure<Merchant>();
		if (opmerchant.isPresent()) {
			structure.setMessage("Merchant found!");
			structure.setData(merchantdao.findbyid(id).get());
			structure.setStatuscode(HttpStatus.OK.value());
			return structure;
		} 
		throw new IdNotFountException();
	}
	public ResponseEntity<ResponseStructure<Merchant>> delete(int id) {
		Optional<Merchant> opmerchant = merchantdao.findbyid(id);
		ResponseStructure<Merchant> structure = new ResponseStructure<Merchant>();
		if (opmerchant.isPresent()) {
			structure.setMessage("Merchant deleted");
			structure.setStatuscode(HttpStatus.OK.value());
			merchantdao.delete(opmerchant.get());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);

		}
		structure.setMessage("merchant not found");
		structure.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.NOT_FOUND);
	}
	public List<Merchant> findall() {
		return merchantdao.findall();
	}
	public ResponseStructure<Merchant> verify(long phone, String password)
	{
		ResponseStructure<Merchant> structure = new ResponseStructure<Merchant>();
		Optional<Merchant> opmerchant = merchantdao.verify(phone, password);
		if (opmerchant.isPresent()) {
			structure.setMessage("Merchant found!");
			structure.setData(merchantdao.verify(phone, password).get());
			structure.setStatuscode(HttpStatus.OK.value());
			return structure;
		}throw new InvalidCredentialsException("Wrong Phone / password");

	}
	public ResponseStructure<Merchant> findbyname(String name) {
		Optional<Merchant> opmerchant = merchantdao.findbyname(name);
		ResponseStructure<Merchant> structure = new ResponseStructure<Merchant>();
		if (opmerchant.isPresent()) {
			structure.setMessage("Merchant found!");
			structure.setData(merchantdao.findbyname(name).get());
			structure.setStatuscode(HttpStatus.OK.value());
			return structure;
		} 
		throw new InvalidCredentialsException("Merchant name Incorrect ");
	}

}
