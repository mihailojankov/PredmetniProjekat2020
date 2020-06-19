package springPart.DTO;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class FakultetDTO extends AbstractDTO{
	String naziv;
	String adresa;
	String mesto;
	String opis;
	UniverzitetDTO univerzitet;
	List<SmerFakultetaDTO> smerovi;
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
	public UniverzitetDTO getUniverzitet() {
		return univerzitet;
	}
	public void setUniverzitet(UniverzitetDTO univerzitet) {
		this.univerzitet = univerzitet;
	}
	public List<SmerFakultetaDTO> getSmerovi() {
		return smerovi;
	}
	public void setSmerovi(List<SmerFakultetaDTO> smerovi) {
		this.smerovi = smerovi;
	}
	
	
}
