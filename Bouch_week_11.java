/*
Damian Bouch
CIT 130 Z02B
Week 11 Assignment: Birthday Odds
Due: December 11, 2017
 */
//package bouch_week_11;

public class Bouch_week_11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        BirthdayParadox bp1 = new BirthdayParadox();
        
        for(int i = 0; i <= 100; i = i + 10)
        {
            bp1.DoOneTest(100, i);
        }        


/*        
        System.out.println("At 20 people");
        for(int i = 0; i <= 20; i++)
        {
            birthdayInt = bp.rng.nextInt(365);
            if(bp.birthdaySet.contains(birthdayInt))
            {
                System.out.println("Collision at index" + i + " , with " + birthdayInt);
                break;
            }
            else
            {
                bp.birthdaySet.add(birthdayInt);
            }
        }       
        System.out.println("size: " + bp.birthdaySet.size());
*/

        
        System.out.println("Finished");
    }
    
}
