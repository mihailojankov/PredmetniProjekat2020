package springPart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import springPart.DTO.IshodIspitaDTO;
import springPart.model.ispitPart.IshodIspita;
import springPart.service.IshodIspitaService;

@Controller
@CrossOrigin
@RequestMapping(path = "/ishodIspita")
public class IshodIspitaController extends AbstractController<IshodIspita, IshodIspitaDTO, IshodIspitaService> {
	
	public IshodIspitaController(IshodIspitaService service) {
		super(service,IshodIspitaDTO.class);
		
	}

}
