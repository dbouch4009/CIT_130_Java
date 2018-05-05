import java.util.Arrays;

class ChildObject extends ParentObject implements InterfaceClass
{
    boolean fourthAttrBool;

    public ChildObject()
    {
        super();
        fourthAttrBool = false;
    }

    public ChildObject(int a1, String a2, int[] a3, boolean a4)
    {
        super(a1,a2,a3);
        this.fourthAttrBool = a4;
    }

    public int sum_all_variables() {
        int arraySum = 0;
        for(int i = 0; i < this.thirdAttrIntArray.length; i++)
        {
            arraySum += this.thirdAttrIntArray[i];
        }
        return this.firstAttrInt + arraySum;
    }

    public String toString()
    {
        return super.toString() + "\n Arg 4: " + ((this.fourthAttrBool) ? "True" : "False");
    }

}
