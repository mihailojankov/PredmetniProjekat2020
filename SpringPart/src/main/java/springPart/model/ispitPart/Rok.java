package springPart.model.ispitPart;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import springPart.model.AbstractModel;


@Getter
@Setter
@Entity
public class Rok extends AbstractModel{
	
	String naziv;
	LocalDate pocetak;
	LocalDate kraj;
	boolean vanredan;
	
	@OneToMany(mappedBy = "rok")
	List<PrijavaIspita> listaPrijavaIspita;
	
	public Rok() {
		
	}

	public Rok(String naziv, LocalDate pocetak, LocalDate kraj, boolean vanredan,
			List<PrijavaIspita> listaPrijavaIspita) {
		super();
		this.naziv = naziv;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.vanredan = vanredan;
		this.listaPrijavaIspita = listaPrijavaIspita;
	}
}
