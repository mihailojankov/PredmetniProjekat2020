package springPart.DTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class StudentDTO extends AbstractDTO{
	
	String jmbg;
	LocalDate datumRodjenja;
	String brojIndeksa;
	String mestoRodjenja;
	String drzavaRodjenja;
	boolean vanredni;
	String godinaUpisa;
	RegistrovanKorisnikDTO korisnik;
	List<PredmetDTO> listaPredmeta;
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	public String getMestoRodjenja() {
		return mestoRodjenja;
	}
	public void setMestoRodjenja(String mestoRodjenja) {
		this.mestoRodjenja = mestoRodjenja;
	}
	public String getDrzavaRodjenja() {
		return drzavaRodjenja;
	}
	public void setDrzavaRodjenja(String drzavaRodjenja) {
		this.drzavaRodjenja = drzavaRodjenja;
	}
	public boolean isVanredni() {
		return vanredni;
	}
	public void setVanredni(boolean vanredni) {
		this.vanredni = vanredni;
	}
	public String getGodinaUpisa() {
		return godinaUpisa;
	}
	public void setGodinaUpisa(String godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}
	public RegistrovanKorisnikDTO getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(RegistrovanKorisnikDTO korisnik) {
		this.korisnik = korisnik;
	}
	public List<PredmetDTO> getListaPredmeta() {
		return listaPredmeta;
	}
	public void setListaPredmeta(List<PredmetDTO> listaPredmeta) {
		this.listaPredmeta = listaPredmeta;
	}
	
	
}
