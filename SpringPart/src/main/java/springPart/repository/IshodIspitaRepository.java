package springPart.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.web.bind.annotation.PathVariable;
import springPart.model.ispitPart.IshodIspita;

@Repository
public interface IshodIspitaRepository extends InheritInterface<IshodIspita>{
    @Query("SELECT i FROM IshodIspita i WHERE i.student.id =:studentId AND i.predmet.id =:predmetId")
    public IshodIspita pronadjiIshod(@PathVariable("studentId")Long studentId, @PathVariable("predmetId")Long predmetId);
}
