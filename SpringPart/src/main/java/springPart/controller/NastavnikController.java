package springPart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import springPart.DTO.NastavnikDTO;
import springPart.model.Authority;
import springPart.model.Nastavnik;
import springPart.model.Nastavnik;
import springPart.model.RegistrovanKorisnik;
import springPart.service.NastavnikService;

@Controller
@CrossOrigin
@RequestMapping(path = "/nastavnik")
public class NastavnikController extends AbstractController<Nastavnik, NastavnikDTO, NastavnikService> {

	public NastavnikController(NastavnikService service) {
		super(service, NastavnikDTO.class);
		
	}
	
	@Override
	@PostMapping(path = "")
	public ResponseEntity<Nastavnik> dodaj(@RequestBody Nastavnik body){
		
		Authority auth = serviceAuthority.nadjiPoNazivu("NASTAVNIK");
		RegistrovanKorisnik korisnik = serviceKorisnik.findById(body.getKorisnik().getId());
		
		korisnik.setDodeljen(true);
		korisnik.setAuthority(auth);
		
		serviceKorisnik.save(korisnik);
		service.save(body);
		
		
		return new ResponseEntity<Nastavnik>(HttpStatus.CREATED);
	}

}
