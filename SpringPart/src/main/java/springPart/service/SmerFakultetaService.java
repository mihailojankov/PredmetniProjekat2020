package springPart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springPart.model.SmerFakulteta;
import springPart.repository.SmerFakultetaRepository;

@Service
public class SmerFakultetaService {
	
	@Autowired
    SmerFakultetaRepository repo;


    public Iterable<SmerFakulteta> dobaviSve(){
        return repo.findAll();
    }

    public SmerFakulteta dobaviPoId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void save(SmerFakulteta obj) {
        repo.save(obj);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
