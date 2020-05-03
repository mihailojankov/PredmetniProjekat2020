package springPart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springPart.model.korisnik.Nastavnik;

@Repository
public interface NastavnikRepository extends CrudRepository<Nastavnik, Long>{

}
