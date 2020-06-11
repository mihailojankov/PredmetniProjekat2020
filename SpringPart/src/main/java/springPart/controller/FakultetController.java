package springPart.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import springPart.DTO.FakultetDTO;
import springPart.model.predmetPart.Fakultet;
import springPart.service.FakultetService;

@Controller
@CrossOrigin
@RequestMapping(path = "/fakultet")
public class FakultetController extends AbstractController<Fakultet, FakultetDTO, FakultetService>{
	
	public FakultetController(FakultetService service) {
		super(service, FakultetDTO.class);
	}
	
}
