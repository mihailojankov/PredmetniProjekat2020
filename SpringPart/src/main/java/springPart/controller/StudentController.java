package springPart.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(path = "/pronadjiStudentePoPredmetu/{id}")
	public ResponseEntity<ArrayList<StudentDTO>> pronadjiStudentePoPredmetu(@PathVariable ("id") Long id){
		ArrayList<StudentDTO> listaStudenata = new ArrayList<StudentDTO>();
		for(Student x : service.pronadjiStudentaPoPredmetu(id)) {
			listaStudenata.add(mm.map(x,StudentDTO.class));
		}
		return new ResponseEntity<ArrayList<StudentDTO>>(listaStudenata, HttpStatus.OK);
	}
	
	
	
	
}
