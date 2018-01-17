/*
Damian Bouch
CIT 130 Z02B
Week 11 Assignment: Birthday Odds
Due: December 11, 2017
 */


//package bouch_week_11;
import java.util.Random;
import java.util.HashSet;
import java.util.Iterator;
public class BirthdayParadox
{
    Random rng = new Random();
    
    HashSet<Integer> birthdaySet = new HashSet<Integer>();
    Iterator<Integer> iter = birthdaySet.iterator();
    int counter = 0;

    int birthdayInt;
    int duplicateIndex = 0;   //maybe work in later to track first index
    double probabilityIndex = 0;
    int totalTests = 0;
    int collisionCount = 0;
    int personCount = 0;
    
    public void DoOneTest(int testNumberInput, int personCountInput)
    {
        probabilityIndex = 0;
        collisionCount = 0;
        totalTests = testNumberInput;
        personCount = personCountInput;
        
        
        for(int j = 0; j < totalTests - 1; j++)
        {
            BirthdayParadox bp = new BirthdayParadox();

            for(int i = 0; i < personCount - 1; i++)
            {
                birthdayInt = bp.rng.nextInt(365);
                if(bp.birthdaySet.contains(birthdayInt))
                {
                    //System.out.println("Collision at index " + i + " , with " + birthdayInt);
                    collisionCount++;                    
                    break;
                }
                else
                {
                    bp.birthdaySet.add(birthdayInt);
                }
            }       
        }
        System.out.println(collisionCount + " collisions for " + totalTests + " tests at " + personCount + " people");
        double dblCollCount = (double)collisionCount;
        double dblTotalTests = (double)totalTests;
        probabilityIndex = (dblCollCount/dblTotalTests);
        System.out.println("P is " + probabilityIndex);
        
    }
    
    public int indexOf(int inputInt, HashSet<Integer> hashInput)
    {
        while(iter.hasNext())
        {
            //if()       
            return 0;
        }
        return -1;
    }
}
