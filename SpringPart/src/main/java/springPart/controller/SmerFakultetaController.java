package springPart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import springPart.DTO.SmerFakultetaDTO;
import springPart.model.SmerFakulteta;
import springPart.service.SmerFakultetaService;

@Controller
@CrossOrigin
@RequestMapping(path = "/smerFakulteta")
public class SmerFakultetaController extends AbstractController<SmerFakulteta, SmerFakultetaDTO, SmerFakultetaService> {

	public SmerFakultetaController(SmerFakultetaService service) {
		super(service, SmerFakultetaDTO.class);
		
	}

}
