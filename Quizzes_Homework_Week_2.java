/*Damian Bouch
Sept 22, 2017
Assignment one for CIT 130
Interest Calculator

*/
import java.util.Scanner;
import java.text.DecimalFormat;

public class Quizzes_Homework_Week_2 {


    public static void main(String[] args) {                
        /*
        //Retrieving values from user
        System.out.println("Welcome to Interest Calculator!");
        Scanner myInputDevice = new Scanner(System.in);
        
        System.out.println("Enter the current cost of the item:");
        String currentCostString = myInputDevice.nextLine();
        
        System.out.println("Enter the percentage rate of inflation:");
        String inflationString = myInputDevice.nextLine();
        
        System.out.println("Enter the number of years ahead to forecast:");
        String yearsString = myInputDevice.nextLine();
        
        //Setting inputs to double values
        DecimalFormat myFormat = new DecimalFormat("#.00");
        double currentCost = Double.parseDouble(currentCostString);
        double inflationRate = Double.parseDouble(inflationString);
        double yearCount = Double.parseDouble(yearsString);
        double yearlyCostAdded = 0;
        
        //Setting inflation to a decimal value
        inflationRate = (inflationRate/100);
        
        //Calculating cost given specifics
        for(int i = 0;i<yearCount;i++)
        {
            yearlyCostAdded = (currentCost * inflationRate);
            currentCost = (currentCost + yearlyCostAdded);
            
            //Uncomment these lines for debugging
            //System.out.println(i + "^^" + "^^" + currentCost + "^^" + yearlyCostAdded);
            
            yearlyCostAdded = 0;
        }        
        
        //Final summary for user writes to console
        System.out.println("The cost in " + yearCount + " years at " + 
                inflationRate + " will be $" + myFormat.format(currentCost));

        */
        
         //Counterclass part of the homework
        CounterClass FirstCounter = new CounterClass();
        CounterClass SecondCounter = new CounterClass(2);        
        FirstCounter.CompareValues(FirstCounter, SecondCounter);
        
        FirstCounter.SubtractFromInt(FirstCounter.GetCounter());
        SecondCounter.SubtractFromInt(SecondCounter.GetCounter());
        FirstCounter.CompareValues(FirstCounter, SecondCounter);
        
        FirstCounter.AddToInt(FirstCounter.GetCounter());
        SecondCounter.AddToInt(SecondCounter.GetCounter());
        FirstCounter.CompareValues(FirstCounter, SecondCounter);
        
        FirstCounter.SetCounter(5);
        SecondCounter.SetCounter(5);
        FirstCounter.CompareValues(FirstCounter, SecondCounter);
        
        
    }
    
}
