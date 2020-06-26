package springPart.DTO;

import java.util.List;


public class NastavnikDTO extends AbstractDTO{
	String biografija;
	String jmbg;
	boolean profesor;
	boolean asistent;
	RegistrovanKorisnikDTO korisnik;
	List<PredmetDTO> predmeti;
	public String getBiografija() {
		return biografija;
	}
	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public boolean isProfesor() {
		return profesor;
	}
	public void setProfesor(boolean profesor) {
		this.profesor = profesor;
	}
	public boolean isAsistent() {
		return asistent;
	}
	public void setAsistent(boolean asistent) {
		this.asistent = asistent;
	}
	public RegistrovanKorisnikDTO getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(RegistrovanKorisnikDTO korisnik) {
		this.korisnik = korisnik;
	}
	public List<PredmetDTO> getPredmeti() {
		return predmeti;
	}
	public void setPredmeti(List<PredmetDTO> predmeti) {
		this.predmeti = predmeti;
	}
	
	
}
