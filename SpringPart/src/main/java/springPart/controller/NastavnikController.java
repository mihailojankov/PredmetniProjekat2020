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

import springPart.DTO.NastavnikDTO;
import springPart.model.Nastavnik;
import springPart.service.NastavnikService;

@Controller
@CrossOrigin
@RequestMapping(path = "/nastavnik")
public class NastavnikController {
	
	@Autowired
	NastavnikService service;
	ArrayList<NastavnikDTO> lista;
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<NastavnikDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		lista = new ArrayList<NastavnikDTO>();
		for(Nastavnik x:service.dobaviSve()) {
			lista.add(mm.map(x, NastavnikDTO.class));
		}
		
		return new ResponseEntity<ArrayList<NastavnikDTO>>(lista, HttpStatus.OK);
	}
	
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<NastavnikDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		Nastavnik existing = service.dobaviPoId(id);
		
		if(existing == null) {
			return new ResponseEntity<NastavnikDTO>(HttpStatus.NOT_FOUND);
		}
		NastavnikDTO obj = mm.map(existing, NastavnikDTO.class);
		return new ResponseEntity<NastavnikDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Nastavnik> dodajNovi(@RequestBody Nastavnik obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<Nastavnik>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<Nastavnik>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<Nastavnik> izmeni(@RequestBody Nastavnik obj) {
        Nastavnik existing = service.dobaviPoId(obj.getId());
        
        if (existing == null) {
            return new ResponseEntity<Nastavnik>(HttpStatus.NOT_FOUND);
        }
        //Menja se sta je potrebno
        //existing.setIme(obj.getIme());
        //existing.setPrezime(obj.getPrezime());
        
        service.save(existing);
        return new ResponseEntity<Nastavnik>(HttpStatus.OK);
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
