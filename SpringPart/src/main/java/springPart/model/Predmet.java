package springPart.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

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
	//int drugiObliciNastave
	//int istrazivackiRad
	//int ostaliCasovi
	int godinaStudija;
	int semestar;
	
	@OneToOne
	@JoinColumn(name = "profesor_id")
	Nastavnik profesor;
	
	@OneToOne
	@JoinColumn(name = "asistent_id")
	Nastavnik asistent;
	
	@ManyToMany(mappedBy = "listaPredmeta")
	List<Student> listaStudenata;
	
	@ManyToMany
	@JoinTable(name = "predmetiNaSmeru", joinColumns = @JoinColumn(name="predmet_id"), inverseJoinColumns = @JoinColumn(name="smer_fakulteta_id"))
	List<SmerFakulteta> listaSmerovaFakulteta;
	
	
	
	public Predmet() {
		
	}
	
	public Predmet(Long id, String naziv, int espb, boolean obavezan, int brojPredavanja, int brojVezbi,
			int godinaStudija, int semestar, Nastavnik profesor, Nastavnik asistent, List<Student> listaStudenata) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
		this.obavezan = obavezan;
		this.brojPredavanja = brojPredavanja;
		this.brojVezbi = brojVezbi;
		this.godinaStudija = godinaStudija;
		this.semestar = semestar;
		this.profesor = profesor;
		this.asistent = asistent;
		this.listaStudenata = listaStudenata;
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


	public Nastavnik getProfesor() {
		return profesor;
	}


	public void setProfesor(Nastavnik profesor) {
		this.profesor = profesor;
	}


	public Nastavnik getAsistent() {
		return asistent;
	}


	public void setAsistent(Nastavnik asistent) {
		this.asistent = asistent;
	}


	public List<Student> getListaStudenata() {
		return listaStudenata;
	}


	public void setListaStudenata(List<Student> listaStudenata) {
		this.listaStudenata = listaStudenata;
	}
	
	
}
