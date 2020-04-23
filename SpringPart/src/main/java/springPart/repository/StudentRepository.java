package springPart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springPart.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>  {

}
