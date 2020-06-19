package springPart.model.korisnikPart;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import springPart.model.AbstractModel;
import springPart.model.ispitPart.IshodIspita;
import springPart.model.ispitPart.PrijavaIspita;
import springPart.model.predmetPart.Predmet;

@Entity
public class Student extends AbstractModel{
	
	@Column(unique = true)
	String jmbg;
	LocalDate datumRodjenja;
	String brojIndeksa;
	String mestoRodjenja;
	String drzavaRodjenja;
	boolean vanredni;
	String godinaUpisa;
	
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

	public Student(String jmbg, LocalDate datumRodjenja, String brojIndeksa, String mestoRodjenja, String drzavaRodjenja,
			boolean vanredni, String godinaUpisa, RegistrovanKorisnik korisnik, List<Predmet> listaPredmeta,
			List<PrijavaIspita> prijaveIspita, List<IshodIspita> istorijaIspita) {
		super();
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

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
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

	public String getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(String godinaUpisa) {
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
