package springPart.model.predmetPart;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import springPart.model.AbstractModel;
import springPart.model.korisnikPart.Nastavnik;

@Entity
public class Fakultet extends AbstractModel{
	
	String naziv;
	String adresa;
	String mesto;
	String opis;
	
	@ManyToOne
	@JoinColumn(name = "dekan_id")
	Nastavnik dekan;
	
	@OneToMany(mappedBy = "fakultet")
	List<SmerFakulteta> smerovi;
	
	@ManyToOne
	Univerzitet univerzitet;
	
	public Fakultet() {
		
	}

	public Fakultet(String naziv, String adresa, String mesto, String opis, Nastavnik dekan,
			List<SmerFakulteta> smerovi, Univerzitet univerzitet) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.mesto = mesto;
		this.opis = opis;
		this.dekan = dekan;
		this.smerovi = smerovi;
		this.univerzitet = univerzitet;
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

	public Nastavnik getDekan() {
		return dekan;
	}

	public void setDekan(Nastavnik dekan) {
		this.dekan = dekan;
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
