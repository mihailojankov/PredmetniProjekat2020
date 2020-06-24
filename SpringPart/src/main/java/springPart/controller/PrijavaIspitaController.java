package springPart.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import springPart.DTO.PrijavaIspitaDTO;
import springPart.model.ispitPart.PrijavaIspita;
import springPart.service.PrijavaIspitaService;

@Controller
@CrossOrigin
@RequestMapping(path = "/prijavaIspita")
public class PrijavaIspitaController extends AbstractController<PrijavaIspita, PrijavaIspitaDTO, PrijavaIspitaService> {

	public PrijavaIspitaController(PrijavaIspitaService service) {
		super(service, PrijavaIspitaDTO.class);
		
	}
	
	@GetMapping(path = "/nadjiPoIdStudenta/{id}")
	public ResponseEntity<ArrayList<PrijavaIspitaDTO>> nadjiPrijavePoIdStudenta(@PathVariable("id") Long id){
		ArrayList<PrijavaIspitaDTO> listaPrijava = new ArrayList<PrijavaIspitaDTO>();
		for(PrijavaIspita x : service.nadjiPrijavePoIdStudenta(id)) {
			listaPrijava.add(mm.map(x,PrijavaIspitaDTO.class));
		}
		return new ResponseEntity<ArrayList<PrijavaIspitaDTO>>(listaPrijava, HttpStatus.OK);
	}

}
