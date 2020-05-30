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
		ArrayList<GrantedAuthority> roles = new ArrayList<>();
		
		GrantedAuthority studentA = new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				return "STUDENT";
			}
		};
		
		GrantedAuthority nastavnikA = new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				return "NASTAVNIK";
			}
		};
		
		GrantedAuthority clanA = new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				return "CLAN";
			}
		};

		
		
		Student student = repository.nadjiStudenta(korisnik.getId());
		
		if(student != null) {
			
			roles.add(studentA);
			
			return new User(korisnik.getKorisnickoIme(), korisnik.getLozinka(), roles);
		}
		else {
			Nastavnik nastavnik = repository.nadjiNastavnika(korisnik.getId());
			
			if(nastavnik != null) {
				roles.add(nastavnikA);
				
				return new User(korisnik.getKorisnickoIme(), korisnik.getLozinka(), roles);
			}
			else {
				ClanAdministrativnogOsoblja clan = repository.nadjiClanaA(korisnik.getId());
				
				if(clan != null) {
					roles.add(clanA);
					
					return new User(korisnik.getKorisnickoIme(), korisnik.getLozinka(), roles);
				}
				
			}
		}
		
		
		
		return new User(korisnik.getKorisnickoIme(), korisnik.getLozinka(), new ArrayList<>());
	}
	
	

}
