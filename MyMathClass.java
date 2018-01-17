/*
Damian Bouch
CIT 130, Section Z02B
Week 9 Generics
Due: November 18, 2017
 */
//package Bouch_standard_deviation;

import java.util.ArrayList;
import java.lang.Number;
import java.lang.*;
import java.lang.System.*;
public class MyMathClass<T extends Number>
{
    public static<T extends Number> double FindStdDev(ArrayList<T> inputArray)
    {
        double lengthOfArray = inputArray.size();
        double sumForMean = 0;
        double mean = 0;  
        double sigmaTotal = 0;
        double finalDivisor = lengthOfArray - 1;
        double stdDeviation = 0;
        
        double[] arrayForUse = new double[inputArray.size()];
        
        for(int count = 0; count < inputArray.size(); count++)
        {
            double tempDouble = inputArray.get(count).doubleValue();
            arrayForUse[count] = tempDouble;
        }       
        
        for(double element: arrayForUse)        
        {
            sumForMean += element;
            System.out.println(Double.toString(element) + " added");
        }
        
        mean = sumForMean/lengthOfArray;
        System.out.println("Mean is: " + Double.toString(mean));
        
        for(double element: arrayForUse)
        {            
            sigmaTotal += (Math.pow((element - mean),2));
        }
        
        stdDeviation = Math.sqrt(sigmaTotal/finalDivisor);      
        
        return stdDeviation;
    }
}
