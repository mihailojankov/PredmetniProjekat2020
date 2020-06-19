package springPart.DTO;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import springPart.model.korisnikPart.Student;

public class PrijavaIspitaDTO extends AbstractDTO{
	LocalDateTime datumPrijave;
	StudentDTO student;
	IspitDTO ispit;
	public LocalDateTime getDatumPrijave() {
		return datumPrijave;
	}
	public void setDatumPrijave(LocalDateTime datumPrijave) {
		this.datumPrijave = datumPrijave;
	}
	public StudentDTO getStudent() {
		return student;
	}
	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	public IspitDTO getIspit() {
		return ispit;
	}
	public void setIspit(IspitDTO ispit) {
		this.ispit = ispit;
	}
	
	
}
