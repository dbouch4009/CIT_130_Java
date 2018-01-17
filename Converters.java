package bouch_sieveoferastosthenes;

/**
 *
 * @author Damian
 */
public class Converters 
{
/**
 *
 * @author Damian Bouch
 */
    //These methods will allow easy flow between data types
    public static int ConvertToInteger(double doubleOne)
    {
        return (int)doubleOne;
    }   
    
    public static int ConvertStringToInteger(String stringOne)
    {
        return Integer.parseInt(stringOne);
    }
    
    public static double ConvertToDouble(int integerOne)
    {
        return (double)integerOne;
    }
    
    
}
