package springPart.DTO;

import springPart.model.ispitPart.PrijavaIspita;

import java.time.LocalDate;
import java.util.List;

public class RokDTO extends AbstractDTO{

	String naziv;
	LocalDate pocetak;
	LocalDate kraj;
	boolean vanredan;
	List<PrijavaIspita> prijavaIspitaList;

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

	public List<PrijavaIspita> getPrijavaIspitaList() {
		return prijavaIspitaList;
	}

	public void setPrijavaIspitaList(List<PrijavaIspita> prijavaIspitaList) {
		this.prijavaIspitaList = prijavaIspitaList;
	}
}
