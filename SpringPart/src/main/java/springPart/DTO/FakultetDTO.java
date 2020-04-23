package springPart.DTO;

import java.util.List;
public class FakultetDTO {
	Long id;
	
	
	String naziv;
	String adresa;
	String mesto;
	String opis;
	List<SmerFakultetaDTO> smerovi;
	UniverzitetDTO univerzitet;
}
