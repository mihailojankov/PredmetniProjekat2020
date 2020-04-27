package springPart.DTO;


public class NastavnikDTO {
	Long id;
	String biografija;
	String jmbg;
	boolean profesor;
	boolean asistent;
	RegistrovanKorisnikDTO korisnik;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	
	
}
