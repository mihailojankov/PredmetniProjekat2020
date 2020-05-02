package springPart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springPart.model.korisnik.RegistrovanKorisnik;
import springPart.repository.RegistrovanKorisnikRepository;

@Service
public class RegistrovanKorisnikService {
	@Autowired
    RegistrovanKorisnikRepository repo;


    public Iterable<RegistrovanKorisnik> dobaviSve(){
        return repo.findAll();
    }

    public RegistrovanKorisnik dobaviPoId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void save(RegistrovanKorisnik obj) {
        repo.save(obj);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
