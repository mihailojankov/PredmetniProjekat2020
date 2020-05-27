package springPart.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Predmet extends AbstractModel{
	
	String naziv;
	int espb;
	boolean obavezan;
	int brojPredavanja;
	int brojVezbi;
	String silabus;
	int godinaStudija;
	int semestar;
	
	@ManyToMany
	@JoinTable(name = "nastavniciNaPredmetu", joinColumns = @JoinColumn(name="nastavnik_id"), inverseJoinColumns = @JoinColumn(name="predmet_id"))
	List<Nastavnik> listaNastavnika;
	
	@ManyToMany(mappedBy = "listaPredmeta")
	List<Student> listaStudenata;
	
	@OneToMany(mappedBy = "predmet")
	List<Ispit> ispitiIzPredmeta;
	
	@ManyToMany
	@JoinTable(name = "predmetiNaSmeru", joinColumns = @JoinColumn(name="predmet_id"), inverseJoinColumns = @JoinColumn(name="smer_fakulteta_id"))
	List<SmerFakulteta> listaSmerovaFakulteta;
	
	@OneToMany(mappedBy = "predmet")
	List<IshodIspita> istorijaIspita;

	public Predmet() {
		
	}

	public Predmet(String naziv, int espb, boolean obavezan, int brojPredavanja, int brojVezbi, String silabus,
			int godinaStudija, int semestar, List<Nastavnik> listaNastavnika, List<Student> listaStudenata,
			List<Ispit> ispitiIzPredmeta, List<SmerFakulteta> listaSmerovaFakulteta, List<IshodIspita> istorijaIspita) {
		super();
		this.naziv = naziv;
		this.espb = espb;
		this.obavezan = obavezan;
		this.brojPredavanja = brojPredavanja;
		this.brojVezbi = brojVezbi;
		this.silabus = silabus;
		this.godinaStudija = godinaStudija;
		this.semestar = semestar;
		this.listaNastavnika = listaNastavnika;
		this.listaStudenata = listaStudenata;
		this.ispitiIzPredmeta = ispitiIzPredmeta;
		this.listaSmerovaFakulteta = listaSmerovaFakulteta;
		this.istorijaIspita = istorijaIspita;
	}
	

	
	
	
	
	
	
}
