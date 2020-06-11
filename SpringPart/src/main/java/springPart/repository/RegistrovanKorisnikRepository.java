package springPart.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import springPart.model.AbstractModel;
import springPart.model.korisnikPart.ClanAdministrativnogOsoblja;
import springPart.model.korisnikPart.Nastavnik;
import springPart.model.korisnikPart.RegistrovanKorisnik;
import springPart.model.korisnikPart.Student;

@Repository
public interface RegistrovanKorisnikRepository extends InheritInterface<RegistrovanKorisnik> {
	@Query
	("SELECT k FROM RegistrovanKorisnik k WHERE k.korisnickoIme = :username")
	public RegistrovanKorisnik findByUserName(@PathVariable("username") String username);
	
	@Override
	@Query
	("SELECT k FROM RegistrovanKorisnik k WHERE k.dodeljen = false")
	public Iterable<RegistrovanKorisnik> findAll();
	
	@Query
	("SELECT k FROM RegistrovanKorisnik k WHERE k.email=:email AND k.korisnickoIme=:korisnicko")
	public Optional<RegistrovanKorisnik> proveriPoEmailuIKorisnickomImenu(@PathVariable("email") String email, @PathVariable("korisnicko")String korisnicko);
	
	
}
