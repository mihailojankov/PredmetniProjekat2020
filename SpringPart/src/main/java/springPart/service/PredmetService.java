package springPart.service;
import org.springframework.stereotype.Service;

import springPart.model.Predmet;
import springPart.repository.PredmetRepository;

@Service
public class PredmetService extends AbstractService<Predmet, PredmetRepository>{

	public PredmetService(PredmetRepository repository) {
		super(repository);
	}

	
	
	
}
