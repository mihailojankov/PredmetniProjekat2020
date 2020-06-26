package springPart.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import springPart.model.korisnikPart.Student;

@Repository
public interface StudentRepository extends InheritInterface<Student>{
	
	@Query("SELECT s FROM Student s JOIN s.listaPredmeta p WHERE p.id = :id")
	public Iterable<Student> pronadjiStudentePoPredmetu(@PathVariable ("id") Long id);

}
