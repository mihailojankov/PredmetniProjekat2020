package springPart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import springPart.DTO.RegistrovanKorisnikDTO;
import springPart.model.RegistrovanKorisnik;
import springPart.service.RegistrovanKorisnikService;

@Controller
@CrossOrigin
@RequestMapping(path = "/registrovanKorisnik")
public class RegistrovanKorisnikController extends AbstractController<RegistrovanKorisnik, RegistrovanKorisnikDTO, RegistrovanKorisnikService> {

	public RegistrovanKorisnikController(RegistrovanKorisnikService service) {
		super(service, RegistrovanKorisnikDTO.class);
		
	}

}
