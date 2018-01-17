//Name: Damian Bouch
//Class: CIT 130
//Section: Z02B
//Week 3, Assignment 2
//Due: Sept 30, 2017

package bouch_sieveoferastosthenes;

public class FractionADT {
    //Setting properties
    private int numeratorOne;
    private int denomOne;
    
    //Constructor w/ override option
    public FractionADT()
    {
        numeratorOne = 0;
        denomOne = 0;
    }
    
    public FractionADT(int inputNumerator, int inputDenominator)
    {
        numeratorOne = inputNumerator;
        denomOne = inputDenominator;
    }
    
    public int GetNumerator()
    {
        System.out.println("Numerator retrieved: " + this.numeratorOne);
        return this.numeratorOne;
    }
    
    public int GetDenominator()
    {
        System.out.println("Denominator retrieved: " + this.denomOne);
        return this.denomOne;
    }
           
    public void SetNumerator(int inputNumerator)
    {
        this.numeratorOne = inputNumerator;
    }
    
    public void SetDenominator(int inputDenom)
    {
        this.denomOne = inputDenom;
    }
    
    public void SetFraction(int inputNumerator, int inputDenominator)
    {
        this.numeratorOne = inputNumerator;
        this.denomOne = inputDenominator;
    }
    
    //Converting to string
    public String ToString()
    {
        return (Integer.toString(numeratorOne) + "/" + Integer.toString(denomOne));
    }
    
    public static boolean Equals(FractionADT fractionOne,FractionADT fractionTwo)
    {
        //Fetching quotient values for each of the FractionADT objects passed in
        double myNumeratorOne =  (double)fractionOne.numeratorOne;
        double myDenominatorOne = (double)fractionOne.denomOne;
        double myQuotientOne = (myNumeratorOne/myDenominatorOne);
        
        double myNumeratorTwo =  (double)fractionTwo.numeratorOne;
        double myDenominatorTwo = (double)fractionTwo.denomOne;
        double myQuotientTwo = (myNumeratorTwo/myDenominatorTwo);
        
        return (myQuotientOne == myQuotientTwo);
        
    }
    
}
