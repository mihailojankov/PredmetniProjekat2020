package springPart.model.korisnik;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import springPart.model.Predmet;
import springPart.model.ispit.IshodIspita;
import springPart.model.ispit.PrijavaIspita;

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
	
	@OneToMany(mappedBy = "student")
	List<PrijavaIspita> prijaveIspita;
	
	@OneToMany(mappedBy = "student")
	List<IshodIspita> istorijaIspita;
	
	
	
	public Student() {
		
	}



	public Student(Long id, String jmbg, Date datumRodjenja, String brojIndeksa, String mestoRodjenja,
			String drzavaRodjenja, boolean vanredni, Date godinaUpisa, RegistrovanKorisnik korisnik,
			List<Predmet> listaPredmeta, List<PrijavaIspita> prijaveIspita, List<IshodIspita> istorijaIspita) {
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
		this.listaPredmeta = listaPredmeta;
		this.prijaveIspita = prijaveIspita;
		this.istorijaIspita = istorijaIspita;
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



	public List<PrijavaIspita> getPrijaveIspita() {
		return prijaveIspita;
	}



	public void setPrijaveIspita(List<PrijavaIspita> prijaveIspita) {
		this.prijaveIspita = prijaveIspita;
	}



	public List<IshodIspita> getIstorijaIspita() {
		return istorijaIspita;
	}



	public void setIstorijaIspita(List<IshodIspita> istorijaIspita) {
		this.istorijaIspita = istorijaIspita;
	}
	
	
	
}
