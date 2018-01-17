/*
Damian Bouch
CIT 130 Week 10
Doubly Linked List
Due: December 2, 2017
 */
//package bouch_week_10;

public class DamianLinkedList<T extends PubliclyCloneable> implements PubliclyCloneable
{
    //Node<T> is an inner class
    private class Node<T>
    {
        private T data;
        private Node<T> link;

        public Node()
        {
            data = null;
            link = null;
        }

        public Node(T newData, Node<T> linkValue)
        {
            data = newData;
            link = linkValue;
        }   
    }
    
    private Node<T> head;
    
    public DamianLinkedList()
    {
        head = null;
    }
    
    public DamianLinkedList (DamianLinkedList<T> otherList)
    {
        if (otherList == null)
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
    
    public DamianLinkedList<T> clone()
    {
        try
        {
            DamianLinkedList<T> copy = ((DamianLinkedList<T>)super.clone());
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

    
    public void AddToStart(T itemData)
    {
        head = new Node<T>(itemData, head);
    }
    
    public boolean IsHeadNodeDeleted()
    {
        if(head != null)
        {
            head = head.link;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int ListSize()
    {
        int count = 0;
        Node<T> position = head;
        while(position != null)
        {
            count ++;
            position = position.link;
        }
        return count;
    }
    
    public boolean Contains(T item)
    {
        return (Find(item) != null);
    }
    
    private Node<T> Find(T targetItem)
    {
        Node<T> position = head;
        T itemAtPosition;
        while(position != null)
        {
            itemAtPosition = position.data;
            if(itemAtPosition.equals(targetItem))
            {
                //if target item is found
                return position;
            }
            position = position.link;
        }
        //if target is not found
        return null;
    }
    
    public T FindData(T targetItem)
    {
        return Find(targetItem).data;
    }
    
    public String toString()
    {
        Node<T> position = head;
        String builderString = "";
        while(position != null)
        {
            builderString += (position.data + System.lineSeparator());
            position = position.link;
        }
        return builderString;
    }
    
    public boolean IsEmpty()
    {
        return (head == null);
    }
    
    //Straight up prevents a Node from being accessed
    public void ClearPosition()
    {
        head = null;
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
            DamianLinkedList<T> otherList = (DamianLinkedList<T>)otherObject;
            if(ListSize() != otherList.ListSize())
            {
                return false;
            }
            Node<T> position = head;
            Node<T> otherPosition = otherList.head;
            while(position != null)
            {
                if(!(position.data.equals(otherPosition.data)))
                {
                    return false;
                }
                position = position.link;
                otherPosition = otherPosition.link;
            }
            return true;
        }        
    }
    
    //deep copy creator
    private Node<T> copyOf(Node<T> otherHead)
    {
        Node<T> position = otherHead;
        Node<T> newHead;
        Node<T> end = null;
        
        newHead = new Node<T>((T) (position.data).clone(), null);
        end = newHead;
        
        position = position.link;
        while(position != null)
        {
            end.link = new Node<T>((T)(position.data).clone(), null);
            end = end.link;
            position = position.link;
        }
        return newHead;
    }
}
