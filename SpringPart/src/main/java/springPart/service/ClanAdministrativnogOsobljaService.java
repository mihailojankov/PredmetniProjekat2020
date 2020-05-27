package springPart.service;

import org.springframework.stereotype.Service;

import springPart.model.ClanAdministrativnogOsoblja;
import springPart.repository.ClanAdministrativnogOsobljaRepository;

@Service
public class ClanAdministrativnogOsobljaService extends AbstractService<ClanAdministrativnogOsoblja, ClanAdministrativnogOsobljaRepository>{

	public ClanAdministrativnogOsobljaService(ClanAdministrativnogOsobljaRepository repository) {
		super(repository);
	}

}
