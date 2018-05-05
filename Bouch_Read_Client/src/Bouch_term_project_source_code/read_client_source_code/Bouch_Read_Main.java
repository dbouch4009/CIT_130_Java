import javax.swing.JFrame;

public class Bouch_Read_Main
{
    public static void main(String[] args)
    {
        Bouch_Read_Client client = new Bouch_Read_Client("127.0.0.1",8888);
        client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.StartUp();
    }
}

