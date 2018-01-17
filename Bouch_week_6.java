/*
Damian Bouch
CIT 130
Due: October 21, 2017
Assignment 6
 */
//package bouch_week_6;

public class Bouch_week_6 
{   
    
    public static void main(String[] args) 
    {
        //Testing Week 6 work is here

        System.out.println("##############################");
        System.out.println("Input/Output Streaming");
        System.out.println("##############################");
        
        InputOutput ioclass = new InputOutput();
        
        String name = ioclass.FetchFileName();
        ioclass.CreateTextFile(name);
        ioclass.ReadTextFile(name);
        
        String binaryName = ioclass.FetchFileName();
        ioclass.CreateBinaryFile(binaryName);
        ioclass.ReadBinaryFile(binaryName);
        
        System.out.println("##############################");
        System.out.println("Try/Catch Testing");
        System.out.println("##############################");
        FractionADT myFrac = new FractionADT();
        
        System.out.println("Handling Exceptions in the Fraction Class");
        System.out.println("Fetching input:");
        int numInput = myFrac.FetchNumerator();
        int denomInput = myFrac.FetchDenominator();

        System.out.println("Setting");
        myFrac.SetNumerator(numInput);
        myFrac.SetDenominator(denomInput);

        System.out.println("Setting Fraction");
        myFrac.SetFraction(numInput, denomInput);
        System.out.println(myFrac.ToString());  
       


        

       
    }
    
}
