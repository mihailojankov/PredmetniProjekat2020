package springPart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import springPart.DTO.StudentDTO;
import springPart.model.Student;
import springPart.service.StudentService;

@Controller
@CrossOrigin
@RequestMapping(path = "/student")
public class StudentController extends AbstractController<Student, StudentDTO, StudentService> {

	public StudentController(StudentService service) {
		super(service, StudentDTO.class);
		
	}

}
