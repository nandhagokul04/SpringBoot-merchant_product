package org.jsp.springboot.merchantbootapp.dao;

import java.util.List;
import java.util.Optional;
import org.jsp.springboot.merchantbootapp.dto.Merchant;
import org.jsp.springboot.merchantbootapp.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class MerchantDao {
	@Autowired
	private MerchantRepository merchantrepository;

	public Merchant savemerchant(Merchant merchant) {
		return merchantrepository.save(merchant);
	}

	public Optional<Merchant> findbyid(int id) {
		return merchantrepository.findById(id);
	}

	public List<Merchant> findall() {
		return merchantrepository.findAll();
	}

	public boolean delete(Merchant merchant) {
			merchantrepository.delete(merchant);
			return true;
	}

	public Optional<Merchant> findbyname(String name) {
		return merchantrepository.findbyname(name);
	}

	public Optional<Merchant> verify(long phone, String password) {
		return merchantrepository.verify(phone, password);
	}
}
