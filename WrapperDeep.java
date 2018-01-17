/*
Damian Bouch 
CIT 130
Week 4
Due: October 7, 2017
 */

//package bouch_week_4;

public class WrapperDeep 
{
    private int[] a;
    
    public WrapperDeep()
    {
        a = new int[]{101,125,179};
    }
    
    public WrapperDeep(WrapperDeep wd)
    {
        a = new int[3];
        for(int i = 0; i < 3; i++)
        {
            a[i] = wd.a[i];
        }
    }
    
        public int[] GetWrapper()
    {
        return a;
    }
    
    public void SetWrapper(int newNumber)
    {           
        for(int i = 0;i < 3; i++)
        {
            this.a[i] = newNumber + i;
        }
    }
    
    public static void ToString(WrapperDeep ws)
    {
        for(int i = 0; i < 3; i++)
        {
            System.out.println(ws.a[i]);
        }
    }
    
    public static boolean Equals(WrapperDeep first, WrapperDeep second)
    {
        return ((first.a[0] == second.a[0]) && (first.a[1] == second.a[1]) && (first.a[2] == second.a[2]));
    }
}
