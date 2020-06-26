package springPart.versionControl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XMLConverter{

    public static void zapisiUXML(IshodiVersionControl ishodi, String predmet) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(IshodiVersionControl.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(ishodi, System.out);

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date(System.currentTimeMillis());

        String path = "src/VersionControlDirectory/" + predmet + "-" + formatter.format(date) + ".xml";
        jaxbMarshaller.marshal(ishodi, new File(path));
    }
}
