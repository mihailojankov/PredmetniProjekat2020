package springPart.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrovanKorisnikDTO extends AbstractDTO{
	
	String korisnickoIme;
	String lozinka;
	String email;
	String ime;
	String prezime;
	String brojTelefona;
	String adresa;
		
}
