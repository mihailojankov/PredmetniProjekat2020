package springPart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import springPart.DTO.PredmetDTO;
import springPart.model.predmetPart.Predmet;
import springPart.service.PredmetService;

@Controller
@CrossOrigin
@RequestMapping(path = "/predmet")
public class PredmetController extends AbstractController<Predmet, PredmetDTO, PredmetService> {

	public PredmetController(PredmetService service) {
		super(service, PredmetDTO.class);
		
	}

}
