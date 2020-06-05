package springPart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import springPart.DTO.ClanAdministrativnogOsobljaDTO;
import springPart.model.Authority;
import springPart.model.ClanAdministrativnogOsoblja;
import springPart.model.RegistrovanKorisnik;
import springPart.service.ClanAdministrativnogOsobljaService;

@Controller
@CrossOrigin
@RequestMapping(path = "/clanAdministrativnogOsoblja")
public class ClanAdministrativnogOsobljaController extends AbstractController<ClanAdministrativnogOsoblja, ClanAdministrativnogOsobljaDTO, ClanAdministrativnogOsobljaService>{

	public ClanAdministrativnogOsobljaController(ClanAdministrativnogOsobljaService service) {
			super(service, ClanAdministrativnogOsobljaDTO.class);
	}
	
	@Override
	@PostMapping(path = "")
	public ResponseEntity<ClanAdministrativnogOsoblja> dodaj(@RequestBody ClanAdministrativnogOsoblja body){
		
		Authority auth = serviceAuthority.nadjiPoNazivu("CLAN");
		RegistrovanKorisnik korisnik = serviceKorisnik.findById(body.getKorisnik().getId());
		
		korisnik.setDodeljen(true);
		korisnik.setAuthority(auth);
		
		serviceKorisnik.save(korisnik);
		service.save(body);
		
		
		return new ResponseEntity<ClanAdministrativnogOsoblja>(HttpStatus.CREATED);
	}
	
}
