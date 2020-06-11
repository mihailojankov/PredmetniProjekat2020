package springPart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import springPart.DTO.IspitDTO;
import springPart.model.ispitPart.Ispit;
import springPart.service.IspitService;

@Controller
@CrossOrigin
@RequestMapping(path = "/ispit")
public class IspitController extends AbstractController<Ispit, IspitDTO, IspitService> {

	public IspitController(IspitService service) {
		super(service, IspitDTO.class);
		
	}

}
