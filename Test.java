/*
Damian Bouch
CIT 130, Section Z02B
Week 9 Generics
Due: November 18, 2017
 */
//package bouch_standard_deviation;

import java.util.ArrayList;

public class Test<T extends Number>
{
    public static<T extends Number> double DoDouble(T input)
    {
        double myDouble = input.doubleValue();
        
        return myDouble;
    }
    
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
