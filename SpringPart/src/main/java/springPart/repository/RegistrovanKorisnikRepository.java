package springPart.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import springPart.model.AbstractModel;
import springPart.model.ClanAdministrativnogOsoblja;
import springPart.model.Nastavnik;
import springPart.model.RegistrovanKorisnik;
import springPart.model.Student;

@Repository
public interface RegistrovanKorisnikRepository extends InheritInterface<RegistrovanKorisnik> {
	@Query
	("SELECT k FROM RegistrovanKorisnik k WHERE k.korisnickoIme = :username")
	public RegistrovanKorisnik findByUserName(@PathVariable("username") String username);
	
	@Override
	@Query
	("SELECT k FROM RegistrovanKorisnik k WHERE k.dodeljen = false")
	public Iterable<RegistrovanKorisnik> findAll();
	
	
}
