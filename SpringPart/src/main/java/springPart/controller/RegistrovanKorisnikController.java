package springPart.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import springPart.DTO.*;
import springPart.model.korisnikPart.ClanAdministrativnogOsoblja;
import springPart.model.korisnikPart.Nastavnik;
import springPart.model.korisnikPart.RegistrovanKorisnik;
import springPart.model.korisnikPart.Student;
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
		if(service.proveraPostojeceg(body.getEmail(), body.getKorisnickoIme())) {
			System.out.println(body.getKorisnickoIme());
			return new ResponseEntity<RegistrovanKorisnik>(HttpStatus.CONFLICT);
		}
		
		service.save(body);
		
		
		return new ResponseEntity<RegistrovanKorisnik>(HttpStatus.CREATED);
	}

	@GetMapping(path = "dobaviKorisnickePodatke")
	public ResponseEntity<?> dobaviKorisnickePodatke(@RequestParam("username") String username){

		Object podaci = service.findUser(username);

		if(podaci.getClass().equals(Nastavnik.class)){
			podaci = mm.map(podaci, NastavnikDTO.class);
		}
		if(podaci.getClass().equals(ClanAdministrativnogOsoblja.class)){
			podaci = mm.map(podaci, ClanAdministrativnogOsobljaDTO.class);
		}
		if(podaci.getClass().equals(Student.class)){
			podaci = mm.map(podaci, StudentDTO.class);
		}
		if(podaci.getClass().equals(RegistrovanKorisnik.class)){
			podaci = mm.map(podaci, RegistrovanKorisnikDTO.class);
		}

		return new ResponseEntity<>(podaci,HttpStatus.OK);
	}

	
	
	

}
