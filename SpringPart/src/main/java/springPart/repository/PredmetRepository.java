package springPart.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import springPart.model.predmetPart.Predmet;

@Repository
public interface PredmetRepository extends InheritInterface<Predmet>{
	
	@Query("SELECT p FROM Predmet p JOIN p.listaNastavnika n WHERE n.id = :id")
	public Iterable<Predmet> pronadjiPoProfesoru(@PathVariable ("id") Long id);
	
	
	
}
