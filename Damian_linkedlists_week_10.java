/*
Damian Bouch
CIT 130 Week 10
Doubly Linked List
Due: December 2, 2017
 */
package damian_linkedlists_week_10;

public class Damian_linkedlists_week_10 {

    public static void main(String[] args) 
    {
        FavoriteFoods firstList = new FavoriteFoods();
        firstList.AddToStart("Spaghetti");
        firstList.AddToStart("Meatballs");
        
        String listOneString = firstList.toString();
        System.out.println("Starting");
        System.out.println(listOneString);
        
        System.out.println("Finished");
    }
    
}
