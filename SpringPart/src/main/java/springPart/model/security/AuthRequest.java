package springPart.model.security;

public class AuthRequest {
	private String korisnickoIme;
	private String lozinka;
	
	public AuthRequest() {
		
	}
	
	public AuthRequest(String email, String lozinka) {
		this.korisnickoIme = email;
		this.lozinka = lozinka;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
}
