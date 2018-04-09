import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Sedan extends Vehicle
{
    private boolean isHatchback;
    private int engineSize;

    public boolean getIsHatchback()
    {
        return this.isHatchback;
    }

    public int getEngineSize()
    {
        return this.engineSize;
    }

    public void setHatchback(String input)
    {
        String modelFinder = input.substring(0,4);
        //System.out.println("ModelFinder: " + modelFinder);
        try
        {
            File myFile = new File("thisauto.xml");
            DocumentBuilderFactory dbFac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFac.newDocumentBuilder();
            Document myDoc = docBuilder.parse(myFile);

            NodeList nodes = myDoc.getElementsByTagName("Sedan");
            for(int temp = 0; temp < nodes.getLength(); temp++)
            {
                Node node = nodes.item(temp);
                Element element = (Element) node;
                if(element.getAttribute("id").equals(modelFinder))
                {
                    this.isHatchback = Boolean.parseBoolean(element.getElementsByTagName("Value").item(0).getTextContent());
                }
            }
        }
        catch(Exception exc)
        {
            System.out.println("Exception thrown: ishatchback");
            System.out.println(exc);
        }
    }

    public void setEngineSize(String input)
    {
        String modelFinder = input.substring(0,4);
        System.out.println("ModelFinder: " + modelFinder);
        try
        {
            File myFile = new File("thisauto.xml");
            DocumentBuilderFactory dbFac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFac.newDocumentBuilder();
            Document myDoc = docBuilder.parse(myFile);

            NodeList nodes = myDoc.getElementsByTagName("Sedan");
            for(int temp = 0; temp < nodes.getLength(); temp++)
            {
                Node node = nodes.item(temp);
                Element element = (Element) node;
                if(element.getAttribute("id").equals(modelFinder))
                {
                    this.engineSize = Integer.parseInt(element.getElementsByTagName("Value").item(0).getTextContent());
                }
            }
        }
        catch(Exception exc)
        {
            System.out.println("Exception thrown: engine size");
            System.out.println(exc);
        }
    }
}
