package springPart.DTO;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UniverzitetDTO extends AbstractDTO{
	String naziv;
	Date datumOsnivanja;
	String drzava;
	String adresa;
	String mesto;
	String opisUniverziteta;
	
}
