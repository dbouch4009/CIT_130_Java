/*
Damian Bouch 
CIT 130
Week 4
Due: October 7, 2017
 */

//package bouch_week_4;

public class WrapperShallowTest 
{
    public static void main(String[] args) 
    {   
        WrapperShallow firstWs = new WrapperShallow();
        WrapperShallow secondWs = new WrapperShallow(firstWs);
        
        System.out.println("Beginning Shallow Test");
        System.out.println("");

        System.out.println("First Shallow Array: ");
        WrapperShallow.ToString(firstWs);
        
       
        System.out.println("Intial Shallow Copy Object: ");
        WrapperShallow.ToString(secondWs);


        firstWs.SetWrapper(32);
        
        System.out.println("Changed Shallow First Object: ");
        WrapperShallow.ToString(firstWs);
        
        System.out.println("Unchanged Shallow Copy Object: ");
        WrapperShallow.ToString(secondWs);
        
        if(WrapperShallow.Equals(firstWs, secondWs))
        {
            System.out.println("Oh Noes! Shallow object values are equal!");
        }
        else
        {
            System.out.println("Hooray! Shallow object values are not equal!");
        }
        
        
        // Second round of tests
        WrapperDeep firstWD = new WrapperDeep();
        WrapperDeep secondWD = new WrapperDeep(firstWD);
        
        System.out.println("Beginning Deep Test");
        System.out.println("");

        System.out.println("First Deep Array: ");
        WrapperDeep.ToString(firstWD);
        
       
        System.out.println("Intial Deep Copy Object: ");
        WrapperDeep.ToString(secondWD);

        firstWD.SetWrapper(32);
        
        System.out.println("Changed Deep First Object: ");
        WrapperDeep.ToString(firstWD);
        
        System.out.println("Unchanged Deep Copy Object: ");
        WrapperDeep.ToString(secondWD);
        
        if(WrapperDeep.Equals(firstWD, secondWD))
        {
            System.out.println("Oh Noes! Deep object values are equal!");
        }
        else
        {
            System.out.println("Hooray! Deep object values are not equal!");
        }

        System.out.println("C O M P L E T E");
        
    }
}
