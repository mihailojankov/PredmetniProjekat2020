package springPart.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import springPart.model.ispit.IshodIspita;
import springPart.model.ispit.Ispit;
import springPart.model.korisnik.Nastavnik;
import springPart.model.korisnik.Student;

@Entity
public class Predmet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String naziv;
	int espb;
	boolean obavezan;
	int brojPredavanja;
	int brojVezbi;
	String silabus;
	//int drugiObliciNastave
	//int istrazivackiRad
	//int ostaliCasovi
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

	public Predmet(Long id, String naziv, int espb, boolean obavezan, int brojPredavanja, int brojVezbi, String silabus,
			int godinaStudija, int semestar, List<Nastavnik> listaNastavnika, List<Student> listaStudenata,
			List<Ispit> ispitiIzPredmeta, List<SmerFakulteta> listaSmerovaFakulteta, List<IshodIspita> istorijaIspita) {
		super();
		this.id = id;
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

	public Predmet() {
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

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public boolean isObavezan() {
		return obavezan;
	}

	public void setObavezan(boolean obavezan) {
		this.obavezan = obavezan;
	}

	public int getBrojPredavanja() {
		return brojPredavanja;
	}

	public void setBrojPredavanja(int brojPredavanja) {
		this.brojPredavanja = brojPredavanja;
	}

	public int getBrojVezbi() {
		return brojVezbi;
	}

	public void setBrojVezbi(int brojVezbi) {
		this.brojVezbi = brojVezbi;
	}

	public String getSilabus() {
		return silabus;
	}

	public void setSilabus(String silabus) {
		this.silabus = silabus;
	}

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public int getSemestar() {
		return semestar;
	}

	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}

	public List<Nastavnik> getListaNastavnika() {
		return listaNastavnika;
	}

	public void setListaNastavnika(List<Nastavnik> listaNastavnika) {
		this.listaNastavnika = listaNastavnika;
	}

	public List<Student> getListaStudenata() {
		return listaStudenata;
	}

	public void setListaStudenata(List<Student> listaStudenata) {
		this.listaStudenata = listaStudenata;
	}

	public List<Ispit> getIspitiIzPredmeta() {
		return ispitiIzPredmeta;
	}

	public void setIspitiIzPredmeta(List<Ispit> ispitiIzPredmeta) {
		this.ispitiIzPredmeta = ispitiIzPredmeta;
	}

	public List<SmerFakulteta> getListaSmerovaFakulteta() {
		return listaSmerovaFakulteta;
	}

	public void setListaSmerovaFakulteta(List<SmerFakulteta> listaSmerovaFakulteta) {
		this.listaSmerovaFakulteta = listaSmerovaFakulteta;
	}

	public List<IshodIspita> getIstorijaIspita() {
		return istorijaIspita;
	}

	public void setIstorijaIspita(List<IshodIspita> istorijaIspita) {
		this.istorijaIspita = istorijaIspita;
	}
	
	
	
	
	
}
