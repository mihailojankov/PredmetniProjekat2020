package springPart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Nastavnik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String biografija;
	@Column(unique = true)
	String jmbg;
	boolean profesor;
	boolean asistent;
	
	@OneToOne
	@JoinColumn(name = "korisnik_id")
	RegistrovanKorisnik korisnik;
	
	public Nastavnik() {
		
	}

	public Nastavnik(Long id, String biografija, String jmbg, boolean profesor, boolean asistent,
			RegistrovanKorisnik korisnik) {
		super();
		this.id = id;
		this.biografija = biografija;
		this.jmbg = jmbg;
		this.profesor = profesor;
		this.asistent = asistent;
		this.korisnik = korisnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBiografija() {
		return biografija;
	}

	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public boolean isProfesor() {
		return profesor;
	}

	public void setProfesor(boolean profesor) {
		this.profesor = profesor;
	}

	public boolean isAsistent() {
		return asistent;
	}

	public void setAsistent(boolean asistent) {
		this.asistent = asistent;
	}

	public RegistrovanKorisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(RegistrovanKorisnik korisnik) {
		this.korisnik = korisnik;
	}
	
}
