package springPart.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import springPart.DTO.PredmetDTO;
import springPart.DTO.PredmetDTO;
import springPart.model.ispitPart.PrijavaIspita;
import springPart.model.predmetPart.Predmet;
import springPart.service.PredmetService;

@Controller
@CrossOrigin
@RequestMapping(path = "/predmet")
public class PredmetController extends AbstractController<Predmet, PredmetDTO, PredmetService> {

	public PredmetController(PredmetService service) {
		super(service, PredmetDTO.class);
		
	}
	
	@GetMapping(path = "/pronadjiPoProfesoru/{id}")
	public ResponseEntity<ArrayList<PredmetDTO>> pronadjiPoProfesoru(@PathVariable ("id") Long id){
		ArrayList<PredmetDTO> listaPredmeta = new ArrayList<PredmetDTO>();
		for(Predmet x : service.pronadjiPoProfesoru(id)) {
			listaPredmeta.add(mm.map(x,PredmetDTO.class));
		}
		return new ResponseEntity<ArrayList<PredmetDTO>>(listaPredmeta, HttpStatus.OK);
	}

}
