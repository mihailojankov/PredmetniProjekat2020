package springPart.controller;

import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import springPart.DTO.AbstractDTO;
import springPart.model.AbstractModel;
import springPart.service.CommonService;

public abstract class AbstractController <E extends AbstractModel, D extends AbstractDTO, S extends CommonService<E>>{

	@Autowired
	public final S service;
	
	private Class<D> dtoType;
	ModelMapper mm = new ModelMapper();
	
	public AbstractController(S service, Class<D> dtoType) {
		this.service = service;
		this.dtoType = dtoType;
	}
	
	//Dobavi sve
	@GetMapping(path = "")
	public ResponseEntity<ArrayList<D>> dobaviSve(){
		
		ArrayList<D> lista = new ArrayList<D>();
		for(E x:service.findAll()) {
			lista.add(mm.map(x, this.dtoType));
		}
		return new ResponseEntity<ArrayList<D>>(lista, HttpStatus.OK);
	}
	
	//Dobavi po id
	@GetMapping(path = "/{id}")
	public ResponseEntity<D> dobaviJedan(@PathVariable("id") Long id){
		E single = service.findById(id);
		
		if(single != null) {
			D dtoSingle = mm.map(single, dtoType);
			return new ResponseEntity<D>(dtoSingle, HttpStatus.OK);
		}
		return new ResponseEntity<D>(HttpStatus.NOT_FOUND);
		
	}
	
	//Dodaj novi
	@PostMapping(path = "")
	public ResponseEntity<E> dodaj(@RequestBody E body){
		service.save(body);
		return new ResponseEntity<E>(HttpStatus.CREATED);
	}
	
	//Obrisi po id
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<E> obrisi(@PathVariable("id") Long id){
		service.deleteById(id);
		return new ResponseEntity<E>(HttpStatus.OK);
	}
	
	//Izmeni
	@PutMapping(path = "")
	public ResponseEntity<E> izmeni(@RequestBody E body){
		E existing = service.findById(body.getId());
		if(existing != null) {
			existing = body;
			service.save(existing);
			return new ResponseEntity<E>(HttpStatus.OK);
		}
		return new ResponseEntity<E>(HttpStatus.NOT_FOUND);
	}
	
	
	
}
