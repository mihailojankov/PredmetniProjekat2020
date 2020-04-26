package springPart.DTO;

import java.util.Date;
import java.util.List;

public class UniverzitetDTO {
	Long id;
	String naziv;
	Date datumOsnivanja;
	String drzava;
	String adresa;
	String mesto;
	String opisUniverziteta;
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
	
	
}
