/*
Damian Bouch
CIT 130, Section Z02B
Week 9 Generics
Due: November 18, 2017
 */
//package bouch_standard_deviation;

import java.util.ArrayList;

public class Bouch_standard_deviation {

    public static void main(String[] args) 
    {    

        ArrayList<Integer> listInteger = new ArrayList<Integer>();
        
        listInteger.add(2);
        listInteger.add(13);
        listInteger.add(8);
        listInteger.add(21);
        listInteger.add(7);
        
        double intResult = Test.FindStdDev(listInteger);

        System.out.println("Standard Devation is: " + intResult);
        
        System.out.println("################################");
        System.out.println("################################");
        
        ArrayList<Double> listDouble = new ArrayList<Double>();
        
        listDouble.add(8.4);
        listDouble.add(12.0);
        listDouble.add(5.0);
        listDouble.add(13.4);
        listDouble.add(1.0);
        
        double dblResult = Test.FindStdDev(listDouble);
        
        System.out.println("Standard Deviation is: " + dblResult);
        
        System.out.println("Finished");       

        double result = Test.DoDouble(5);
        System.out.println(result);
        
    }
    
}
