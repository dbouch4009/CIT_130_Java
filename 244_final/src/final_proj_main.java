import java.util.Arrays;

public class final_proj_main
{
    public static void main(String[] args)
    {
        System.out.println("Hello Mr Acklin");
        System.out.println("Question One: ");
        int[] myArray = {45,38,50};
        ChildObject childObject = new ChildObject(9,"Chicken",myArray,true);

        System.out.println("First: " + childObject.firstAttrInt);
        System.out.println("Second: " + childObject.secondAttrString);
        System.out.println("Third: " + childObject.thirdAttrIntArray);
        System.out.println("Fourth: " + childObject.fourthAttrBool);
        System.out.println("ToString():" + childObject.toString());
        System.out.println("Sum: \n" + childObject.sum_all_variables());

        String myString = "Beef";
        int myInt = 933;
        double myDub = 98.6;
        boolean myBool = false;

        System.out.println("Question Two: ");
        ExceptObject exceptObject = new ExceptObject();
        exceptObject.what_is_it(myString);
        exceptObject.what_is_it(myInt);
        exceptObject.what_is_it(myDub);
        exceptObject.what_is_it(myBool);
        exceptObject.what_is_it(childObject);

        ClassObject classObject = new ClassObject();
        classObject.what_is_it(myString);
        classObject.what_is_it(myInt);
        classObject.what_is_it(myDub);
        classObject.what_is_it(myBool);
        classObject.what_is_it(childObject);

        System.out.println("Question Three: ");

        String[][] myMultiArray = new String[][]
                {
                        {"Green","Duck"},
                        {"Blue","Oyster"},
                        {"Red","Wolf"},
                        {"Black","Bear"},
                        {"Pink","Pig"}
                };
        System.out.println("\nPrinting rows:");
        MultiArray.rows_columns(myMultiArray);
        System.out.println("\nPrinting columns:");
        MultiArray.columns_rows(myMultiArray);

        System.out.println("\nQuestion Four: ");
        String[] sizeArray = new String[] {"Tiny","Small","Medium","Large","Humongous"};
        DataStructures dataStructures = new DataStructures(sizeArray);
        System.out.println("SizeArray.length: " + sizeArray.length);
        dataStructures.to_stack();
        dataStructures.to_arraylist();

    }
}

