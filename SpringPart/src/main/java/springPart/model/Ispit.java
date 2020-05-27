package springPart.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ispit extends AbstractModel{
	
	LocalDateTime datumVreme;
	
	@ManyToOne
	Predmet predmet;
	
	@OneToMany
	List<PrijavaIspita> listaPrijavaIspita;

	public Ispit() {
		
	}

	public Ispit(LocalDateTime datumVreme, Predmet predmet, List<PrijavaIspita> listaPrijavaIspita) {
		super();
		this.datumVreme = datumVreme;
		this.predmet = predmet;
		this.listaPrijavaIspita = listaPrijavaIspita;
	}
	
	
	
}
