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
        //See MyQueue class
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
    public void to_hashnap(String[] inputArray)
    {
        HashMap<Integer,String> hashMap = new HashMap<Integer, String>();

        for(int i = 0; i < inputArray.length; i++)
        {
            System.out.println("Adding to HashMap: " + inputArray[i]);
            hashMap.put(i,inputArray[i]);
        }

        for(int i = 0; i < hashMap.size(); i++)
        {
            String searchValue = inputArray[i];
            //System.out.println(hashMap.containsValue(searchValue));
            System.out.println("Searching From Input Array For: " + searchValue);
            if(hashMap.containsValue(searchValue))
            {
                String name = hashMap.get(i);
                System.out.println("Found in HashMap: " + name);
            }
            else
            {
                System.out.println("Try Again");
            }
        }

        // create HashMap with array key being the key for the corresponding index of value key[x] -> value[x]
        // print key value pair
    }
}