import javax.xml.crypto.Data;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ReadSocket extends ParentSocket
{
    private String socketName; // Read, Write, or Server
    private int portNumber;
    private String serverAddress;

    public void Run()
    {
        //reads message file, create message objects, connects to server and sends
        //message object as XML string to server
        try
        {
            Socket clientSocket = new Socket(this.GetServerAddress(), this.GetPortNumber());
            OutputStream outputStreamReader = clientSocket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStreamReader);
            dataOutputStream.writeUTF(this.GetSocketName());
        }
        catch(Exception exc)
        {
            System.out.println("Exception thrown: " + exc.toString());
        }
    }

    public void DisplayMessage()
    {
        //Writes message to console, if console is busy then the thread is added to a data structure
        //and waits for console to become available
    }

    public void SendKey(Socket socketInput)
    {
        //sends public key to WriteSocket via OutputStream/DataOutputStream/WriteUTF
    }

    public Message ReadMessage(Socket socketInput)
    {
        //Receives messages from writes, creates message object, calls displaymessage()
        // decrypts, calls display message and returns message object
        Message thisMessage = new Message();
        return thisMessage;
    }

    public void EndAllThreads()
    {
        //Will end all threads
    }

    public Message Decrypt(Message encryptedInput)
    {
        //will perform decryption
        return encryptedInput;
    }
}
