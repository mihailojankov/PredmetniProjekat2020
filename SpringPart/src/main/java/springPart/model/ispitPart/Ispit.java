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

	public LocalDateTime getDatumVreme() {
		return datumVreme;
	}

	public void setDatumVreme(LocalDateTime datumVreme) {
		this.datumVreme = datumVreme;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public List<PrijavaIspita> getListaPrijavaIspita() {
		return listaPrijavaIspita;
	}

	public void setListaPrijavaIspita(List<PrijavaIspita> listaPrijavaIspita) {
		this.listaPrijavaIspita = listaPrijavaIspita;
	}
	
	
	
}
