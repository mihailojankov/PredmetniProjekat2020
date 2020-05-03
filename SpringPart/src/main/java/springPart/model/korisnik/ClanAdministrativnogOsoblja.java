package springPart.model.korisnik;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ClanAdministrativnogOsoblja {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String jmbg;
	String uloga;
	
	@OneToOne
	RegistrovanKorisnik korisnik;

	public ClanAdministrativnogOsoblja() {
		super();
	}

	public ClanAdministrativnogOsoblja(Long id, String jmbg, String uloga, RegistrovanKorisnik korisnik) {
		super();
		this.id = id;
		this.jmbg = jmbg;
		this.uloga = uloga;
		this.korisnik = korisnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
