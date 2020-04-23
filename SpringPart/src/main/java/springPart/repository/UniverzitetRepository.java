package springPart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springPart.model.Univerzitet;

@Repository
public interface UniverzitetRepository extends CrudRepository<Univerzitet, Long> {

}
