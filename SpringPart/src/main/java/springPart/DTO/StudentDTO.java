package springPart.DTO;

import java.util.Date;
import java.util.List;


public class StudentDTO {
	Long id;
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
