import java.net.*;

public class ManInTheMiddle
{
    public static void main(String[] args)
    {
        //main man in the middle class

        try
        {
            System.out.println("Welcome to Man in the Middle Secure Messaging");
            Thread t = new Server();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
