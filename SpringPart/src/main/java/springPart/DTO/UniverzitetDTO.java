package springPart.DTO;

import java.util.Date;
import java.util.List;

public class UniverzitetDTO {
	Long id;
	String naziv;
	Date datumOsnivanja;
	String drzava;
	String adresa;
	String mesto;
	String opisUniverziteta;
	List<FakultetDTO> fakulteti;
}
