import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.util.Base64;
//import javax.xml.bind.DatatypeConverter;

public class Bouch_Read_Client extends JFrame
{
    private JTextField userText;
    private JTextArea chatWindow;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private String displayMessage = "";
    private String ServerAddress;
    private Socket socketConnection;
    private int portNumber;

    public Bouch_Read_Client(String input, int portInput)
    {
        super("Bouch Term Project Read Client");
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
                            ShowMessage("\nERROR: " + exc.toString());
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
                Object obj = objectInputStream.readObject();
                ShowMessage("\n object received");
                //byte[] byteData = Serialization
                displayMessage = new String(obj.toString());
                ShowMessage("\n displayMessage created: " + displayMessage);
                ShowMessage("\n Length: " + displayMessage.length());
                String decryptedMessage = DecryptMe(displayMessage);
                ShowMessage("\n decryptMe occurred");
                ShowMessage("\n Decrypted: " + decryptedMessage);
            } while (!displayMessage.toUpperCase().contains("END"));
        }catch(Exception exc)
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
            ShowMessage("\nERROR: " + exc.toString());
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

    public String DecryptMe(byte[] input)
    {
        try {
            byte[] inputBytes = input;
            byte[] encryptionKey = "MZygpewJsCpRrfOr".getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(encryptionKey, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decryptedBytes = cipher.doFinal(inputBytes);
            ShowMessage("\n Decrypted: " + new String(decryptedBytes));
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

    public String DecryptMe(String input)
    {
        try {
            byte[] inputBytes = input.getBytes();
            byte[] encryptionKey = "MZygpewJsCpRrfOr".getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(encryptionKey, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decryptedBytes = cipher.doFinal(inputBytes);
            String decryptedString = new String(decryptedBytes);
            ShowMessage("\n Decrypted: " + new String(decryptedBytes));
            return decryptedString;

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

    private Key CreateKey(byte[] keyIn)
    {
        Key myKey = new SecretKeySpec(keyIn,"AES");
        return myKey;
    }
}


