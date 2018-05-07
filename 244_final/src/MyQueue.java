public class MyQueue
{
    private class Node
    {
        private String item;
        private Node link;

        public Node()
        {
            item = null;
            link = null;
        }
        public Node(String itemInput, Node linkInput)
        {
            this.item = itemInput;
            this.link = linkInput;
        }
    }

    private Node frontNode;
    private Node backNode;

    public MyQueue()
    {
        frontNode = null;
        backNode = null;
    }

    public void AddToBack(String itemInput)
    {
        Node newEntry = new Node(itemInput, null);
        if(frontNode == null)
        {
            backNode = newEntry;
            frontNode = backNode;
        }
        else
        {
            backNode.link = newEntry;
            backNode = backNode.link;
        }
    }

    public boolean IsEmpty()
    {
        return (frontNode == null);
    }

    public void Clear()
    {
        frontNode = null;
        backNode = null;
    }

    public boolean RemoveFront()
    {
        if(frontNode != null)
        {
            System.out.println("Removing from queue: " + frontNode.item);
            frontNode = frontNode.link;
            return true;
        }
        else
        {
            return false;
        }
    }

}
