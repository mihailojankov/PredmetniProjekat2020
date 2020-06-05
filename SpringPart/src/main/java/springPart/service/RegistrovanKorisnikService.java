package springPart.service;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springPart.model.AbstractModel;
import springPart.model.Authority;
import springPart.model.ClanAdministrativnogOsoblja;
import springPart.model.Nastavnik;
import springPart.model.RegistrovanKorisnik;
import springPart.model.Student;
import springPart.repository.RegistrovanKorisnikRepository;

@Service
public class RegistrovanKorisnikService extends AbstractService<RegistrovanKorisnik, RegistrovanKorisnikRepository> implements UserDetailsService{

	public RegistrovanKorisnikService(RegistrovanKorisnikRepository repository) {
		super(repository);
	}
	
	
	//Login
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		RegistrovanKorisnik korisnik = repository.findByUserName(username);
		ArrayList<Authority> roles = new ArrayList<>();
	
		if(korisnik.getAuthority() != null) {
			roles.add(korisnik.getAuthority());
		}
		
		return new User(korisnik.getKorisnickoIme(), korisnik.getLozinka(), roles);
	}
	
	

}
