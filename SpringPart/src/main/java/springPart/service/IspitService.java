package springPart.service;

import org.springframework.stereotype.Service;

import springPart.model.Ispit;
import springPart.repository.IspitRepository;

@Service
public class IspitService extends AbstractService<Ispit, IspitRepository>{

	public IspitService(IspitRepository repository) {
		super(repository);
	}

}
