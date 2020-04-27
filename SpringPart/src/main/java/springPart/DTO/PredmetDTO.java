package springPart.DTO;

import java.util.List;
public class PredmetDTO {
	
	Long id;
	String naziv;
	int espb;
	boolean obavezan;
	int brojPredavanja;
	int brojVezbi;
	//int drugiObliciNastave
	//int istrazivackiRad
	//int ostaliCasovi
	int godinaStudija;
	int semestar;
	
	
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
	public int getEspb() {
		return espb;
	}
	public void setEspb(int espb) {
		this.espb = espb;
	}
	public boolean isObavezan() {
		return obavezan;
	}
	public void setObavezan(boolean obavezan) {
		this.obavezan = obavezan;
	}
	public int getBrojPredavanja() {
		return brojPredavanja;
	}
	public void setBrojPredavanja(int brojPredavanja) {
		this.brojPredavanja = brojPredavanja;
	}
	public int getBrojVezbi() {
		return brojVezbi;
	}
	public void setBrojVezbi(int brojVezbi) {
		this.brojVezbi = brojVezbi;
	}
	public int getGodinaStudija() {
		return godinaStudija;
	}
	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	public int getSemestar() {
		return semestar;
	}
	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}
	
	
}
