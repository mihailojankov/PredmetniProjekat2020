package springPart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springPart.model.korisnik.Nastavnik;
import springPart.repository.NastavnikRepository;

@Service
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
