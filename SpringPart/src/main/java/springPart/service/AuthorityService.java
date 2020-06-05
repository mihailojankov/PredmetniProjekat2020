package springPart.service;

import org.springframework.stereotype.Service;

import springPart.model.Authority;
import springPart.repository.AuthorityRepository;

@Service
public class AuthorityService extends AbstractService<Authority, AuthorityRepository>{

	public AuthorityService(AuthorityRepository repository) {
		super(repository);
	}
	
	public Authority nadjiPoNazivu(String naziv) {
		return repository.nadjiPoNazivu(naziv);
	}

}
