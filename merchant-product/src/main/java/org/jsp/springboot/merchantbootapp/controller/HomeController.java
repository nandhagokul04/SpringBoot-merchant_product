package org.jsp.springboot.merchantbootapp.controller;

import java.util.List;

import org.jsp.springboot.merchantbootapp.dto.Merchant;
import org.jsp.springboot.merchantbootapp.dto.ResponseStructure;
import org.jsp.springboot.merchantbootapp.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/merchants")
public class HomeController {
	@Autowired
	private MerchantService merchantService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseStructure<Merchant> save(@RequestBody Merchant merchant) {
		return merchantService.save(merchant);
	}

	@PutMapping
	public ResponseStructure<Merchant> update(@RequestBody Merchant merchant) {
		return merchantService.update(merchant);
	}

	@GetMapping(value = "/{id}")
	public ResponseStructure<Merchant> findbyid(@PathVariable(name = "id") int id) {
		return merchantService.findbyid(id);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseStructure<Merchant>> delete(@PathVariable(name = "id") int id) {
		return merchantService.delete(id);
	}

	@GetMapping
	public List<Merchant> findall() {
		return merchantService.findall();
	}

	@PostMapping(value = "/verify-by-phone")
	public ResponseStructure<Merchant> verify(@RequestParam long phone, @RequestParam String password)
	{
		return merchantService.verify(phone, password);

	}

	@GetMapping(value = "/find-by-name/{name}")
	public ResponseStructure<Merchant> findbyname(@PathVariable(name = "name") String name) {
	return merchantService.findbyname(name);
	}

}
