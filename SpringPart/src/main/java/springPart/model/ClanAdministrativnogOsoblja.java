package springPart.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

	
}
