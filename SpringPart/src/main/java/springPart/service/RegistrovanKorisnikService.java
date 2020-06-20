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
import springPart.model.korisnikPart.ClanAdministrativnogOsoblja;
import springPart.model.korisnikPart.Nastavnik;
import springPart.model.korisnikPart.RegistrovanKorisnik;
import springPart.model.korisnikPart.Student;
import springPart.model.security.Authority;
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
	
	public boolean proveraPostojeceg(String email, String korisnicko) {
		if(repository.proveriPoEmailuIKorisnickomImenu(email, korisnicko) == null) {
			return false;
		}
		return true;
	}

	public Object findUser(String username){

		RegistrovanKorisnik korisnik = repository.findByUserName(username);

		if(korisnik != null){
			if(korisnik.getAuthority().getAuthority().equals("NASTAVNIK")){
				Nastavnik nastavnik = repository.findNastavnik(korisnik.getId());
				return nastavnik;
			}
			if(korisnik.getAuthority().getAuthority().equals("CLAN")){
				ClanAdministrativnogOsoblja clanAdministrativnogOsoblja = repository.findClanAdministrativnogOsoblja(korisnik.getId());
				return clanAdministrativnogOsoblja;
			}
			if(korisnik.getAuthority().getAuthority().equals("STUDENT")){
				Student student = repository.findStudent(korisnik.getId());
				return student;
			}
		}
		return korisnik;
	}
	
	

}
