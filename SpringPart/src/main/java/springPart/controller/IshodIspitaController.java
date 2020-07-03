package springPart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import springPart.DTO.IshodIspitaDTO;
import springPart.model.ispitPart.IshodIspita;
import springPart.model.predmetPart.Predmet;
import springPart.service.IshodIspitaService;
import springPart.versionControl.IshodVersionControl;
import springPart.versionControl.IshodiVersionControl;
import springPart.versionControl.XMLConverter;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(path = "/ishodIspita")
public class IshodIspitaController extends AbstractController<IshodIspita, IshodIspitaDTO, IshodIspitaService> {
	
	public IshodIspitaController(IshodIspitaService service) {
		super(service,IshodIspitaDTO.class);
		
	}

	@RequestMapping(path = "/dodajListuIshoda", method = RequestMethod.POST)
	public ResponseEntity<IshodIspita> dodajListuIshoda(@RequestBody ArrayList<IshodIspita> lista){
		//Version control
		Predmet p = lista.get(0).getPredmet();
		List<IshodVersionControl> latest = IshodiVersionControl.konvertuj(service.pronadjiIshodePoPredmetu(p.getId()));

		if(!latest.isEmpty()){
			IshodiVersionControl ishodi = new IshodiVersionControl();
			ishodi.setListaIshoda(latest);

			try {
				XMLConverter.zapisiUXML(ishodi, p.getNaziv());
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}


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
