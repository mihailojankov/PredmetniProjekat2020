package springPart.versionControl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ishod")
@XmlAccessorType(XmlAccessType.FIELD)
public class IshodVersionControl {
    String ime;
    String prezime;
    String brojIndeksa;
    float prviKolokvijum;
    float drugiKolokvijum;
    float zavrsniIspit;
    boolean polozen;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public float getPrviKolokvijum() {
        return prviKolokvijum;
    }

    public void setPrviKolokvijum(float prviKolokvijum) {
        this.prviKolokvijum = prviKolokvijum;
    }

    public float getDrugiKolokvijum() {
        return drugiKolokvijum;
    }

    public void setDrugiKolokvijum(float drugiKolokvijum) {
        this.drugiKolokvijum = drugiKolokvijum;
    }

    public float getZavrsniIspit() {
        return zavrsniIspit;
    }

    public void setZavrsniIspit(float zavrsniIspit) {
        this.zavrsniIspit = zavrsniIspit;
    }

    public boolean isPolozen() {
        return polozen;
    }

    public void setPolozen(boolean polozen) {
        this.polozen = polozen;
    }
}
