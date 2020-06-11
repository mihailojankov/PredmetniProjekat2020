package springPart.service;

import org.springframework.stereotype.Service;

import springPart.model.ispitPart.Rok;
import springPart.repository.RokRepository;

@Service
public class RokService extends AbstractService<Rok, RokRepository>{

	public RokService(RokRepository repository) {
		super(repository);
	}

}
