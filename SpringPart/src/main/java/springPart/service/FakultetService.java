package springPart.service;
import org.springframework.stereotype.Service;

import springPart.model.predmetPart.Fakultet;
import springPart.repository.FakultetRepository;

@Service
public class FakultetService extends AbstractService<Fakultet, FakultetRepository>{

	public FakultetService(FakultetRepository repository) {
		super(repository);
	}
	
	
}
