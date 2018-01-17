/*
Damian Bouch
CIT 130
Due: October 21, 2017
Assignment 6
 */
//package bouch_week_6;

public class DenominatorIsZeroException extends Exception
{
    public DenominatorIsZeroException()
    {
        super("Denominator Error");
    }
    
    public DenominatorIsZeroException(String passedString)
    {
        super(passedString);
    }
}
