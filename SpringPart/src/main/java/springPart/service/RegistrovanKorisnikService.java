package springPart.service;
import org.springframework.stereotype.Service;

import springPart.model.RegistrovanKorisnik;
import springPart.repository.RegistrovanKorisnikRepository;

@Service
public class RegistrovanKorisnikService extends AbstractService<RegistrovanKorisnik, RegistrovanKorisnikRepository>{

	public RegistrovanKorisnikService(RegistrovanKorisnikRepository repository) {
		super(repository);
	}

}
