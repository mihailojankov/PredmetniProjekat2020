package springPart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springPart.model.Univerzitet;
import springPart.repository.UniverzitetRepository;

@Service
public class UniverzitetService {
	
	@Autowired
    UniverzitetRepository repo;


    public Iterable<Univerzitet> dobaviSve(){
        return repo.findAll();
    }

    public Univerzitet dobaviPoId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Univerzitet obj) {
        repo.save(obj);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
