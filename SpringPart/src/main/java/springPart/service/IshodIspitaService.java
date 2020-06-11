package springPart.service;

import org.springframework.stereotype.Service;

import springPart.model.ispitPart.IshodIspita;
import springPart.repository.IshodIspitaRepository;

@Service
public class IshodIspitaService extends AbstractService<IshodIspita, IshodIspitaRepository>{

	public IshodIspitaService(IshodIspitaRepository repository) {
		super(repository);
	}

}
