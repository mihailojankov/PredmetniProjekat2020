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
	
	@Query
	("SELECT n FROM Nastavnik n WHERE n.korisnik.id = :id")
	public Nastavnik nadjiNastavnika(@PathVariable("id") Long id);
	
	@Query
	("SELECT c FROM ClanAdministrativnogOsoblja c WHERE c.korisnik.id = :id")
	public ClanAdministrativnogOsoblja nadjiClanaA(@PathVariable("id") Long id);
	
	@Query
	("SELECT s FROM Student s WHERE s.korisnik.id = :id ")
	public Student nadjiStudenta(@PathVariable("id") Long id);
}
