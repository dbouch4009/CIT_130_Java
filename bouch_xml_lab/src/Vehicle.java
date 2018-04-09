import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Arrays;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class Vehicle
{
    private String make;
    private String model;
    private String[] options = new String[8];
    private String[] parts = new String[8];
    private double price;

    private double modelPrice;

    public Vehicle(String makeIn, String modelIn, String optionsIn[], String partsIn[], double priceIn)
    {
        this.make = makeIn;
        this.model = modelIn;
        this.options = optionsIn;
        this.parts = partsIn;
        this.price = priceIn;
    }

    public Vehicle()
    {

    }

    public String toString()
    {
        StringBuilder optionsString = new StringBuilder("\nOptions: ");
        StringBuilder partsString = new StringBuilder("\nParts: ");
        String[] optionsNames = new String[]{"Exterior: ","Interior: ","Powertrain: ","Seat: ","Radio: ","Tire: ","Rim: ","Misc"};

        for(int i = 0; i < 7; i++)
        {
            optionsString.append(optionsNames[i] + options[i] + " | ");
            optionsString.append(parts[i] + " | ");
        }

        return ("\nHere is your vehicle: " + this.getModel() + " | " + this.getMake() + " | " + optionsString + "\nTotal Price: " + this.price);
    }

    public String getMake()
    {
        return this.make;
    }

    public String getModel()
    {
        return this.model;
    }

    public String[] getOptions()
    {
        return this.options;
    }

    public String[] getParts()
    {
        return this.parts;
    }

    public double getPrice()
    {
        return this.price;
    }

    public void setMake(int[] input)
    {
        int firstIndex = input[0];
        switch(firstIndex)
        {
            case(1):
                this.make = "ThisAuto";
                System.out.println("Make set to ThisAuto");
                break;
            case(2):
                this.make = "ThatAuto";
                System.out.println("Make set to ThatAuto");
                break;
            case(3):
                this.make = "OtherAuto";
                System.out.println("Make set to OtherAuto");
                break;
            default:
                this.make= "Error";
                break;
        }
    }

    public void setModel(String input)
    {
        String modelFinder = input.substring(0,4);;
        //System.out.println("ModelFinder: " + modelFinder);
        String myModel = "DefaultModel";
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
                    myModel = element.getElementsByTagName("Value").item(0).getTextContent();
                    this.modelPrice = Double.parseDouble(element.getElementsByTagName("Cost").item(0).getTextContent());
                }
            }
        }
        catch(Exception exc)
        {
            System.out.println("Exception thrown");
            System.out.println(exc);
        }
        System.out.println("Model: " + myModel);
        this.model = myModel;
    }

    public void setOptions(int[] input)
    {
        String extColor = Integer.toString(input[0]);
        String intColor = Integer.toString(input[1]);
        String powerTrain = Integer.toString(input[2]);
        String seat = Integer.toString(input[3]);
        String radio = Integer.toString(input[4]);
        String tire = Integer.toString(input[5]);
        String rim = Integer.toString(input[6]);
        String misc = Integer.toString(input[7]);

        String vehicleType = "Sedan";

        try
        {
            setIndividualOption("Exterior-Color",extColor,0);
            setIndividualOption("Interior-Color",intColor,1);
            setIndividualOption("Powertrain",powerTrain,2);
            setIndividualOption("Seat",seat,3);
            setIndividualOption("Radio",radio,4);
            setIndividualOption("Tire",tire,5);
            setIndividualOption("Rim",rim,6);
            setIndividualOption("Miscellaneous",misc,7);
        }
        catch(Exception exc)
        {
            System.out.println("Exception thrown: unable to set options");
            System.out.println(exc.toString());
        }
    }

    private void setIndividualOption(String optionType, String optionsValue, int optionIndex) {
        try
        {
            File myFile = new File("thisauto.xml");
            DocumentBuilderFactory dbFac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFac.newDocumentBuilder();
            Document myDoc = docBuilder.parse(myFile);

            NodeList nodes = myDoc.getElementsByTagName(optionType);
            for (int temp = 0; temp < nodes.getLength(); temp++) {
                Node node = nodes.item(temp);
                Element element = (Element) node;
                if (element.getAttribute("id").equals(optionsValue)) {
                    this.options[optionIndex] = element.getElementsByTagName("Value").item(0).getTextContent();
                }
            }
        }
        catch(Exception exc)
        {
            System.out.println("Exception thrown");
            System.out.println(exc.toString());
        }
    }

    public void setParts(int[] input)
    {
        String extColor = Integer.toString(input[0]);
        String intColor = Integer.toString(input[1]);
        String powerTrain = Integer.toString(input[2]);
        String seat = Integer.toString(input[3]);
        String radio = Integer.toString(input[4]);
        String tire = Integer.toString(input[5]);
        String rim = Integer.toString(input[6]);
        String misc = Integer.toString(input[7]);

        String vehicleType = "Sedan";

        try
        {
            setIndividualParts("Exterior-Color",extColor,0);
            setIndividualParts("Interior-Color",intColor,1);
            setIndividualParts("Powertrain",powerTrain,2);
            setIndividualParts("Seat",seat,3);
            setIndividualParts("Radio",radio,4);
            setIndividualParts("Tire",tire,5);
            setIndividualParts("Rim",rim,6);
            setIndividualParts("Miscellaneous",misc,7);
        }
        catch(Exception exc)
        {
            System.out.println("Exception thrown: unable to set options");
            System.out.println(exc.toString());
        }
    }


    private void setIndividualParts(String optionType, String optionsValue, int optionIndex)
    {
        try {
            File myFile = new File("thisauto.xml");
            DocumentBuilderFactory dbFac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFac.newDocumentBuilder();
            Document myDoc = docBuilder.parse(myFile);

            NodeList nodes = myDoc.getElementsByTagName(optionType);
            for (int temp = 0; temp < nodes.getLength(); temp++) {
                Node node = nodes.item(temp);
                Element element = (Element) node;
                if (element.getAttribute("id").equals(optionsValue)) {
                    this.parts[optionIndex] = element.getElementsByTagName("Cost").item(0).getTextContent();
                }
            }
        } catch (Exception exc) {
            System.out.println("Exception thrown");
            System.out.println(exc.toString());
        }
    }

    public void setPrice(String[] partsIn)
    {
        double[] prices = new double[9];

        prices[0] = this.modelPrice;

        double cumulativePrice = 47;

        for(int i = 0; i < partsIn.length; i++)
        {
            prices[i+1] = Double.parseDouble(partsIn[i]);
        }

        for(int i = 0; i < prices.length; i++)
        {
            cumulativePrice += prices[i];
        }

        this.price = cumulativePrice;
    }

}
