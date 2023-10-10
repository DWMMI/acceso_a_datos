import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class EscribirXML {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "PersonasSeries", null);
        document.setXmlVersion("1.0");

        String personas[] = new String[6];
        personas[0] = "Quique";
        personas[1] = "Fer";
        personas[2] = "Dani";
        personas[3] = "Edu";
        personas[4] = "Dichao";
        personas[5] = "Ángel";

        String series[] = new String[6];
        series[0] = "bob esponja";
        series[1] = "doraemon";
        series[2] = "mikey mouse";
        series[3] = "barbi";
        series[4] = "ataque de los titanes";
        series[5] = "sense8";

        for (int i = 0; i < series.length; i++) {
            Element elemento = document.createElement("persona");
            document.getDocumentElement().appendChild(elemento);

            Element elemFinal = document.createElement("nombre");
            Text text = document.createTextNode(personas[i]);
            elemento.appendChild(elemFinal);
            elemFinal.appendChild(text);

            Element elemFinal2 = document.createElement("Serie_Favorita");
            Text text2 = document.createTextNode(series[i]);
            elemento.appendChild(elemFinal2);
            elemFinal2.appendChild(text2);
        }


        //una vez hemos generado la estructura, crear la fuente XML a partir del documento
        Source source = new DOMSource(document);
        //crear el resultado en el fichero xml
        Result result = new StreamResult(new File("ejercicio1.xml"));
        //obtener un TransformerFactory
        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        //le damos formato y realizamos la transformación del documento fichero
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(source, result);
        //a modo de comprobacion podemos mostrar el documento por pantalla especificando como canal de salida el System.out
        Result console = new StreamResult(System.out);
        transformer.transform(source, console);
    }
}
