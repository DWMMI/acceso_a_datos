import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LeerXML {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //crear una instancia de DocumentBuilderFactory
        DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
        DocumentBuilder db = factory.newDocumentBuilder();

        //crear un DocumentBuilder para usarlo como parseador y recuperar  el documento a leer
        Document document = db.parse(new File("ejercicio1.xml"));

        //para acceder al nodo raíz
        Node raiz = document.getFirstChild();

        //para cada nodo, se puede acceder a su nombre y a los nodos que contiene:
        raiz.getNodeName();
        NodeList nodos = raiz.getChildNodes();

        //para acceder a los elementos de una lista de nodos:
        Node nodo = nodos.item(2);

        //para cada nodo, también podemos conocer el tipo de elemento:
        nodo.getNodeType();

        //podemos comprobar si es un elemento, atributo, entidad o texto
        //Node.ELEMENT_NODE, Node.ATTRIBUTE_NODE, Node.ENTITY_NODE, Node.TEXT_NODE
        //si un nodo es de tipo texto, se puede acceder a su contenido o valor:
        nodo.getNodeValue();
    }
}
