package springPart.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import springPart.model.ispitPart.PrijavaIspita;

@Repository
public interface PrijavaIspitaRepository extends InheritInterface<PrijavaIspita>{
	
	
	@Query("SELECT pi from PrijavaIspita pi WHERE pi.student.id = :id ")
	public Iterable<PrijavaIspita>nadjiPrijavePoIdStudenta(@PathVariable("id") Long id);
	
	

}
