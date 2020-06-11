package springPart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import springPart.DTO.StudentDTO;
import springPart.model.korisnikPart.RegistrovanKorisnik;
import springPart.model.korisnikPart.Student;
import springPart.model.security.Authority;
import springPart.service.StudentService;

@Controller
@CrossOrigin
@RequestMapping(path = "/student")
public class StudentController extends AbstractController<Student, StudentDTO, StudentService> {

	public StudentController(StudentService service) {
		super(service, StudentDTO.class);
		
	}
	
	
	@Override
	@PostMapping(path = "")
	public ResponseEntity<Student> dodaj(@RequestBody Student body){
		
		Authority auth = serviceAuthority.nadjiPoNazivu("STUDENT");
		RegistrovanKorisnik korisnik = serviceKorisnik.findById(body.getKorisnik().getId());
		
		korisnik.setDodeljen(true);
		korisnik.setAuthority(auth);
		
		serviceKorisnik.save(korisnik);
		service.save(body);
		
		
		return new ResponseEntity<Student>(HttpStatus.CREATED);
	}
}
