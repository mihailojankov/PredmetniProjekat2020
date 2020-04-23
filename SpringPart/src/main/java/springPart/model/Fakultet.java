package springPart.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Fakultet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	
	String naziv;
	String adresa;
	String mesto;
	String opis;
	
	@OneToMany(mappedBy = "fakultet")
	List<SmerFakulteta> smerovi;
	
	@ManyToOne
	Univerzitet univerzitet;
	
	public Fakultet() {
		
	}

	public Fakultet(Long id, String naziv, String adresa, String mesto, String opis, List<SmerFakulteta> smerovi,
			Univerzitet univerzitet) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.mesto = mesto;
		this.opis = opis;
		this.smerovi = smerovi;
		this.univerzitet = univerzitet;
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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<SmerFakulteta> getSmerovi() {
		return smerovi;
	}

	public void setSmerovi(List<SmerFakulteta> smerovi) {
		this.smerovi = smerovi;
	}

	public Univerzitet getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(Univerzitet univerzitet) {
		this.univerzitet = univerzitet;
	}
	
	
}
