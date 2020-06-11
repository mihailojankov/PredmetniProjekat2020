package springPart.model.predmetPart;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import springPart.model.AbstractModel;
import springPart.model.korisnikPart.Nastavnik;

@Getter
@Setter
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
	
	
	
	
	
	
}
