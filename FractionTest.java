//Name: Damian Bouch
//Class: CIT 130
//Section: Z02B
//Week 3, Assignments 1 and 2
//Due: Sept 30, 2017

package bouch_sieveoferastosthenes;

public class FractionTest {
    
    public void FractionTest() 
    {   
        System.out.println("Beginning Fraction Test: ");
        //Instantiating Fraction objects and comparing them.
        FractionADT fractionOne = new FractionADT(1,2);
        
        FractionADT fractionTwo = new FractionADT();
        
        fractionTwo.SetNumerator(3);
        fractionTwo.SetDenominator(4);
        
        if(FractionADT.Equals(fractionOne, fractionTwo))
        {
            System.out.println(fractionOne.ToString() + " is equal to " + fractionTwo.ToString());
        } else
        {
            System.out.println(fractionOne.ToString() + " is not equal to " + fractionTwo.ToString());
        }
        
        //Changing object properties and comparing a few times        
        fractionTwo.SetNumerator(10);
        fractionTwo.SetDenominator(20);
        
        if(FractionADT.Equals(fractionOne, fractionTwo))
        {
            System.out.println(fractionOne.ToString() + " is equal to " + fractionTwo.ToString());
        } else
        {
            System.out.println(fractionOne.ToString() + " is not equal to " + fractionTwo.ToString());
        }

        fractionOne.SetNumerator(7);
        fractionOne.SetDenominator(9);
        
        if(FractionADT.Equals(fractionOne, fractionTwo))
        {
            System.out.println(fractionOne.ToString() + " is equal to " + fractionTwo.ToString());
        } else
        {
            System.out.println(fractionOne.ToString() + " is not equal to " + fractionTwo.ToString());
        }
        
        fractionTwo.SetFraction(15, 16);
        
        if(FractionADT.Equals(fractionOne, fractionTwo))
        {
            System.out.println(fractionOne.ToString() + " is equal to " + fractionTwo.ToString());
        } else
        {
            System.out.println(fractionOne.ToString() + " is not equal to " + fractionTwo.ToString());
        }
        
        fractionOne.SetFraction(15, 16);
        
        if(FractionADT.Equals(fractionOne, fractionTwo))
        {
            System.out.println(fractionOne.ToString() + " is equal to " + fractionTwo.ToString());
        } else
        {
            System.out.println(fractionOne.ToString() + " is not equal to " + fractionTwo.ToString());
        }
        
        fractionTwo.SetFraction(30, 32);
        
        if(FractionADT.Equals(fractionOne, fractionTwo))
        {
            System.out.println(fractionOne.ToString() + " is equal to " + fractionTwo.ToString());
        } else
        {
            System.out.println(fractionOne.ToString() + " is not equal to " + fractionTwo.ToString());
        }
        
        fractionOne.SetNumerator(30);
        fractionOne.SetDenominator(32);
        
        if(FractionADT.Equals(fractionOne, fractionTwo))
        {
            System.out.println(fractionOne.ToString() + " is equal to " + fractionTwo.ToString());
        } else
        {
            System.out.println(fractionOne.ToString() + " is not equal to " + fractionTwo.ToString());
        }
    }    
}
