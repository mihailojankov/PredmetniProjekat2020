package springPart.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springPart.model.SmerFakulteta;

@Repository
public interface SmerFakultetaRepository extends CrudRepository<SmerFakulteta, Long> {
	@Query("SELECT x FROM SmerFakulteta as x WHERE x.fakultet.id = :fakultetid")
	public Iterable<SmerFakulteta> pronadjiSmeroveFakulteta(@Param("fakultetid") Long id);
}
