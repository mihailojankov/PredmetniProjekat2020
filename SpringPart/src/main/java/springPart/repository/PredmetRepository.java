package springPart.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import springPart.model.Predmet;

@Repository
public interface PredmetRepository extends CrudRepository<Predmet, Long>{
	
}
