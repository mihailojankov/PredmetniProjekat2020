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

import springPart.DTO.SmerFakultetaDTO;
import springPart.model.SmerFakulteta;
import springPart.service.SmerFakultetaService;

@Controller
@CrossOrigin
@RequestMapping(path = "/smerFakulteta")
public class SmerFakultetaController {
	
	@Autowired
	SmerFakultetaService service;
	ArrayList<SmerFakultetaDTO> lista;
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<SmerFakultetaDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		lista = new ArrayList<SmerFakultetaDTO>();
		for(SmerFakulteta x:service.dobaviSve()) {
			lista.add(mm.map(x, SmerFakultetaDTO.class));
		}
		
		return new ResponseEntity<ArrayList<SmerFakultetaDTO>>(lista, HttpStatus.OK);
	}
	
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<SmerFakultetaDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		SmerFakulteta existing = service.dobaviPoId(id);
		
		if(existing == null) {
			return new ResponseEntity<SmerFakultetaDTO>(HttpStatus.NOT_FOUND);
		}
		SmerFakultetaDTO obj = mm.map(existing, SmerFakultetaDTO.class);
		return new ResponseEntity<SmerFakultetaDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<SmerFakulteta> dodajNovi(@RequestBody SmerFakulteta obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<SmerFakulteta>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<SmerFakulteta>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<SmerFakulteta> izmeni(@RequestBody SmerFakulteta obj) {
        SmerFakulteta existing = service.dobaviPoId(obj.getId());
        
        if (existing == null) {
            return new ResponseEntity<SmerFakulteta>(HttpStatus.NOT_FOUND);
        }
        //Menja se sta je potrebno
        //existing.setIme(obj.getIme());
        //existing.setPrezime(obj.getPrezime());
        
        service.save(existing);
        return new ResponseEntity<SmerFakulteta>(HttpStatus.OK);
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
    
    //Pronadji smerove fakulteta
    @RequestMapping(path = "/pronadjiSmeroveFakulteta/{id}", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<SmerFakultetaDTO>> pronadjiSmeroveFakulteta(@PathVariable("id") Long id){
    	ModelMapper mm = new ModelMapper();
		
		lista = new ArrayList<SmerFakultetaDTO>();
		for(SmerFakulteta x:service.dobaviPoIdFakulteta(id)) {
			lista.add(mm.map(x, SmerFakultetaDTO.class));
		}
		
		return new ResponseEntity<ArrayList<SmerFakultetaDTO>>(lista, HttpStatus.OK);
    }
}
