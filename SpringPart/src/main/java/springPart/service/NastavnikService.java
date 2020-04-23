package springPart.service;

import org.springframework.beans.factory.annotation.Autowired;

import springPart.model.Nastavnik;
import springPart.repository.NastavnikRepository;

public class NastavnikService {
	
	@Autowired
	NastavnikRepository repo;
	
	
	public Iterable<Nastavnik> dobaviSve(){
		return repo.findAll();
	}
	
	public Nastavnik dobaviPoId(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public void save(Nastavnik obj) {
		repo.save(obj);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
