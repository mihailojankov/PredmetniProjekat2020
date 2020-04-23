package springPart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springPart.model.Fakultet;
import springPart.repository.FakultetRepository;

@Service
public class FakultetService {
	
	@Autowired
	FakultetRepository repo;
	
	
	public Iterable<Fakultet> dobaviSve(){
		return repo.findAll();
	}
	
	public Fakultet dobaviPoId(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public void save(Fakultet obj) {
		repo.save(obj);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
