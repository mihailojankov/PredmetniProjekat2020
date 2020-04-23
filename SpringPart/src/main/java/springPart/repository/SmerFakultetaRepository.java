package springPart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springPart.model.SmerFakulteta;

@Repository
public interface SmerFakultetaRepository extends CrudRepository<SmerFakulteta, Long> {

}
