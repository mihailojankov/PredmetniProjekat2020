package springPart.service;

import org.springframework.stereotype.Service;

import springPart.model.ispitPart.PrijavaIspita;
import springPart.repository.PrijavaIspitaRepository;

@Service
public class PrijavaIspitaService extends AbstractService<PrijavaIspita, PrijavaIspitaRepository>{

	public PrijavaIspitaService(PrijavaIspitaRepository repository) {
		super(repository);
	}
	
	public Iterable<PrijavaIspita> nadjiPrijavePoIdStudenta(Long id) {
		return repository.nadjiPrijavePoIdStudenta(id);
	}
	 
}
