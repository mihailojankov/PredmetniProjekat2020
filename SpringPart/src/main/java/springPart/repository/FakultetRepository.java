package springPart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springPart.model.Fakultet;

@Repository
public interface FakultetRepository extends CrudRepository<Fakultet, Long>{

}
