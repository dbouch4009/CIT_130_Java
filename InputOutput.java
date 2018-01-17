/*
Damian Bouch
CIT 130
Due: October 21, 2017
Assignment 6
 */
//package bouch_week_6;
import java.util.Scanner;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.PrintWriter;

public class InputOutput implements Serializable
{
    private String fileName = "";
    private String fileType = "";
    private String continueInput = "";
    private String continueYes = "Y";
    private String continueNo = "N";
    private String binaryFile = "B";
    private String textFile = "T";
    private String textToPrint = "default";
        
    Scanner myScanner = new Scanner(System.in);
    
    public String FetchFileName()
    {
        System.out.println("Please enter file name");
        fileName = myScanner.next().toString();
        return fileName;
    }
    
    public String FetchTextForFile()
    {
        System.out.println("Please enter text to write");
        String textForFile = myScanner.nextLine().toString();
        return textForFile;
    }
    
    public String GetText()
    {        
        return myScanner.nextLine();
    }
    
    public void FetchContinue()
    {
        System.out.println("Would you like to continue?? y/n");
        continueInput = myScanner.next().toString().toUpperCase();
        if(continueInput == continueYes)
        {
            FetchFileName();
        }
        else
        {
            System.out.println("File manipulation finished.");
        }
    }
    
    public void FetchFileType()
    {
        System.out.println("Binary or text file?? b/t");
        
        fileType = myScanner.next().toString().toUpperCase();
        if(fileType == binaryFile)
        {
            CreateBinaryFile(fileName);
        }
        else if(fileType == textFile)
        {
            CreateTextFile(fileName);
        }
        else
        {
            System.out.println("Invalid input. Stopping process.");
        }
    }
    
    public void CreateBinaryFile(String nameOfFile)
    {
        try
        {
            ObjectOutputStream myOutputStream = new ObjectOutputStream(new FileOutputStream(nameOfFile));
            boolean userContinue = true;
            String textForFile = "";
            Scanner textScanner = new Scanner(System.in);
            while(userContinue)
            {
                System.out.println("Enter line of text for your file. Enter 'END' if finished: ");
                textForFile = textScanner.nextLine();            
                if(textForFile.toUpperCase().equals("END"))
                {
                    userContinue = false;
                    break;
                }            
                myOutputStream.writeObject(textForFile);
            }             
            myOutputStream.close();
        }
        catch(IOException e)
        {
            System.out.println("IOException: problem with output");
        }
    }
    
    public void ReadBinaryFile(String nameOfFile)
    {
        try
        {
            ObjectInputStream binaryInputStream = null;
            try
            {
                binaryInputStream = new ObjectInputStream(new FileInputStream(nameOfFile));
                while(true)
                {
                    System.out.println(binaryInputStream.readObject()) ;
                }
            }
            catch(FileNotFoundException e)
            {
                System.out.println("FileNotFoundException: error opening file");
            }
            catch(EOFException e)
            {
                System.out.println("End of file binary reached");
            }
            binaryInputStream.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception: problem with reading file");
        }
        
    }
    
    public void CreateTextFile(String nameOfFile)
    {
        PrintWriter myOutputStream = null;
        try
        {
            myOutputStream = new PrintWriter(new FileOutputStream(nameOfFile));            
        }
        catch(FileNotFoundException e)
        {
            System.out.println("FileNotFoundException: problem opening the file");
        }
        boolean userContinue = true;
        String textForFile = "";
        Scanner textScanner = new Scanner(System.in);
        while(userContinue)
        {
            System.out.println("Enter line of text for your file. Enter 'END' if finished: ");
            textForFile = textScanner.nextLine();            
            if(textForFile.toUpperCase().equals("END"))
            {
                userContinue = false;
                break;
            }            
            myOutputStream.println(textForFile);
        }             
        myOutputStream.close();
    }
    
    public void ReadTextFile(String nameOfFile)
    {
        Scanner readTextScanner = null;
        try
        {
            readTextScanner = new Scanner(new FileInputStream(nameOfFile));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("FileNotFoundException: error opening file");
        }
        while(readTextScanner.hasNextLine())
        {
            System.out.println(readTextScanner.nextLine());
        }
    }    
}
