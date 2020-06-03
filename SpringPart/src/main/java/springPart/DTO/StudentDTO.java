package springPart.DTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO extends AbstractDTO{
	
	String jmbg;
	LocalDate datumRodjenja;
	String brojIndeksa;
	String mestoRodjenja;
	String drzavaRodjenja;
	boolean vanredni;
	String godinaUpisa;
	RegistrovanKorisnikDTO korisnik;
	List<PredmetDTO> listaPredmeta;
}
