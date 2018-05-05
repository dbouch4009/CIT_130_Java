import java.io.IOException;
import java.lang.IndexOutOfBoundsException;
import java.lang.NullPointerException;
import java.lang.Exception;
import java.lang.IllegalArgumentException;

class ExceptObject{
    public <T> String what_is_it(T arg) {
        try{
            if(arg instanceof Integer){
                throw new IndexOutOfBoundsException("This is an integer");
            } else if(arg instanceof Double){
                throw new NullPointerException("This is a double");
            } else if(arg instanceof String){
                throw new IOException("This is a string");
            } else if(arg instanceof Boolean){
                throw new IllegalArgumentException("This is a boolean");
            } else {
                throw new Exception("I do not know what this is");
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
            return "Exception caught";
        }
    }
}

/*
class ClassObject
{
    public <T> String what_is_it(T arg){
        try{

            if(arg instanceof Integer){
                throw new ClassObjectException("1");
            } else if(arg instanceof Double){
                throw new ClassObjectException("2");
            } else if(arg instanceof String){
                throw new ClassObjectException("3");
            } else if(arg instanceof Boolean){
                throw new ClassObjectException("4");
            } else {
                throw new ClassObjectException("-1");
            }
        } catch(Exception e){
            return e.toString();
        }
    }
}
*/


// create custom Exception



