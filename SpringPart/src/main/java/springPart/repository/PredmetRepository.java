package springPart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springPart.model.Predmet;

@Repository
public interface PredmetRepository extends CrudRepository<Predmet, Long>{

}
