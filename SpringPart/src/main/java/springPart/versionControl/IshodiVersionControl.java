package springPart.versionControl;


import springPart.model.ispitPart.IshodIspita;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "ishodi")
@XmlAccessorType(XmlAccessType.FIELD)
public class IshodiVersionControl {

    @XmlElement(name = "ishod")
    List<IshodVersionControl> listaIshoda;

    public List<IshodVersionControl> getListaIshoda() {
        return listaIshoda;
    }

    public void setListaIshoda(List<IshodVersionControl> listaIshoda) {
        this.listaIshoda = listaIshoda;
    }

    public static List<IshodVersionControl> konvertuj(List<IshodIspita> listaIshodi){

        List<IshodVersionControl> popunjenaLista = new ArrayList<>();

        for(IshodIspita x: listaIshodi){
            IshodVersionControl ishod = new IshodVersionControl();
            ishod.setBrojIndeksa(x.getStudent().getBrojIndeksa());
            ishod.setIme(x.getStudent().getKorisnik().getIme());
            ishod.setPrezime(x.getStudent().getKorisnik().getPrezime());
            ishod.setPrviKolokvijum(x.getPrviKolokvijumBodovi());
            ishod.setDrugiKolokvijum(x.getPrviKolokvijumBodovi());
            ishod.setZavrsniIspit(x.getZavrsniIspitBodovi());
            ishod.setPolozen(x.isPolozen());

            popunjenaLista.add(ishod);
        }

        return popunjenaLista;
    }
}
