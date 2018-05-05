import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class WriteSocket extends ParentSocket
{
    private String message;
    private String publicKey;

    public void Run()
    {
        //reads message file, create message objects, connects to server and sends
        //message object as XML string to server
        try
        {
            Socket clientSocket = new Socket(this.GetServerAddress(), this.GetPortNumber());
            OutputStream outputStreamWriterToMiddleman = clientSocket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStreamWriterToMiddleman);
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

    public void GetKey(Socket socketInput)
    {
        //notifies the server that it is the writeSocket via OutputStream/DataOutputStream/WriteUTF
        //sets publicKey with InputStream/DataInputStream/ReadUTF
    }

    public ArrayList GetMessages()
    {
        //reads messages inside of text file, creates message object ID
        ArrayList<String> messageList = new ArrayList<String>();
        return messageList;
    }

    public void WriteMessages(ArrayList messagesInput)
    {
        //writes message to console using DisplayMessage before encryption, performs encryption,
        //sends message to server as XML String

    }
}
