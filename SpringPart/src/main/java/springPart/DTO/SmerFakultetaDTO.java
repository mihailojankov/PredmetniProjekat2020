package springPart.DTO;

import java.util.List;

public class SmerFakultetaDTO {
	Long id;
	String naziv;
	String opis;
	List<PredmetDTO> predmeti;
	FakultetDTO fakultet;
}
