package springPart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import springPart.DTO.RokDTO;
import springPart.model.Rok;
import springPart.service.RokService;

@Controller
@CrossOrigin
@RequestMapping(path = "/rok")
public class RokController extends AbstractController<Rok, RokDTO, RokService> {

	public RokController(RokService service) {
		super(service, RokDTO.class);
		
	}

}
