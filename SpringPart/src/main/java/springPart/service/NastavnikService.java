package springPart.service;
import org.springframework.stereotype.Service;

import springPart.model.Nastavnik;
import springPart.repository.NastavnikRepository;

@Service
public class NastavnikService extends AbstractService<Nastavnik, NastavnikRepository>{

	public NastavnikService(NastavnikRepository repository) {
		super(repository);
	}
	
}
