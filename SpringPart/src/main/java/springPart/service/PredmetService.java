package springPart.service;

import org.springframework.beans.factory.annotation.Autowired;

import springPart.model.Predmet;
import springPart.repository.PredmetRepository;

public class PredmetService {
	
	@Autowired
	PredmetRepository repo;
	
	
	public Iterable<Predmet> dobaviSve(){
		return repo.findAll();
	}
	
	public Predmet dobaviPoId(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public void save(Predmet obj) {
		repo.save(obj);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
