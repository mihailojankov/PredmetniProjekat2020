package springPart.service;
import org.springframework.stereotype.Service;

import springPart.model.predmetPart.Predmet;
import springPart.repository.PredmetRepository;

@Service
public class PredmetService extends AbstractService<Predmet, PredmetRepository>{

	public PredmetService(PredmetRepository repository) {
		super(repository);
	}

	public Iterable<Predmet> pronadjiPoProfesoru(Long id){
		return repository.pronadjiPoProfesoru(id);
	}
	
	
	
}
