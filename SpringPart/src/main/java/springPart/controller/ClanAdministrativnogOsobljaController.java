package springPart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import springPart.DTO.ClanAdministrativnogOsobljaDTO;
import springPart.model.ClanAdministrativnogOsoblja;
import springPart.service.ClanAdministrativnogOsobljaService;

@Controller
@CrossOrigin
@RequestMapping(path = "/clanAdministrativnogOsoblja")
public class ClanAdministrativnogOsobljaController extends AbstractController<ClanAdministrativnogOsoblja, ClanAdministrativnogOsobljaDTO, ClanAdministrativnogOsobljaService>{

	public ClanAdministrativnogOsobljaController(ClanAdministrativnogOsobljaService service) {
			super(service, ClanAdministrativnogOsobljaDTO.class);
	}
	
}
