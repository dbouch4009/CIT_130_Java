import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
public class bouch_xml_lab
{

    public static void Request()
    {
        String input = "";
        while(input != "-1") {
            System.out.println("\nHello, please enter your config number. -1 to exit: ");
            Scanner scanner = new Scanner(System.in);
            input = scanner.next();
            if(input.equals("-1"))
            {
                System.out.println("Good bye");
                System.exit(0);
            }
            buildVehicle(input);
        }
    }

    public static void buildVehicle(String pid)
    {
        ConfigParserXML cpXML = new ConfigParserXML();
        System.out.println(pid);
        int[] formattedPid = cpXML.pidFormat(pid);
        String vehicleTypeIndicator = Character.toString(pid.charAt(1));

        switch(vehicleTypeIndicator)
        {
            case("1"):
                Sedan mySedan = new Sedan();
                mySedan.setMake(formattedPid);
                mySedan.setModel(pid);
                mySedan.setOptions(formattedPid);
                mySedan.setParts(formattedPid);
                mySedan.setPrice(mySedan.getParts());
                mySedan.setEngineSize(pid);
                mySedan.setHatchback(pid);
                System.out.println(mySedan.toString());
                break;

            case("2"):
                Coupe myCoupe = new Coupe();
                myCoupe.setMake(formattedPid);
                myCoupe.setModel(pid);
                myCoupe.setOptions(formattedPid);
                myCoupe.setParts(formattedPid);
                myCoupe.setPrice(myCoupe.getParts());
                System.out.println(myCoupe.toString());
                break;

            case("3"):
                Minivan myMini = new Minivan();
                myMini.setMake(formattedPid);
                myMini.setModel(pid);
                myMini.setOptions(formattedPid);
                myMini.setParts(formattedPid);
                myMini.setPrice(myMini.getParts());
                System.out.println(myMini.toString());
                break;

            case("4"):
                SUV mySUV = new SUV();
                mySUV.setMake(formattedPid);
                mySUV.setModel(pid);
                mySUV.setOptions(formattedPid);
                mySUV.setParts(formattedPid);
                mySUV.setPrice(mySUV.getParts());
                System.out.println(mySUV.toString());
                break;

            case("5"):
                Truck myTruck = new Truck();
                myTruck.setMake(formattedPid);
                myTruck.setModel(pid);
                myTruck.setOptions(formattedPid);
                myTruck.setParts(formattedPid);
                myTruck.setPrice(myTruck.getParts());
                System.out.println(myTruck.toString());
                break;

            default:
                Vehicle myVehicle = new Vehicle();
                myVehicle.setMake(formattedPid);
                myVehicle.setModel(pid);
                myVehicle.setOptions(formattedPid);
                myVehicle.setParts(formattedPid);
                myVehicle.setPrice(myVehicle.getParts());
                System.out.println(myVehicle.toString());
                break;
        }
    }

    public static void main(String[] args)
    {
        Request();
    }
}
