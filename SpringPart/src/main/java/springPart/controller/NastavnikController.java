package springPart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import springPart.DTO.NastavnikDTO;
import springPart.model.Nastavnik;
import springPart.service.NastavnikService;

@Controller
@CrossOrigin
@RequestMapping(path = "/nastavnik")
public class NastavnikController extends AbstractController<Nastavnik, NastavnikDTO, NastavnikService> {

	public NastavnikController(NastavnikService service) {
		super(service, NastavnikDTO.class);
		
	}

}
