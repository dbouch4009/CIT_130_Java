public class Message
{
    private int state; // 1: Write Client, 2: Server, 3: ReadClient
    private String messageContent;
    private int id; // id number of the message
    private boolean isEncrypted; //false is plain text, true is encrypted text

    public int GetState()
    {
        return this.state;
    }

    public void SetState(int input)
    {
        this.state = input;
    }

    public String GetMessageContent()
    {
        return this.messageContent;
    }

    public void SetMessageContent(String input)
    {
        this.messageContent = input;
    }

    public int GetId()
    {
        return this.id;
    }

    public void SetId(int input)
    {
        this.id = input;
    }

    public boolean GetIsEncrypted()
    {
        return this.isEncrypted;
    }

    public void SetIsEncrypted(boolean input)
    {
        this.isEncrypted = input;
    }

    public String ToXML()
    {
        // returns message in XML form
        return "-1";
    }

    public void FromXML(String xmlInput)
    {
        // uses XML parsing to set local attributes on message object
    }

}
