import javax.swing.JFrame;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Write_Main
{
    public static void main(String[] args)
    {
        Write_Client client = new Write_Client("127.0.0.1",9999);
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream("message.txt");
        }catch(FileNotFoundException exc)
        {
            exc.printStackTrace();
        }

        client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.StartUp();
    }
}
