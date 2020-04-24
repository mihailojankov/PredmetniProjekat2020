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

import springPart.DTO.FakultetDTO;
import springPart.DTO.FakultetDTO;
import springPart.model.Fakultet;
import springPart.service.FakultetService;
import springPart.service.RegistrovanKorisnikService;

@Controller
@CrossOrigin
@RequestMapping(path = "/fakultet")
public class FakultetController {
	
	@Autowired
	FakultetService service;
	ArrayList<FakultetDTO> lista;
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<FakultetDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		lista = new ArrayList<FakultetDTO>();
		for(Fakultet x:service.dobaviSve()) {
			lista.add(mm.map(x, FakultetDTO.class));
		}
		
		return new ResponseEntity<ArrayList<FakultetDTO>>(lista, HttpStatus.OK);
	}
	
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FakultetDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		Fakultet existing = service.dobaviPoId(id);
		
		if(existing == null) {
			return new ResponseEntity<FakultetDTO>(HttpStatus.NOT_FOUND);
		}
		FakultetDTO obj = mm.map(existing, FakultetDTO.class);
		return new ResponseEntity<FakultetDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Fakultet> dodajNovi(@RequestBody Fakultet obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<Fakultet>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<Fakultet>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<Fakultet> izmeni(@RequestBody Fakultet obj) {
        Fakultet existing = service.dobaviPoId(obj.getId());
        
        if (existing == null) {
            return new ResponseEntity<Fakultet>(HttpStatus.NOT_FOUND);
        }
        //Menja se sta je potrebno
        //existing.setIme(obj.getIme());
        //existing.setPrezime(obj.getPrezime());
        
        service.save(existing);
        return new ResponseEntity<Fakultet>(HttpStatus.OK);
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
