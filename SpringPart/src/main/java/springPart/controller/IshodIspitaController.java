package springPart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import springPart.DTO.IshodIspitaDTO;
import springPart.model.ispitPart.IshodIspita;
import springPart.service.IshodIspitaService;

import java.util.ArrayList;

@Controller
@CrossOrigin
@RequestMapping(path = "/ishodIspita")
public class IshodIspitaController extends AbstractController<IshodIspita, IshodIspitaDTO, IshodIspitaService> {
	
	public IshodIspitaController(IshodIspitaService service) {
		super(service,IshodIspitaDTO.class);
		
	}

	@RequestMapping(path = "/dodajListuIshoda", method = RequestMethod.POST)
	public ResponseEntity<IshodIspita> dodajListuIshoda(@RequestBody ArrayList<IshodIspita> lista){
		//Ubaci version control

		for(IshodIspita ishod:lista){
			IshodIspita postojeciIshod = service.pronadjiIshod(ishod.getStudent().getId(), ishod.getPredmet().getId());

			if(postojeciIshod != null){
				postojeciIshod.setPolozen(ishod.isPolozen());
				postojeciIshod.setPrviKolokvijumBodovi(ishod.getPrviKolokvijumBodovi());
				postojeciIshod.setDrugiKolokvijumBodovi(ishod.getDrugiKolokvijumBodovi());
				postojeciIshod.setZavrsniIspitBodovi(ishod.getDrugiKolokvijumBodovi());
				service.save(postojeciIshod);
			}
			else{
				service.save(ishod);
			}
		}

		return new ResponseEntity<IshodIspita>(HttpStatus.OK);
	}

}
