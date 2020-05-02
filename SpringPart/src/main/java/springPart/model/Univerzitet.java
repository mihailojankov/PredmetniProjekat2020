package springPart.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Univerzitet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String naziv;
	LocalDate datumOsnivanja;
	String drzava;
	String adresa;
	String mesto;
	String opisUniverziteta;
	
	
	@OneToOne
	@JoinColumn(name = "rektor_id")
	Nastavnik rektor;
	
	@OneToMany(mappedBy = "univerzitet")
	List<Fakultet> fakulteti;
	
	public Univerzitet() {
		
	}

	public Univerzitet(Long id, String naziv, LocalDate datumOsnivanja, String drzava, String adresa, String mesto,
			String opisUniverziteta, List<Fakultet> fakulteti, Nastavnik rektor) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.drzava = drzava;
		this.adresa = adresa;
		this.mesto = mesto;
		this.opisUniverziteta = opisUniverziteta;
		this.fakulteti = fakulteti;
		this.rektor = rektor;
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

	public LocalDate getDatumOsnivanja() {
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(LocalDate datumOsnivanja) {
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

	public Nastavnik getRektor() {
		return rektor;
	}

	public void setRektor(Nastavnik rektor) {
		this.rektor = rektor;
	}
	
	
	
}
