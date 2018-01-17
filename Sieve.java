//Name: Damian Bouch
//Class: CIT 130
//Section: Z02B
//Week 3, Assignment 1
//Due: Sept 30, 2017

package bouch_sieveoferastosthenes;

import java.util.Scanner;

public class Sieve {
    
        public void SieveSetOfNumbers()
        {
    
            System.out.println("Please Enter Number Through Which To Sieve Primes: ");
        
        //Fetching program specs from user
            Scanner scanPrimes = new Scanner(System.in);       
        
            String userInput = scanPrimes.nextLine();   
                
            System.out.println("Starting Prime Sieve:");
        
        //Finding parameters of the loops
            int primeCeiling = Converters.ConvertStringToInteger(userInput);
            int countLimit = Converters.ConvertToInteger(Math.sqrt(primeCeiling));
        
            boolean[] testingArray = new boolean[primeCeiling];
        
            for(int i = 2; i <= countLimit; i++)
            {
                if(testingArray[i] == false)
                {                
                    for(int j = i; j <= primeCeiling; j++)
                    {
                    //These are the values to switch the bool flag when encountered below
                        int testIndexSquare = (i*i);
                        int testIndexProduct = (j*i);
                        int testIndex = (i*i + j*i);
                    
                    //These tests convert the default 'false' values of the bool array
                    //to true if they have a factors aside from themselves and one
                        if(testIndex < primeCeiling)
                        {
                            testingArray[testIndex] = true;
                        }  
                    
                        if(testIndexSquare < primeCeiling)
                        {
                            testingArray[testIndexSquare] = true;
                        }
                    
                        if(testIndexProduct < primeCeiling)
                        {
                            testingArray[testIndexProduct] = true;
                        }
                    }
                }
            }
        
            for(int i = 2; i < primeCeiling; i++)
            {
                if(testingArray[i] == false)
                {
                    System.out.println(i + " is a prime number");
                }
            }        
            System.out.println("Finished!");
        }
    
}
