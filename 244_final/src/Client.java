import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.io.*;
import java.util.Scanner;

class Client extends Thread
{
    private String msg;
    public Client(String msg)
    {
        this.msg = msg;
    }

    private Socket socketConnection;
    private String ServerAddress;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private String displayMessage = "";
    private int portNumber;


    public void run()
    {
        try
        {
            System.out.println("Connecting to 127.0.0.1 on port 50000");
            Socket client = new Socket("127.0.0.1", 50000);

            ConnectToServer();
            SetUpStreams();
            SendMessage("From one instance to another");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    public void ConnectToServer() throws IOException
    {
        socketConnection = new Socket(InetAddress.getByName(ServerAddress), 9999);
        System.out.println(("\n Connection established for: " + socketConnection.getInetAddress().getHostName()));
    }
    private void SetUpStreams() throws IOException
    {
        objectOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
        objectOutputStream.flush();
        objectInputStream = new ObjectInputStream(socketConnection.getInputStream());
        System.out.println(("\n Streams established"));
    }
    private void SendMessage(String input) throws IOException
    {
        try
        {
            objectOutputStream.writeObject("\n CLIENT says: " + input);
            objectOutputStream.flush();
            System.out.println(("\n CLIENT SAYS: " + input));
        }catch(IOException exc)
        {
            System.out.println(("\n ERROR: " + exc.toString()));
        }
    }
}