import java.io.EOFException;
import java.net.Socket;
import java.net.*;

public class ServerSocket extends ParentSocket
{
    private String socketName; // Read, Write, or Server
    private int portNumber;
    private String serverAddress;
    private String message;
    private String publicKey;
    private ServerSocket serverSocket;

    public void Run()
    {
        //reads message file, create message objects, connects to server and sends
        //message object as XML string to server
        serverSocket = new ServerSocket();
        while(true)
        {
            try
            {
                java.net.ServerSocket serverSocket = new java.net.ServerSocket();
                Socket readClient = serverSocket.accept();
                Socket writeClient = serverSocket.accept();

                WaitingForConnection();
            }
            catch(Exception exc)
            {
                System.out.print(exc);
            }
        }
    }

    public void WaitingForConnection()
    {
        System.out.println("Waiting For Connection...");

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

    public Message Encrypt(Message notEncryptedMessage)
    {
        //Will perform encryption
        return notEncryptedMessage;
    }

    public Message Decrypt(Message encryptedInput)
    {
        //will perform decryption
        return encryptedInput;
    }
}
