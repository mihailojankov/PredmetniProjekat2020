package springPart.DTO;
import lombok.Getter;
import lombok.Setter;

public class ClanAdministrativnogOsobljaDTO extends AbstractDTO{
	String jmbg;
	String uloga;
	RegistrovanKorisnikDTO korisnik;
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public String getUloga() {
		return uloga;
	}
	public void setUloga(String uloga) {
		this.uloga = uloga;
	}
	public RegistrovanKorisnikDTO getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(RegistrovanKorisnikDTO korisnik) {
		this.korisnik = korisnik;
	}
	
	
}
