package springPart.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Univerzitet extends AbstractModel{
	
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

	public Univerzitet(String naziv, LocalDate datumOsnivanja, String drzava, String adresa, String mesto,
			String opisUniverziteta, Nastavnik rektor, List<Fakultet> fakulteti) {
		super();
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.drzava = drzava;
		this.adresa = adresa;
		this.mesto = mesto;
		this.opisUniverziteta = opisUniverziteta;
		this.rektor = rektor;
		this.fakulteti = fakulteti;
	}

	
}
