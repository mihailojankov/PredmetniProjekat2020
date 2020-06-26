package springPart.model.korisnikPart;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
<<<<<<< HEAD
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;

=======
>>>>>>> origin/master
import springPart.model.AbstractModel;
import springPart.model.security.Authority;

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

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public boolean isDodeljen() {
		return dodeljen;
	}

	public void setDodeljen(boolean dodeljen) {
		this.dodeljen = dodeljen;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	
	
}
