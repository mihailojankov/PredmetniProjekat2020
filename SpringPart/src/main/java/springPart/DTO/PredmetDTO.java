package springPart.DTO;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class PredmetDTO extends AbstractDTO{
	
	String naziv;
	int espb;
	boolean obavezan;
	int brojPredavanja;
	int brojVezbi;
	String silabus;
	int godinaStudija;
	int semestar;
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
	public String getSilabus() {
		return silabus;
	}
	public void setSilabus(String silabus) {
		this.silabus = silabus;
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
