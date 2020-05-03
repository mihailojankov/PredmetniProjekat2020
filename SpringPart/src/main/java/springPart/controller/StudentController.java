package springPart.controller;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springPart.DTO.StudentDTO;
import springPart.model.korisnik.Student;
import springPart.service.RegistrovanKorisnikService;
import springPart.service.StudentService;

@Controller
@CrossOrigin
@RequestMapping(path = "/student")
public class StudentController {
	
	@Autowired
	StudentService service;
	ArrayList<StudentDTO> lista;
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<StudentDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		lista = new ArrayList<StudentDTO>();
		for(Student x:service.dobaviSve()) {
			lista.add(mm.map(x, StudentDTO.class));
		}
		
		return new ResponseEntity<ArrayList<StudentDTO>>(lista, HttpStatus.OK);
	}
	
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		Student existing = service.dobaviPoId(id);
		
		if(existing == null) {
			return new ResponseEntity<StudentDTO>(HttpStatus.NOT_FOUND);
		}
		StudentDTO obj = mm.map(existing, StudentDTO.class);
		return new ResponseEntity<StudentDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Student> dodajNovi(@RequestBody Student obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<Student>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<Student>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<Student> izmeni(@RequestBody Student obj) {
        Student existing = service.dobaviPoId(obj.getId());
        
        if (existing == null) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        //Menja se sta je potrebno
        //existing.setIme(obj.getIme());
        //existing.setPrezime(obj.getPrezime());
        
        service.save(existing);
        return new ResponseEntity<Student>(HttpStatus.OK);
    }

    //Brisanje
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> brisanje(@PathVariable("id") Long id) {
    	
        if (service.dobaviPoId(id) == null) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        
        service.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
