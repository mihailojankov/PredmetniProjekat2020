package springPart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springPart.model.Student;
import springPart.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
    StudentRepository repo;


    public Iterable<Student> dobaviSve(){
        return repo.findAll();
    }

    public Student dobaviPoId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Student obj) {
        repo.save(obj);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
