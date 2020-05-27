package springPart.service;
import org.springframework.stereotype.Service;

import springPart.model.Univerzitet;
import springPart.repository.UniverzitetRepository;

@Service
public class UniverzitetService extends AbstractService<Univerzitet, UniverzitetRepository>{

	public UniverzitetService(UniverzitetRepository repository) {
		super(repository);
	}
	

}
