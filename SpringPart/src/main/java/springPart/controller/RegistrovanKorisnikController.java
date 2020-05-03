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

import springPart.DTO.RegistrovanKorisnikDTO;
import springPart.model.korisnik.RegistrovanKorisnik;
import springPart.service.RegistrovanKorisnikService;


@Controller
@CrossOrigin
@RequestMapping(path = "/registrovanKorisnik")

public class RegistrovanKorisnikController {
	@Autowired
	RegistrovanKorisnikService service;
	ArrayList<RegistrovanKorisnikDTO> lista;
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<RegistrovanKorisnikDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		lista = new ArrayList<RegistrovanKorisnikDTO>();
		for(RegistrovanKorisnik x:service.dobaviSve()) {
			lista.add(mm.map(x, RegistrovanKorisnikDTO.class));
		}
		System.out.println("Radi");
		return new ResponseEntity<ArrayList<RegistrovanKorisnikDTO>>(lista, HttpStatus.OK);
	}
	
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RegistrovanKorisnikDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		RegistrovanKorisnik existing = service.dobaviPoId(id);
		
		if(existing == null) {
			return new ResponseEntity<RegistrovanKorisnikDTO>(HttpStatus.NOT_FOUND);
		}
		RegistrovanKorisnikDTO obj = mm.map(existing, RegistrovanKorisnikDTO.class);
		return new ResponseEntity<RegistrovanKorisnikDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<RegistrovanKorisnik> dodajNovi(@RequestBody RegistrovanKorisnik obj) {
		
		//Provera postojecih
		for(RegistrovanKorisnik x:service.dobaviSve()) {
			if(
					x.getId() == obj.getId() || 
					x.getKorisnickoIme().equals(obj.getKorisnickoIme()) || 
					x.getEmail().equals(obj.getEmail())) {
				
				return new ResponseEntity<RegistrovanKorisnik>(HttpStatus.CONFLICT);
			}
		}
        
        service.save(obj);
        return new ResponseEntity<RegistrovanKorisnik>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<RegistrovanKorisnik> izmeni(@RequestBody RegistrovanKorisnik obj) {
        RegistrovanKorisnik existing = service.dobaviPoId(obj.getId());
        
        if (existing == null) {
            return new ResponseEntity<RegistrovanKorisnik>(HttpStatus.NOT_FOUND);
        }
        //Menja se sta je potrebno
        //existing.setIme(obj.getIme());
        //existing.setPrezime(obj.getPrezime());
        
        service.save(existing);
        return new ResponseEntity<RegistrovanKorisnik>(HttpStatus.OK);
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
