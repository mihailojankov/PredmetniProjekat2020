package springPart.DTO;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakultetDTO extends AbstractDTO{
	String naziv;
	String adresa;
	String mesto;
	String opis;
	UniverzitetDTO univerzitet;
	List<SmerFakultetaDTO> smerovi;
	
	
}
