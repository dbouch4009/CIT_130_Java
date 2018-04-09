public class InputFormatException extends Exception
{
    public InputFormatException() {super ("Invalid format");}
    public InputFormatException(String msg){
        super(msg);
    }
}
