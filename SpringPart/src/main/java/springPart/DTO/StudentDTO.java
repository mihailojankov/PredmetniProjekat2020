package springPart.DTO;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO extends AbstractDTO{
	
	String jmbg;
	Date datumRodjenja;
	String brojIndeksa;
	String mestoRodjenja;
	String drzavaRodjenja;
	boolean vanredni;
	Date godinaUpisa;
	RegistrovanKorisnikDTO korisnik;
	List<PredmetDTO> listaPredmeta;
}
