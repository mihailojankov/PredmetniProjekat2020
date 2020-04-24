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

import springPart.DTO.PredmetDTO;
import springPart.model.Predmet;
import springPart.service.PredmetService;

@Controller
@CrossOrigin
@RequestMapping(path = "/predmet")
public class PredmetController {
	
	@Autowired
	PredmetService service;
	ArrayList<PredmetDTO> lista;
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<PredmetDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		lista = new ArrayList<PredmetDTO>();
		for(Predmet x:service.dobaviSve()) {
			lista.add(mm.map(x, PredmetDTO.class));
		}
		
		return new ResponseEntity<ArrayList<PredmetDTO>>(lista, HttpStatus.OK);
	}
	
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PredmetDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		Predmet existing = service.dobaviPoId(id);
		
		if(existing == null) {
			return new ResponseEntity<PredmetDTO>(HttpStatus.NOT_FOUND);
		}
		PredmetDTO obj = mm.map(existing, PredmetDTO.class);
		return new ResponseEntity<PredmetDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Predmet> dodajNovi(@RequestBody Predmet obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<Predmet>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<Predmet>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<Predmet> izmeni(@RequestBody Predmet obj) {
        Predmet existing = service.dobaviPoId(obj.getId());
        
        if (existing == null) {
            return new ResponseEntity<Predmet>(HttpStatus.NOT_FOUND);
        }
        //Menja se sta je potrebno
        //existing.setIme(obj.getIme());
        //existing.setPrezime(obj.getPrezime());
        
        service.save(existing);
        return new ResponseEntity<Predmet>(HttpStatus.OK);
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
