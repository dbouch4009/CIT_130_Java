import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;


class DataStructures
{
    String[] array;
    int length;

    public DataStructures(String[] input)
    {
        this.array = input;
        this.length = input.length;
    }

    public void to_stack()
    {
        Stack stack = new Stack();

        for(int i = 0; i < this.length; i++)
        {
            System.out.println("Pushed: " + stack.push(this.array[i]));
        }

        while(!stack.isEmpty())
        {
            System.out.println("Popped: " + stack.pop());
        }
    }
    public void to_queue()
    {

    }
    public void to_arraylist(){
        ArrayList arrayList = new ArrayList();
        System.out.println("\nArrayList: ");
        for(int i = 0; i < this.length; i++)
        {
            System.out.println("Added: " + (this.array[i]));
            arrayList.add(this.array[i]);
        }

        System.out.println("ArrayList: \n" + arrayList.toString());

    }
    public void to_hashnap(String[] key, String[] value){
        // create HashMap with array key being the key for the corresponding index of value key[x] -> value[x]
        // print key value pair
    }
}