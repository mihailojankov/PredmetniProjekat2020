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

import springPart.DTO.UniverzitetDTO;
import springPart.model.Univerzitet;
import springPart.service.RegistrovanKorisnikService;
import springPart.service.UniverzitetService;

@Controller
@CrossOrigin
@RequestMapping(path = "/univerzitet")
public class UniverzitetController {
	
	@Autowired
	UniverzitetService service;
	ArrayList<UniverzitetDTO> lista;
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<UniverzitetDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		lista = new ArrayList<UniverzitetDTO>();
		for(Univerzitet x:service.dobaviSve()) {
			lista.add(mm.map(x, UniverzitetDTO.class));
		}
		
		return new ResponseEntity<ArrayList<UniverzitetDTO>>(lista, HttpStatus.OK);
	}
	
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UniverzitetDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		Univerzitet existing = service.dobaviPoId(id);
		
		if(existing == null) {
			return new ResponseEntity<UniverzitetDTO>(HttpStatus.NOT_FOUND);
		}
		UniverzitetDTO obj = mm.map(existing, UniverzitetDTO.class);
		return new ResponseEntity<UniverzitetDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Univerzitet> dodajNovi(@RequestBody Univerzitet obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<Univerzitet>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<Univerzitet>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<Univerzitet> izmeni(@RequestBody Univerzitet obj) {
        Univerzitet existing = service.dobaviPoId(obj.getId());
        
        if (existing == null) {
            return new ResponseEntity<Univerzitet>(HttpStatus.NOT_FOUND);
        }
        //Menja se sta je potrebno
        //existing.setIme(obj.getIme());
        //existing.setPrezime(obj.getPrezime());
        
        service.save(existing);
        return new ResponseEntity<Univerzitet>(HttpStatus.OK);
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
