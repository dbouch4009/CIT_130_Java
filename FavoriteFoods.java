/*
Damian Bouch
CIT 130 Week 10
Doubly Linked List
Due: December 2, 2017
 */
package damian_linkedlists_week_10;

public class FavoriteFoods implements PubliclyCloneable
{
    private ItalianFood head;
    
    public FavoriteFoods()
    {
        head = null;
    }
    
    private class ItalianFood
    {
        private String foodName;
        private ItalianFood previous;
        private ItalianFood next;
        
        private ItalianFood()
        {
            foodName = null;
            previous = null;
            next = null;
        }
        
        private ItalianFood(String inputName, ItalianFood previousInput, ItalianFood nextInput)
        {
            foodName = inputName;
            previous = previousInput;
            next = nextInput;
        }
        
        public String toString()
        {
        ItalianFood position = head;
        String builderString = "";
        while(position != null)
        {
            builderString += (position.foodName + "\n");
            position = position.next;
        }
        return builderString;
        }
    }
    //End of inner class
    
    public FavoriteFoods clone()
    {
        try
        {
            FavoriteFoods copy = (FavoriteFoods)super.clone();
            if(head == null)
            {
                copy.head = null;
            }
            else
            {
                copy.head = copyOf(head);
            }
            return copy;
        }
        catch(CloneNotSupportedException e)
        {
            return null;
        }
    }
    
    public void AddToStart(String itemInput)
    {
        ItalianFood newHead = new ItalianFood(itemInput, head, null);
        
        head = newHead;        
        //newHead.next = head.next;
        //newHead.previous = head.previous;
    }

    private ItalianFood copyOf(ItalianFood otherHead)
    {
        ItalianFood position = otherHead;
        ItalianFood newHead;
        ItalianFood end = null;
       
        newHead = new ItalianFood(position.foodName, position.previous, position.next);
        end = newHead;        
                        
        while(position.next != null)
        {
            end.next = new ItalianFood(position.foodName, position.previous, position.next);
            end = end.next;
            position = position.next;
        }
        position = position.next;
        return newHead;
    }
}
//End of Favorite Foods
