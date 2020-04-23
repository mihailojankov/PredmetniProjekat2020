package springPart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springPart.model.RegistrovanKorisnik;

@Repository
public interface RegistrovanKorisnikRepository extends CrudRepository<RegistrovanKorisnik, Long> {

}
