
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

class EchoServer extends Thread
{
    private ObjectOutputStream objectOutputStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    private ObjectInputStream objectInputStream;
    private ServerSocket serverSocket;
    private Socket socketReadConnection;
    private Socket socketWriteConnection;
    private Socket tempSocket;

    EchoServer() throws IOException
    {
        this.serverSocket = new ServerSocket(50000);
    }

    /*
    public void run() {
        System.out.println("    EchoServer");
        try{
            while(true) {

                break;
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    */

    public void StartUp()
    {
        try
        {
            serverSocket = new ServerSocket(9999, 10);
            while(true)
            {
                try
                {
                    WaitForConnection();
                    SetUpStreams();
                    RunningChat();
                }catch(EOFException exc)
                {
                    System.out.println(("\n ERROR: " + exc.toString()));
                }catch(Exception exc)
                {
                    System.out.println(("\n ERROR: " + exc.toString()));
                } finally
                {
                    CloseConnection();
                }
            }
        }catch(IOException exc)
        {
            System.out.println(("\n ERROR: " + exc.toString()));
        }
    }

    private void WaitForConnection() throws IOException
    {
        System.out.println(( "\n Waiting for a guest..."));

        //tempSocket = serverSocket.accept();
        //TODO: start writer here
        socketWriteConnection = serverSocket.accept();
        System.out.println(("\n Now connected to Writer: " + socketWriteConnection.getInetAddress().getHostName() + " at " + socketWriteConnection.getLocalPort()));

        //TODO: start reader here
        socketReadConnection = serverSocket.accept();
        System.out.println(("\n Now connected to Reader: " + socketReadConnection.getInetAddress().getHostName() + " at " + socketReadConnection.getLocalPort()));
    }

    private void SetUpStreams() throws IOException, InterruptedException
    {
        objectOutputStream = new ObjectOutputStream(socketReadConnection.getOutputStream());
        objectOutputStream.flush();
        Thread.sleep(500);
        objectInputStream = new ObjectInputStream(socketWriteConnection.getInputStream());

        System.out.println(("\n Streams are now established."));
    }

    private void SendMessage(String input)
    {
        try
        {
            //ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            //ObjectOutput objectOutput = new ObjectOutputStream(byteArrayOutputStream);
            //objectOutput.writeObject(EncryptMe(input));

            //objectOutputStream.writeObject(EncryptMe(input));
            objectOutputStream.flush();
            System.out.println(("\n SERVER says: " + input));
        }catch(IOException exc)
        {
            System.out.println(("\n ERROR: + " + exc.toString()));
        }
    }

    public void CloseConnection()
    {
        System.out.println(("\n Closing Connections"));
        //ableToType(false);
        try
        {
            objectOutputStream.close();
            objectInputStream.close();
            socketReadConnection.close();
            socketWriteConnection.close();
        }catch(IOException exc)
        {
            System.out.println(("\n ERROR: " + exc.toString()));
        }
    }

    private void RunningChat() throws IOException
    {
        String displayMessage = "\n You have been connected! ";
        //ableToType(true);
        do {
            try
            {
                displayMessage = (String) objectInputStream.readObject();
                SendMessage(displayMessage);
                System.out.println(("\n " + displayMessage));
            }catch(ClassNotFoundException exc)
            {
                System.out.println(("\n ERROR: " + exc.toString()));
            }
        }while(!displayMessage.toUpperCase().contains("END"));
    }
}