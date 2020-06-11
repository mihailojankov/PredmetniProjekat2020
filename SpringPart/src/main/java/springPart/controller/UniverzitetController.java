package springPart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import springPart.DTO.UniverzitetDTO;
import springPart.model.predmetPart.Univerzitet;
import springPart.service.UniverzitetService;

@Controller
@CrossOrigin
@RequestMapping(path = "/univerzitet")
public class UniverzitetController extends AbstractController<Univerzitet, UniverzitetDTO, UniverzitetService> {

	public UniverzitetController(UniverzitetService service) {
		super(service, UniverzitetDTO.class);
		
	}

}
