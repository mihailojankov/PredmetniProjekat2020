package springPart.model.ispit;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import springPart.model.Predmet;

@Entity
public class Ispit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	LocalDateTime datumVreme;
	
	@ManyToOne
	Predmet predmet;
	
	@OneToMany
	List<PrijavaIspita> listaPrijavaIspita;
	
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDatumVreme() {
		return datumVreme;
	}

	public void setDatumVreme(LocalDateTime datumVreme) {
		this.datumVreme = datumVreme;
	}

	public Predmet getPredmeti() {
		return predmet;
	}

	public void setPredmeti(Predmet predmeti) {
		this.predmet = predmet;
	}


	public Ispit(Long id, LocalDateTime datumVreme, Predmet predmet, List<PrijavaIspita> listaPrijavaIspita) {
		super();
		this.id = id;
		this.datumVreme = datumVreme;
		this.predmet = predmet;
		this.listaPrijavaIspita = listaPrijavaIspita;
	}

	public Ispit() {
		super();
	}
	
	
}
