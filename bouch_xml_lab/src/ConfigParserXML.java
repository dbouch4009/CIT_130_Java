import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class ConfigParserXML
{

    public int[] pidFormat(String input)
    {
        char firstChar = input.charAt(0);
        int[] intArray;
        switch(firstChar)
        {
            case('1'):
                intArray = new int[8];
                char[] thisAutoArray = input.toCharArray();
                for(int i = 4; i < input.length(); i++)
                {
                    intArray[i - 4] = Character.getNumericValue(thisAutoArray[i]);
                }
                try {
                    File myFile = new File("thisAuto.xml");
                    DocumentBuilderFactory dbFac = DocumentBuilderFactory.newInstance();
                    DocumentBuilder docBuilder = dbFac.newDocumentBuilder();
                    Document myDoc = docBuilder.parse(myFile);
                    break;
                }
                catch(Exception exc)
                {
                    System.out.println(exc);
                }

            case('2'):
                System.out.println("ThatAuto detected");
                intArray = new int[10];
                char[] thatAutoArray = input.toCharArray();
                for(int i = 5; i < input.length(); i++)
                {
                    intArray[i - 5] = (int)thatAutoArray[i];
                }
                break;
            case('3'):
                intArray = new int[13];
                System.out.println("OtherAuto detected");
                char[] OtherAutoArray = input.toCharArray();
                for(int i = 5; i < input.length(); i++)
                {
                    intArray[i - 3] = (int)OtherAutoArray[i];
                }
                break;
            default:
                System.out.println("Mismatch on Switch: Aborting");
                intArray = new int[0];
                System.exit(0);
                break;
        }
        return intArray;
    }
}
