import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.helpers.DefaultHandler;

class XML_Stuff{
    public void print_values_with_dom()
    {
        System.out.println("    DOM");
        try {
            Stack stack = new Stack();
            File myFile = new File("plant_catalog.xml");
            DocumentBuilderFactory dbFac = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbFac.newDocumentBuilder();
            Document myDoc = db.parse(myFile);
            NodeList nodeList = myDoc.getElementsByTagName("PLANT");
            System.out.println("ROOT: " + myDoc.getDocumentElement().getNodeName());
            for(int i = 0; i < nodeList.getLength(); i++)
            {
                Node node = nodeList.item(i);
                Element element = (Element)node;
                //System.out.println(element.getTagName());
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    //System.out.println(element.getElementsByTagName("COMMON").item(0).getTextContent());
                    if(element.getElementsByTagName("COMMON").item(0).getTextContent().equals("Ginger, Wild"))
                    {
                        System.out.println("Found it");
                        System.out.println("COMMON: " + element.getElementsByTagName("COMMON").item(0).getTextContent());
                        System.out.println("BOTANICAL: " + element.getElementsByTagName("BOTANICAL").item(0).getTextContent());
                        System.out.println("ZONE: " + element.getElementsByTagName("ZONE").item(0).getTextContent());
                        System.out.println("LIGHT: " + element.getElementsByTagName("LIGHT").item(0).getTextContent());
                        System.out.println("PRICE: " + element.getElementsByTagName("PRICE").item(0).getTextContent());
                        System.out.println("AVAILABILITY: " + element.getElementsByTagName("AVAILABILITY").item(0).getTextContent());
                    }
                }
            }
        } catch(SAXException e){
            System.out.println(e);
        } catch(javax.xml.parsers.ParserConfigurationException e){
            System.out.println(e);
        } catch(java.io.IOException e){
            System.out.println(e);
        }
    }
/*
    public void print_values_with_sax(String filename, int index)
    {
        System.out.println("    SAX");
        try
        {


        } catch(SAXException e){
            System.out.println(e);
        } catch(javax.xml.parsers.ParserConfigurationException e){
            System.out.println(e);
        } catch(java.io.IOException e){
            System.out.println(e);
        }
    }
    */
}


class FlowerHandler extends DefaultHandler
{

    boolean common = false;
    boolean botanical = false;
    boolean zone = false;
    boolean light = false;
    boolean price = false;
    boolean availability = false;
    int i = 0;
    int index = 0;

    FlowerHandler(int index)
    {


    }

    public void StartElement(String uri, String name)
    {
        System.out.println();
    }

    public void PrintAll()
    {
        System.out.println("Name: " + new String());
    }


    // https://www.tutorialspoint.com/java_xml/java_sax_parse_document.htm
}