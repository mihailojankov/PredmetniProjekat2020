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

	@Query("SELECT k FROM Nastavnik k WHERE k.korisnik.id=:id")
	public Nastavnik findNastavnik(@PathVariable("id") Long id);

	@Query("SELECT k FROM Student k WHERE k.korisnik.id=:id")
	public Student findStudent(@PathVariable("id") Long id);

	@Query("SELECT k FROM ClanAdministrativnogOsoblja k WHERE k.korisnik.id=:id")
	public ClanAdministrativnogOsoblja findClanAdministrativnogOsoblja(@PathVariable("id") Long id);
	
	@Override
	@Query
	("SELECT k FROM RegistrovanKorisnik k WHERE k.dodeljen = false")
	public Iterable<RegistrovanKorisnik> findAll();
	
	@Query
	("SELECT k FROM RegistrovanKorisnik k WHERE k.email=:email OR k.korisnickoIme=:korisnicko")
	public Optional<RegistrovanKorisnik> proveriPoEmailuIKorisnickomImenu(@PathVariable("email") String email, @PathVariable("korisnicko")String korisnicko);
	
	
}
