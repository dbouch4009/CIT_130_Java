import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

public class Server extends JFrame
{
    private JTextField userText;
    private JTextArea chatWindow;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private ServerSocket serverSocket;
    private Socket socketConnection;

    public Server()
    {
        super("Bouch Term Project Server");
        userText = new JTextField();
        //userText.setEditable(false);
        userText.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                        SendMessage(evt.getActionCommand());
                        userText.setText("  ");
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
                    ShowMessage("ERROR: " + exc.toString());
                } finally
                {
                    CloseConnection();
                }
            }
        }catch(IOException exc)
        {
            ShowMessage("ERROR: " + exc.toString());
        }
    }

    private void WaitForConnection() throws IOException
    {
        ShowMessage("Waiting for a guest...");
        socketConnection = serverSocket.accept();
        ShowMessage("Now connected to: " + socketConnection.getInetAddress().getHostName());
    }

    private void SetUpStreams() throws IOException
    {
        objectOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
        objectOutputStream.flush();

        objectInputStream = new ObjectInputStream(socketConnection.getInputStream());

        ShowMessage("\n Streams are now established.");
    }

    private void RunningChat() throws IOException
    {
        String displayMessage = "You have been connected! ";
        SendMessage(displayMessage);
        //ableToType(true);
        do {
            try
            {
                displayMessage = (String) objectInputStream.readObject();
                ShowMessage("\n " + displayMessage);
            }catch(ClassNotFoundException exc)
            {
                ShowMessage("ERROR: " + exc.toString());
            }
        }while(!displayMessage.toUpperCase().contains("END"));
    }

    private void ShowMessage(String input)
    {
        SwingUtilities.invokeLater(
                new Runnable()
                {
                    public void run()
                    {
                        chatWindow.append(input);
                    }
                }
        );
    }

    private void SendMessage(String input)
    {
        try
        {
            objectOutputStream.writeObject("SERVER says: " + input);
            objectOutputStream.flush();
            ShowMessage("\n SERVER says: " + input);
        }catch(IOException exc)
        {
            ShowMessage("ERROR: + " + exc.toString());
        }
    }

    public void CloseConnection()
    {
        ShowMessage("\n Closeingg Connections");
        //ableToType(false);
        try
        {
            objectOutputStream.close();
            objectInputStream.close();
            socketConnection.close();
        }catch(IOException exc)
        {
            ShowMessage("ERROR: " + exc.toString());
        }
    }

}
