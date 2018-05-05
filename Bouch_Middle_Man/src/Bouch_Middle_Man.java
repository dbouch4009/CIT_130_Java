import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
//import javax.xml.bind.DatatypeConverter;
import java.awt.event.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Bouch_Middle_Man extends JFrame
{
    private JTextField userText;
    private JTextArea chatWindow;
    private ObjectOutputStream objectOutputStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    private ObjectInputStream objectInputStream;
    private ServerSocket serverSocket;
    private Socket socketReadConnection;
    private Socket socketWriteConnection;
    private Socket tempSocket;

    public Bouch_Middle_Man()
    {
        super("Bouch Man in the Middle Server");
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
                    String write = "Bouch_Write_Client.jar";
                    String read = "Bouch_Read_Client.jar";

                    File writeFile = new File(write);
                    File readFile = new File(read);

                    write = writeFile.getAbsolutePath();
                    read = readFile.getAbsolutePath();

                    ShowMessage("\n Path: " + write);
                    ShowMessage("\n Path: " + read);

                    Runtime.getRuntime().exec("cmd /c start Bouch_Write_Client.jar");
                    Runtime.getRuntime().exec("cmd /c start Bouch_Read_Client.jar");

                    WaitForConnection();
                    SetUpStreams();
                    RunningChat();
                }catch(EOFException exc)
                {
                    ShowMessage("\n ERROR: " + exc.toString());
                }catch(Exception exc)
                {
                    ShowMessage("\n ERROR: " + exc.toString());
                } finally
                {
                    CloseConnection();
                }
            }
        }catch(IOException exc)
        {
            ShowMessage("\n ERROR: " + exc.toString());
        }
    }

    private void WaitForConnection() throws IOException
    {
        ShowMessage( "\n Waiting for a guest...");

        //tempSocket = serverSocket.accept();
        //TODO: start writer here
        socketWriteConnection = serverSocket.accept();
        ShowMessage("\n Now connected to Writer: " + socketWriteConnection.getInetAddress().getHostName() + " at " + socketWriteConnection.getLocalPort());

        //TODO: start reader here
        socketReadConnection = serverSocket.accept();
        ShowMessage("\n Now connected to Reader: " + socketReadConnection.getInetAddress().getHostName() + " at " + socketReadConnection.getLocalPort());
    }

    private void SetUpStreams() throws IOException, InterruptedException
    {
        objectOutputStream = new ObjectOutputStream(socketReadConnection.getOutputStream());
        objectOutputStream.flush();
        Thread.sleep(500);
        objectInputStream = new ObjectInputStream(socketWriteConnection.getInputStream());

        ShowMessage("\n Streams are now established.");
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
                ShowMessage("\n " + displayMessage);
            }catch(ClassNotFoundException exc)
            {
                ShowMessage("\n ERROR: " + exc.toString());
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
            //ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            //ObjectOutput objectOutput = new ObjectOutputStream(byteArrayOutputStream);
            //objectOutput.writeObject(EncryptMe(input));

            objectOutputStream.writeObject(EncryptMe(input));
            objectOutputStream.flush();
            ShowMessage("\n SERVER says: " + input);
        }catch(IOException exc)
        {
            ShowMessage("\n ERROR: + " + exc.toString());
        }
    }

    public void CloseConnection()
    {
        ShowMessage("\n Closing Connections");
        //ableToType(false);
        try
        {
            objectOutputStream.close();
            objectInputStream.close();
            socketReadConnection.close();
            socketWriteConnection.close();
        }catch(IOException exc)
        {
            ShowMessage("\n ERROR: " + exc.toString());
        }
    }

    public String EncryptMe(String input)
    {
        //try {
            //String keyString = "JavaRules99676";
            //byte[] initVector = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            //SecretKeySpec secretKeySpec = new SecretKeySpec(keyString.getBytes(), "AES");
            //IvParameterSpec ivParameterSpec = new IvParameterSpec(initVector);
        /*    byte[] keyInput = new byte[] {'0','2','3','4','5','6','7','8','9','1','2','3','4','5','6','7'};
            Key key = CreateKey(keyInput);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] encryptedBytes = Base64.getEncoder().encode(keyInput);
            String encryptedString = new String(encryptedBytes);
            ShowMessage("\n Encrypted text: " + encryptedString);
            ShowMessage("\n Length: " + encryptedBytes.length);
            return encryptedString;
        } catch (NoSuchPaddingException exc) {
            ShowMessage("ERROR: " + exc.toString());
        } catch (NoSuchAlgorithmException exc) {
            ShowMessage("ERROR: " + exc.toString());
        } catch (InvalidKeyException exc) {
            ShowMessage("ERROR: " + exc.toString());
        }
        return null;
        */

            try {
                byte[] inputBytes = input.getBytes();
                byte[] encryptionKey = "MZygpewJsCpRrfOr".getBytes();
                SecretKeySpec secretKey = new SecretKeySpec(encryptionKey, "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                byte[] messageBytes = cipher.doFinal(inputBytes);
                ShowMessage("\n Encrypted text: " + new String(messageBytes));
                String encryptedMessage = new String(messageBytes);
                String decryptedMessage = new String(DecryptMe(messageBytes));
                ShowMessage("\n Decrypted Message Test: " + decryptedMessage);
                return encryptedMessage;
            } catch (Exception exc) {
                System.out.println(exc.toString());
            }
            return null;
    }

    private byte[] convertToByteArray(Object obj)
    {
        try
        {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutput objectOutput = new ObjectOutputStream(byteArrayOutputStream);
            objectOutput.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        }catch(Exception exc)
        {
            ShowMessage("\n ERROR: " + exc.toString());
        }
        return null;
    }

    public String DecryptMe(byte[] input)
    {
        try {
            byte[] inputBytes = input;
            byte[] encryptionKey = "MZygpewJsCpRrfOr".getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(encryptionKey, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decryptedBytes = cipher.doFinal(inputBytes);
            //ShowMessage("\n Decrypted: " + new String(decryptedBytes));
            return new String(decryptedBytes);

        }catch(NoSuchPaddingException exc)
        {
            ShowMessage("\n ERROR: " + exc.toString());
        }
        catch(NoSuchAlgorithmException exc)
        {
            ShowMessage("\n ERROR: " + exc.toString());
        }catch(InvalidKeyException exc)
        {
            ShowMessage("\n ERROR: " + exc.toString());
        }catch(BadPaddingException exc)
        {
            ShowMessage("\n ERROR: " + exc.toString());
        }catch(IllegalBlockSizeException exc)
        {
            ShowMessage("\n ERROR: " + exc.toString());
        }
        /*
        try
        {
            //String keyString = "JavaRules99676";
            //byte[] initVector = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            //IvParameterSpec initializationVector = new IvParameterSpec(initVector);
            byte[] keyInput = new byte[] {'0','2','3','4','5','6','7','8','9','1','2','3','4','5','6','7'};
            Key myKey = CreateKey(keyInput);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, myKey);

            byte[] decryptedOne = Base64.getDecoder().decode(input);
            byte[] decryptedValue = cipher.doFinal(decryptedOne);

            return new String(decryptedValue);

        } catch (NoSuchPaddingException exc) {
            ShowMessage("ERROR: " + exc.toString());
        } catch (NoSuchAlgorithmException exc) {
            ShowMessage("ERROR: " + exc.toString());
        } catch (InvalidKeyException exc) {
            ShowMessage("ERROR: " + exc.toString());
        } catch (BadPaddingException exc) {
            ShowMessage("ERROR: " + exc.toString());
        } catch (IllegalBlockSizeException exc) {
            ShowMessage("ERROR: " + exc.toString());
        }
        return null;
        */
        return null;
    }


    public String DecryptMe(String input) {
        try {
            byte[] inputBytes = input.getBytes();
            byte[] encryptionKey = "MZygpewJsCpRrfOr".getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(encryptionKey, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decryptedBytes = cipher.doFinal(inputBytes);
            ShowMessage("\n Decrypted: " + new String(decryptedBytes));
            return new String(decryptedBytes);

        } catch (NoSuchPaddingException exc) {
            ShowMessage("\n ERROR: " + exc.toString());
        } catch (NoSuchAlgorithmException exc) {
            ShowMessage("\n ERROR: " + exc.toString());
        } catch (InvalidKeyException exc) {
            ShowMessage("\n ERROR: " + exc.toString());
        } catch (BadPaddingException exc) {
            ShowMessage("\n ERROR: " + exc.toString());
        } catch (IllegalBlockSizeException exc) {
            ShowMessage("\n ERROR: " + exc.toString());
        }
        return null;
    }
}

