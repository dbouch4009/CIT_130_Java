import javax.swing.JFrame;

public class term_main
{
    public static void main (String[] args)
    {
        Server serverOne = new Server();
        serverOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        serverOne.StartUp();
    }

}
