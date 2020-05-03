package springPart.model.ispit;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Rok {
	@Id
	Long id;
	
	String naziv;
	LocalDate pocetak;
	LocalDate kraj;
	boolean vanredan;
	
	@OneToMany(mappedBy = "rok")
	List<PrijavaIspita> listaPrijavaIspita;
	
	
	public List<PrijavaIspita> getListaIspita() {
		return listaPrijavaIspita;
	}
	public void setListaIspita(List<PrijavaIspita> listaIspita) {
		this.listaPrijavaIspita = listaIspita;
	}
	
	public Rok(Long id, String naziv, LocalDate pocetak, LocalDate kraj, boolean vanredan, List<PrijavaIspita> listaIspita) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.vanredan = vanredan;
		this.listaPrijavaIspita = listaIspita;
	}
	public Rok() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	
	
}
