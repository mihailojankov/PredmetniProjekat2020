package springPart.model.ispitPart;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import springPart.model.AbstractModel;
import springPart.model.predmetPart.Predmet;

@Getter
@Setter
@Entity
public class Ispit extends AbstractModel{
	
	LocalDateTime datumVreme;
	
	@ManyToOne
	Predmet predmet;
	
	@OneToMany(mappedBy = "ispit")
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
