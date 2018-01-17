/*
Damian Bouch 
CIT 130
Week 4
Due: October 7, 2017
 */

//package bouch_week_4;

public class WrapperShallow 
{
    private int[] a;
    
    public WrapperShallow()
    {
        a = new int[]{25,48,98};        
    }
    
    public WrapperShallow(WrapperShallow ws)
    {
        a = ws.a;
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
    
    public static void ToString(WrapperShallow ws)
    {
        for(int i = 0; i < 3; i++)
        {
            System.out.println(ws.a[i]);
        }
    }
    
    public static boolean Equals(WrapperShallow first, WrapperShallow second)
    {
        return ((first.a[0] == second.a[0]) && (first.a[1] == second.a[1]) && (first.a[2] == second.a[2]));
    }
    
}
