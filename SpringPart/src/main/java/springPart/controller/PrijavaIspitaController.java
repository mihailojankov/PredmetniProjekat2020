package springPart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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

}
