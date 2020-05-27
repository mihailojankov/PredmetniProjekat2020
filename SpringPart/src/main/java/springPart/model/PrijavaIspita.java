package springPart.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	
}
