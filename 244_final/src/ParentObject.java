import java.util.Arrays;

abstract class ParentObject
{
    protected int firstAttrInt;
    protected String secondAttrString;
    protected int[] thirdAttrIntArray;

    public ParentObject()
    {

    }

    public ParentObject(int a1, String a2, int[] a3)
    {
        this.firstAttrInt = a1;
        this.secondAttrString = a2;
        this.thirdAttrIntArray = a3;
    }

    public int GetFirstAttrInt()
    {
        return this.firstAttrInt;
    }

    public void SetFirstAttrInt(int input)
    {
        this.firstAttrInt = input;
    }

    public String GetSecondAttrString()
    {
        return this.secondAttrString;
    }

    public void SetSecondAttrString(String input)
    {
        this.secondAttrString = input;
    }

    public int[] GetThirdAttrIntArray()
    {
        return this.thirdAttrIntArray;
    }

    public void SetThirdAttrIntArray(int[] input)
    {
        this.thirdAttrIntArray = input;
    }

    public String toString()
    {
        return "\nFirst Arg: " + this.firstAttrInt + "\n Second Arg: " + this.secondAttrString + "\n Third Arg: " + Arrays.toString(this.thirdAttrIntArray);
    }
}
