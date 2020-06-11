package springPart.service;
import org.springframework.stereotype.Service;

import springPart.model.predmetPart.SmerFakulteta;
import springPart.repository.SmerFakultetaRepository;

@Service
public class SmerFakultetaService extends AbstractService<SmerFakulteta, SmerFakultetaRepository>{

	public SmerFakultetaService(SmerFakultetaRepository repository) {
		super(repository);
	}
	

}
