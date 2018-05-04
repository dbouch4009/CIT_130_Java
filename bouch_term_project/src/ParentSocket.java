public abstract class ParentSocket extends Thread
{
    private String socketName; // Read, Write, or Server
    private int portNumber;
    private String serverAddress;

    abstract void Run();
    abstract void DisplayMessage();

    public String GetServerAddress()
    {
        return this.serverAddress;
    }

    public String GetSocketName()
    {
        return this.socketName;
    }

    public int GetPortNumber()
    {
        return this.portNumber;
    }

    public void SetSocketName(String socketNameIn)
    {
        this.socketName = socketNameIn;
    }

    public void SetServerAddress(String addressIn)
    {
        this.serverAddress = addressIn;
    }

    public void SetPortNumber(int portNumberIn)
    {
        this.portNumber = portNumberIn;
    }

}
