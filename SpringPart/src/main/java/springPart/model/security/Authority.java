package springPart.model.security;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import springPart.model.AbstractModel;
import springPart.model.korisnikPart.RegistrovanKorisnik;

@Entity
public class Authority extends AbstractModel implements GrantedAuthority{
	
	String authority;
	
	@OneToMany(mappedBy = "authority")
	List<RegistrovanKorisnik> korisnici;


	public Authority() {
		super();
	}


	public Authority(String authority, List<RegistrovanKorisnik> korisnici) {
		super();
		this.authority = authority;
		this.korisnici = korisnici;
	}


	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public List<RegistrovanKorisnik> getKorisnici() {
		return korisnici;
	}


	public void setKorisnici(List<RegistrovanKorisnik> korisnici) {
		this.korisnici = korisnici;
	}
	
	
}
