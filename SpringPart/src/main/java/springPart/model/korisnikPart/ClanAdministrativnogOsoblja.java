package springPart.model.korisnikPart;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import springPart.model.AbstractModel;

@Entity
public class ClanAdministrativnogOsoblja extends AbstractModel{
	
	String jmbg;
	String uloga;
	
	@OneToOne
	RegistrovanKorisnik korisnik;

	public ClanAdministrativnogOsoblja() {
		
	}

	public ClanAdministrativnogOsoblja(String jmbg, String uloga, RegistrovanKorisnik korisnik) {
		super();
		this.jmbg = jmbg;
		this.uloga = uloga;
		this.korisnik = korisnik;
	}

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

	public RegistrovanKorisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(RegistrovanKorisnik korisnik) {
		this.korisnik = korisnik;
	}

	
}
