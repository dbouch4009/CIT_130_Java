/*
Damian Bouch
CIT 130 Week 10
Doubly Linked List
Due: December 2, 2017
 */
//package bouch_week_10;

public class ExcellentLinkedList implements PubliclyCloneable
{
    private TwoWayNode head;
    private TwoWayNode tailNode;
    
    private class TwoWayNode implements PubliclyCloneable
    {
        private String item;
        private TwoWayNode previous;
        private TwoWayNode next;
        
        public TwoWayNode()
        {
            item = null;
            next = null;
            previous = null;
        }
        
        public TwoWayNode(String itemInput)
        {
            item = itemInput;
        }
        
        public TwoWayNode(String itemInput, TwoWayNode nextNodeInput)
        {
            item = itemInput;
            next = nextNodeInput;
            //Deprecated constructor
            //previous = previousNodeInput;
        }
        
        public TwoWayNode(String itemInput, TwoWayNode nextNodeInput, TwoWayNode prevNodeInput)
        {
            item = itemInput;
            next = nextNodeInput;
            previous = prevNodeInput;
        }
        
        public Object clone()
        {
            try
            {
                return super.clone();
            }
            catch(CloneNotSupportedException e)
            {
                return null;
            }
        }
        public boolean equals(Object otherObject)
        {
            if(otherObject == null)
            {
                return false;
            }
            else if(getClass() != otherObject.getClass())
            {
                return false;
            }
            else
            {
                TwoWayNode otherItem = (TwoWayNode)otherObject;
                return (this.item.equalsIgnoreCase(otherItem.item));
            }
        }
        
    }    
        
    public class ExcellentIterator
    {
        private TwoWayNode position = null;
        
        public boolean hasNext()
        {
            return(position != null);
        }

        public ExcellentIterator()
        {
            position = head;
        }
        public void Restart()
        {
            position = head;
        }
        public String Next()
        {
            if(!hasNext())
            {
                throw new IllegalStateException();
            }
            String toReturn = position.item;
            position = position.next;
            return toReturn;                    
        }

        public void InsertHere(String newData)
        {
            if(position == null && head != null)
            {
                TwoWayNode temp = head;
                while(temp.next != null)
                {
                    temp = temp.next;
                }
                temp.next = new TwoWayNode(newData, temp);
            }
            else if(head == null || position.previous == null)
            {
                ExcellentLinkedList.this.AddToStart(newData);
            }
            else
            {
                TwoWayNode temp = new TwoWayNode (newData,position.previous);
                position.previous.next = temp;
                position.previous = temp;
            }
        }
        //End of Iterator
        public void Delete()
        {
            if(position == null)
            {
                throw new IllegalStateException();
            }
            else if(position.previous == null)
            {
                head = head.next;
                position = head;
            }
            else if(position.next == null)
            {
                position.previous.next = null;
                position = null;
            }
            else
            {
                position.previous.next = position.next;
                position.next.previous = position.previous;
                position = position.next;
            }
        }            
    }

    public ExcellentIterator iterator()
    {
        return new ExcellentIterator();
    }

    public ExcellentLinkedList()
    {
        head = null;
    }

    public ExcellentLinkedList(ExcellentLinkedList otherList)
    {
        if(otherList == null)
        {
            throw new NullPointerException();
        }
        if(otherList.head == null)
        {
            head = null;
        }
        else
        {
            head = copyOf(otherList.head);
        }
    }
    
    //TODO Make the new nodes get 'previous' properties
    public void AddToStart(String itemInput)
    {
        TwoWayNode newHead = new TwoWayNode(itemInput);
        
        int size=this.ListSize();
        
        if(size == 0)
        {
            //System.out.println("Size: " + size);
            tailNode = newHead;
        }
        else
        {
            head.previous = newHead;
        }
        
        newHead.next = head;
        head = newHead;
        
        /*
        The Old, Wrong way
        
        TwoWayNode oldHead = this.head;
        TwoWayNode newHead = new TwoWayNode(itemInput, head, oldHead);
        
        int size = this.ListSize();
        if(size == 0)
        {
            //System.out.println("Size: " + size);
            newHead.previous = null;
        }
        else
        {
            //System.out.println("Size: " + size);
            newHead.previous = oldHead;            
        }
        
        head = newHead;
        if(tailNode == null)
        {
            tailNode = newHead;
        }
        //System.out.println(oldPrevious);
        //newHead.previous = oldPrevious;
        //newHead.next = head.next;
        //newHead.previous = head.previous;
        */
    }
    
    public String BackwardToString()
    {        
        TwoWayNode position = tailNode;
        String builderString = "";
        //System.out.println("First previous: " + position.previous.item);
        
        while(position != null)
        {
            builderString += (position.item + "\n");
            position = position.previous;
        }        
        return builderString;
    }    
    
    public void Clear()
    {
        head = null;
    }
    
    public String toString()
    {
        TwoWayNode position = head;
        String builderString = "";
        while(position != null)
        {
            builderString += (position.item + "\n");
            position = position.next;
        }
        return builderString;
    }
    
    public int ListSize()
    {
        int count = 0;
        TwoWayNode position = head;
        while(position != null)
        {
            count ++;
            position = position.next;
        }
        return count;
    }

    //TODO: doesn't work yet/not necessary??
    public void AddToTail(String itemInput)
    {
        TwoWayNode newEntry = new TwoWayNode(itemInput);       
    }
    
    public ExcellentLinkedList clone()
    {
        try
        {
            ExcellentLinkedList copy = ((ExcellentLinkedList)super.clone());
            /*if(head == null)
            {
                copy.head = null;
            }
            else
            {
                copy.head = copyOf(head);
            }
            */
            return copy;            
        }
        catch(CloneNotSupportedException e)
        {
            return null;
        }
    }
    
    private TwoWayNode copyOf(TwoWayNode otherHead)
    {
        TwoWayNode position = otherHead;
        TwoWayNode newHead;
        TwoWayNode end = null;
        
        newHead = new TwoWayNode(position.item, position.next, position.previous);
        end = newHead;
                
        while(position.next != null)
        {
            end.next = new TwoWayNode(position.item, position.next, position.previous);
            end = end.next;
            position = position.next;
        }
        position = position.next;
        return newHead;
    }
    
    public boolean equals(Object otherObject)
    {
        if(otherObject == null)
        {
            return false;
        }
        else if(getClass() != otherObject.getClass())
        {
            return false;
        }
        else
        {
            ExcellentLinkedList otherList = (ExcellentLinkedList)otherObject;
            if(ListSize() != otherList.ListSize())
            {
                return false;
            }
            TwoWayNode position = head;
            TwoWayNode otherPosition = otherList.head;
            while(position != null)
            {
                if(!(position.item.equals(otherPosition.item)))
                {
                    return false;
                }
                position = position.next;
                otherPosition = otherPosition.next;                
            }
            return true;
        }
    }    
}

