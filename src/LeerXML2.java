import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class LeerXML2 {
    public static void main(String[] args) throws SAXException, IOException {
        XMLReader procXML = XMLReaderFactory.createXMLReader();
        GestorContenidoSAX gestor = new GestorContenidoSAX();
        procXML.setContentHandler((ContentHandler) gestor);
        InputSource fileXML = new InputSource("ejercicio1.xml");
        procXML.parse(fileXML);
    }
}
