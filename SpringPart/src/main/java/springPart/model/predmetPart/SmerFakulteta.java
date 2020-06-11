package springPart.model.predmetPart;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import springPart.model.AbstractModel;

@Getter
@Setter
@Entity
public class SmerFakulteta extends AbstractModel{
	
	String naziv;
	String opis;
	
	@ManyToMany(mappedBy = "listaSmerovaFakulteta")
	List<Predmet> predmeti;
	
	@ManyToOne
	Fakultet fakultet;
	
	
	public SmerFakulteta() {
		
	}

	public SmerFakulteta(String naziv, String opis, List<Predmet> predmeti, Fakultet fakultet) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.predmeti = predmeti;
		this.fakultet = fakultet;
	}

}
