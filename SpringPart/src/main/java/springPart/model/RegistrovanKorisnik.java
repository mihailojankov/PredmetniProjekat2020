package springPart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RegistrovanKorisnik extends AbstractModel{
	
	@Column(unique = true, nullable = false)
	String korisnickoIme;
	@Column(nullable = false)
	String lozinka;
	@Column(unique = true, nullable = false)
	String email;
	String ime;
	String prezime;
	String brojTelefona;
	String adresa;
	
	
	public RegistrovanKorisnik() {
		
	}

	public RegistrovanKorisnik(String korisnickoIme, String lozinka, String email, String ime, String prezime,
			String brojTelefona, String adresa) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
		this.ime = ime;
		this.prezime = prezime;
		this.brojTelefona = brojTelefona;
		this.adresa = adresa;
	}
	
}
