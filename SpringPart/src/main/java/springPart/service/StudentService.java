package springPart.service;
import org.springframework.stereotype.Service;

import springPart.model.korisnikPart.Student;
import springPart.repository.StudentRepository;

@Service
public class StudentService extends AbstractService<Student, StudentRepository>{

	public StudentService(StudentRepository repository) {
		super(repository);
	}
	


}
