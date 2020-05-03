package springPart.model.ispit;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import springPart.model.korisnik.Student;

@Entity
public class PrijavaIspita {
	@Id
	Long id;
	
	LocalDateTime datumPrijave;
	
	@ManyToOne
	Student student;
	
	@ManyToOne
	Rok rok;
	
	@ManyToOne
	Ispit ispit;
	
	
}
