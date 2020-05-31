package springPart.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@Override
	@PostMapping(path = "")
	public ResponseEntity<RegistrovanKorisnik> dodaj(@RequestBody RegistrovanKorisnik body){
		
		ArrayList<RegistrovanKorisnikDTO> lista = new ArrayList<RegistrovanKorisnikDTO>();
		for(RegistrovanKorisnik x:service.findAll()) {
			lista.add(mm.map(x, RegistrovanKorisnikDTO.class));
		}
		
		for(RegistrovanKorisnikDTO postojeci: lista) {
			if(postojeci.getKorisnickoIme().equals(body.getKorisnickoIme()) || postojeci.getEmail().equals(body.getEmail())) {
				return new ResponseEntity<RegistrovanKorisnik>(HttpStatus.CONFLICT);
			}
		}
		
		service.save(body);
		
		
		return new ResponseEntity<RegistrovanKorisnik>(HttpStatus.CREATED);
	}

	
	
	

}
