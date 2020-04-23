package springPart.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Univerzitet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String naziv;
	Date datumOsnivanja;
	String drzava;
	String adresa;
	String mesto;
	String opisUniverziteta;
	
	@OneToMany(mappedBy = "univerzitet")
	List<Fakultet> fakulteti;
	
	public Univerzitet() {
		
	}

	public Univerzitet(Long id, String naziv, Date datumOsnivanja, String drzava, String adresa, String mesto,
			String opisUniverziteta, List<Fakultet> fakulteti) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.drzava = drzava;
		this.adresa = adresa;
		this.mesto = mesto;
		this.opisUniverziteta = opisUniverziteta;
		this.fakulteti = fakulteti;
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

	public Date getDatumOsnivanja() {
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(Date datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getOpisUniverziteta() {
		return opisUniverziteta;
	}

	public void setOpisUniverziteta(String opisUniverziteta) {
		this.opisUniverziteta = opisUniverziteta;
	}

	public List<Fakultet> getFakulteti() {
		return fakulteti;
	}

	public void setFakulteti(List<Fakultet> fakulteti) {
		this.fakulteti = fakulteti;
	}
	
}
