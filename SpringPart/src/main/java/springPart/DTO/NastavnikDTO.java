package springPart.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NastavnikDTO extends AbstractDTO{
	String biografija;
	String jmbg;
	boolean profesor;
	boolean asistent;
	RegistrovanKorisnikDTO korisnik;

}
