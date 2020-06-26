package springPart.service;
import org.springframework.stereotype.Service;

import springPart.model.ispitPart.PrijavaIspita;
import springPart.model.korisnikPart.Student;
import springPart.repository.StudentRepository;

@Service
public class StudentService extends AbstractService<Student, StudentRepository>{

	public StudentService(StudentRepository repository) {
		super(repository);
	}
	
	public Iterable<Student> pronadjiStudentaPoPredmetu(Long id) {
		return repository.pronadjiStudentePoPredmetu(id);
	}
	


}
