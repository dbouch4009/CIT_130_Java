/*
Damian Bouch
CIT 130 Week 10
Doubly Linked List
Due: December 2, 2017
 */
//package bouch_week_10;

public class Bouch_week_10 
{
    public static void main(String[] args) 
    {
        //DamianLinkedList dllOne = new DamianLinkedList();
        
        //DamianLinkedList dllClone = new DamianLinkedList();
        
        //dllOne.AddToStart();
        
        ExcellentLinkedList ellOne = new ExcellentLinkedList();
        ExcellentLinkedList ellClone = new ExcellentLinkedList();
        ellOne.AddToStart("A Christmas Carol");
        ellOne.AddToStart("The Brothers Karamazov");
        ellOne.AddToStart("Babbitt");
        ellOne.AddToStart("LOTR");
        
        ellClone = ellOne.clone();
        
        String excellentOutput = ellOne.toString();
        String cloneOutput = ellClone.toString();
        System.out.println(excellentOutput);
        System.out.println(cloneOutput);
        
        ExcellentLinkedList.ExcellentIterator iteratorOne = ellOne.iterator();
        ExcellentLinkedList.ExcellentIterator iteratorClone = ellClone.iterator();
        
        System.out.println("");        
        System.out.println("Original content iterated:");
        iteratorOne.Restart();
        while(iteratorOne.hasNext())
        {
            System.out.println(iteratorOne.Next());
        }
        
        System.out.println("");
        System.out.println("Clone content iterated:");        
        iteratorClone.Restart();
        while(iteratorClone.hasNext())
        {
            System.out.println(iteratorClone.Next());
        }
        System.out.println("");

        System.out.print("Same? " + ellOne.equals(ellClone));
        
        System.out.println("");
        
        System.out.println("Adding new book to start of original");
        ellOne.AddToStart("Old Curiosity Shop");
        
        System.out.println("");        
        System.out.println("Original content iterated:");
        iteratorOne.Restart();
        while(iteratorOne.hasNext())
        {
            System.out.println(iteratorOne.Next());
        }
        
        System.out.println("");

        System.out.print("Same? " + ellOne.equals(ellClone));
        
        System.out.println("");
        System.out.println("Clone content iterated:");        
        iteratorClone.Restart();
        while(iteratorClone.hasNext())
        {
            System.out.println(iteratorClone.Next());
        }
        
        System.out.println("");
        System.out.println("Adding book to start of clone:");
        ellClone.AddToStart("Dragon Tattoo");
        
        //Print Block
        System.out.println("");

        System.out.print("Same? " + ellOne.equals(ellClone));
        
        System.out.println("");        
        System.out.println("Original content iterated:");
        iteratorOne.Restart();
        while(iteratorOne.hasNext())
        {
            System.out.println(iteratorOne.Next());
        }
        
        System.out.println("");
        System.out.println("Clone content iterated:");        
        iteratorClone.Restart();
        while(iteratorClone.hasNext())
        {
            System.out.println(iteratorClone.Next());
        }
        //End of print block
        
        System.out.println("");

        int ellOneSize = ellOne.ListSize();
        System.out.println("Original List Size: " + ellOneSize);
        
        String backwardString = ellOne.BackwardToString();
        System.out.println("Backward list: ");
        System.out.println(backwardString);
        
        
        
    }
    
}
