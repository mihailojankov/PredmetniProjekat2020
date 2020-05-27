package springPart.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IshodIspitaDTO extends AbstractDTO{
	
	float prviKolokvijumBodovi;
	float drugiKolokvijumBodovi;
	float zavrsniIspitBodovi;
	boolean polozen;
	StudentDTO student;
	PredmetDTO predmet;
	
}
