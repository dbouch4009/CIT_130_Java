import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

public class Write_Client extends JFrame
{
    private JTextField userText;
    private JTextArea chatWindow;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private String displayMessage = "";
    private String ServerAddress;
    private Socket socketConnection;
    private int portNumber;

    public Write_Client(String input, int portInput)
    {
        super("Bouch Term Project Write Client");
        ServerAddress = input;
        portNumber = portInput;
        userText = new JTextField();
        //userText.setEditable(false);
        userText.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try
                        {
                            SendMessage(e.getActionCommand());
                            userText.setText("");
                        }catch(IOException exc)
                        {
                            ShowMessage("\n ERROR: " + exc.toString());
                        }
                    }
                }
        );
        add(userText, BorderLayout.NORTH);
        chatWindow = new JTextArea();
        add(new JScrollPane(chatWindow));
        setSize(400,250);
        setVisible(true);
    }

    public void StartUp()
    {
        try
        {
            ConnectToServer();
            SetUpStreams();
            RunningChat();
        }catch(EOFException exc)
        {
            ShowMessage("\n Connection terminated");
        }catch(IOException exc)
        {
            ShowMessage("\n ERROR: " + exc.toString());
        } finally
        {
            CloseConnection();
        }
    }

    public void ConnectToServer() throws IOException
    {
        ShowMessage("\n Connecting... ");
        socketConnection = new Socket(InetAddress.getByName(ServerAddress), 9999);
        ShowMessage("\n Connection established for: " + socketConnection.getInetAddress().getHostName());
    }

    private void SetUpStreams() throws IOException
    {
        objectOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
        objectOutputStream.flush();
        objectInputStream = new ObjectInputStream(socketConnection.getInputStream());
        ShowMessage("\n Streams established");
    }

    private void RunningChat() throws IOException
    {
        try {
            //ableToType(true);
            do {
                displayMessage = (String) objectInputStream.readObject();
                ShowMessage("\n " + displayMessage);
            } while (!displayMessage.toUpperCase().contains("END"));
        }catch(ClassNotFoundException exc)
        {
            ShowMessage("\n ERROR: bad object");
        }
    }

    private void CloseConnection()
    {
        ShowMessage("\n Closing connection...");
        //ableToType(false);
        try
        {
            objectOutputStream.close();
            objectInputStream.close();
            socketConnection.close();
            ShowMessage("\n Finished");
        }catch(IOException exc)
        {
            ShowMessage("\n ERROR: " + exc.toString());
        }
    }

    private void SendMessage(String input) throws IOException
    {
        try
        {
            objectOutputStream.writeObject("\n CLIENT says: " + input);
            objectOutputStream.flush();
            ShowMessage("\n CLIENT SAYS: " + input);
        }catch(IOException exc)
        {
            chatWindow.append("\n ERROR: " + exc.toString());
        }
    }

    private void ShowMessage(String input)
    {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        chatWindow.append(input);
                    }
                }
        );

    }

}

