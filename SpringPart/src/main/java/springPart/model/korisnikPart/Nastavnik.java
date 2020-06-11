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

@Getter
@Setter
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

	
}
