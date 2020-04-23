package springPart.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(unique = true)
	String jmbg;
	Date datumRodjenja;
	String brojIndeksa;
	String mestoRodjenja;
	String drzavaRodjenja;
	boolean vanredni;
	Date godinaUpisa;
	
	@OneToOne
	@JoinColumn(name = "korisnik_id")
	RegistrovanKorisnik korisnik;
	
	@ManyToMany
	@JoinTable(name = "studentiNaPredmetu", joinColumns = @JoinColumn(name="student_id"), inverseJoinColumns = @JoinColumn(name="predmet_id"))
	List<Predmet> listaPredmeta;
	
	
	public Student() {
		
	}
	

	public Student(Long id, String jmbg, Date datumRodjenja, String brojIndeksa, String mestoRodjenja,
			String drzavaRodjenja, boolean vanredni, Date godinaUpisa, RegistrovanKorisnik korisnik) {
		super();
		this.id = id;
		this.jmbg = jmbg;
		this.datumRodjenja = datumRodjenja;
		this.brojIndeksa = brojIndeksa;
		this.mestoRodjenja = mestoRodjenja;
		this.drzavaRodjenja = drzavaRodjenja;
		this.vanredni = vanredni;
		this.godinaUpisa = godinaUpisa;
		this.korisnik = korisnik;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public String getMestoRodjenja() {
		return mestoRodjenja;
	}

	public void setMestoRodjenja(String mestoRodjenja) {
		this.mestoRodjenja = mestoRodjenja;
	}

	public String getDrzavaRodjenja() {
		return drzavaRodjenja;
	}

	public void setDrzavaRodjenja(String drzavaRodjenja) {
		this.drzavaRodjenja = drzavaRodjenja;
	}

	public boolean isVanredni() {
		return vanredni;
	}

	public void setVanredni(boolean vanredni) {
		this.vanredni = vanredni;
	}

	public Date getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(Date godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public RegistrovanKorisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(RegistrovanKorisnik korisnik) {
		this.korisnik = korisnik;
	}


	public List<Predmet> getListaPredmeta() {
		return listaPredmeta;
	}


	public void setListaPredmeta(List<Predmet> listaPredmeta) {
		this.listaPredmeta = listaPredmeta;
	}

	
	
	
	
	
}
