package springPart.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class SmerFakulteta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String naziv;
	String opis;
	
	
	@ManyToMany(mappedBy = "listaSmerovaFakulteta")
	List<Predmet> predmeti;
	
	@ManyToOne
	Fakultet fakultet;
	
	
	public SmerFakulteta() {
		
	}

	public SmerFakulteta(Long id, String naziv, String opis, List<Predmet> predmeti) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.predmeti = predmeti;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getOpis() {
		return opis;
	}


	public void setOpis(String opis) {
		this.opis = opis;
	}


	public List<Predmet> getPredmeti() {
		return predmeti;
	}


	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}
	
	
	
	
}
