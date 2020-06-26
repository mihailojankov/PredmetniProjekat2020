package springPart.model.ispitPart;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import springPart.model.AbstractModel;

@Entity
public class Rok extends AbstractModel{
	
	String naziv;
	LocalDate pocetak;
	LocalDate kraj;
	boolean vanredan;
	
	@OneToMany(mappedBy = "rok")
	List<PrijavaIspita> listaPrijavaIspita;
	
	@OneToMany(mappedBy = "rok")
	List<Ispit> listaIspita;
	
	public Rok() {
		
	}

	public Rok(String naziv, LocalDate pocetak, LocalDate kraj, boolean vanredan,
			List<PrijavaIspita> listaPrijavaIspita, List<Ispit> listaIspita) {
		super();
		this.naziv = naziv;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.vanredan = vanredan;
		this.listaPrijavaIspita = listaPrijavaIspita;
		this.listaIspita = listaIspita;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public LocalDate getPocetak() {
		return pocetak;
	}

	public void setPocetak(LocalDate pocetak) {
		this.pocetak = pocetak;
	}

	public LocalDate getKraj() {
		return kraj;
	}

	public void setKraj(LocalDate kraj) {
		this.kraj = kraj;
	}

	public boolean isVanredan() {
		return vanredan;
	}

	public void setVanredan(boolean vanredan) {
		this.vanredan = vanredan;
	}

	public List<PrijavaIspita> getListaPrijavaIspita() {
		return listaPrijavaIspita;
	}

	public void setListaPrijavaIspita(List<PrijavaIspita> listaPrijavaIspita) {
		this.listaPrijavaIspita = listaPrijavaIspita;
	}

	public List<Ispit> getListaIspita() {
		return listaIspita;
	}

	public void setListaIspita(List<Ispit> listaIspita) {
		this.listaIspita = listaIspita;
	}

	

}
