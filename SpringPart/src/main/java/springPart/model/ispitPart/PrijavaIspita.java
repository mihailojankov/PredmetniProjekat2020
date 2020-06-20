package springPart.model.ispitPart;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import springPart.model.AbstractModel;
import springPart.model.korisnikPart.Student;

@Entity
public class PrijavaIspita extends AbstractModel{
	
	LocalDateTime datumPrijave;
	
	@ManyToOne
	Student student;
	
	@ManyToOne
	Rok rok;
	
	@ManyToOne
	Ispit ispit;
	
	public PrijavaIspita() {
		
	}

	public PrijavaIspita(LocalDateTime datumPrijave, Student student, Rok rok, Ispit ispit) {
		super();
		this.datumPrijave = datumPrijave;
		this.student = student;
		this.rok = rok;
		this.ispit = ispit;
	}

	public LocalDateTime getDatumPrijave() {
		return datumPrijave;
	}

	public void setDatumPrijave(LocalDateTime datumPrijave) {
		this.datumPrijave = datumPrijave;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Rok getRok() {
		return rok;
	}

	public void setRok(Rok rok) {
		this.rok = rok;
	}

	public Ispit getIspit() {
		return ispit;
	}

	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}
	
	
}
