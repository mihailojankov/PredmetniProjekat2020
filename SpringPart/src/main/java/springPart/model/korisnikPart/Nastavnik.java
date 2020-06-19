package springPart.model.korisnikPart;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import springPart.model.AbstractModel;
import springPart.model.predmetPart.Fakultet;
import springPart.model.predmetPart.Predmet;

@Entity
public class Nastavnik extends AbstractModel{
	
	String biografija;
	@Column(unique = true)
	String jmbg;
	boolean profesor;
	boolean asistent;
	
	@OneToOne
	@JoinColumn(name = "korisnik_id")
	RegistrovanKorisnik korisnik;
	
	@OneToMany(mappedBy = "dekan")
	List<Fakultet> dekanFakulteti; 
	
	@ManyToMany(mappedBy = "listaNastavnika")
	List<Predmet> predmeti;
	
	
	public Nastavnik() {
		
	}

	public Nastavnik(String biografija, String jmbg, boolean profesor, boolean asistent, RegistrovanKorisnik korisnik,
			List<Fakultet> dekanFakulteti, List<Predmet> predmeti) {
		super();
		this.biografija = biografija;
		this.jmbg = jmbg;
		this.profesor = profesor;
		this.asistent = asistent;
		this.korisnik = korisnik;
		this.dekanFakulteti = dekanFakulteti;
		this.predmeti = predmeti;
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

	public List<Fakultet> getDekanFakulteti() {
		return dekanFakulteti;
	}

	public void setDekanFakulteti(List<Fakultet> dekanFakulteti) {
		this.dekanFakulteti = dekanFakulteti;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	
}
