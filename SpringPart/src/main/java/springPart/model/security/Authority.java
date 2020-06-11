package springPart.model.security;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;
import springPart.model.AbstractModel;
import springPart.model.korisnikPart.RegistrovanKorisnik;

@Getter
@Setter
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
	
	
	
}
