package springPart.DTO;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmerFakultetaDTO extends AbstractDTO{
	
	String naziv;
	String opis;
	List<PredmetDTO> predmeti;
	
}
