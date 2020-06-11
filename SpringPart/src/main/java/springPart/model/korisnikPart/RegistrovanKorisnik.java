package springPart.model.korisnikPart;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;
import springPart.model.AbstractModel;
import springPart.model.security.Authority;

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
	boolean dodeljen;
	
	@ManyToOne(optional = true)
	Authority authority;
	
	
	public RegistrovanKorisnik() {
		
	}

	public RegistrovanKorisnik(String korisnickoIme, String lozinka, String email, String ime, String prezime,
			String brojTelefona, String adresa, boolean dodeljen, Authority authority) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
		this.ime = ime;
		this.prezime = prezime;
		this.brojTelefona = brojTelefona;
		this.adresa = adresa;
		this.dodeljen = dodeljen;
		this.authority = authority;
	}

	

	



	
	
}
