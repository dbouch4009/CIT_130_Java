/*
Damian Bouch 
CIT 130
Week 5
Due: October 14, 2017
 */
package bouch_week_5;

public abstract class Figure 
{
    private int X,Y;  //Center
    private String name;
    private static int numberOfShapes = 0;
    
    public Figure()
    {
        X = 0;
        Y = 0;
        name = "defaultName";
        numberOfShapes++;
    }
    
    public Figure(int xCenterInput, int yCenterInput, String nameInput)
    {
        SetX(xCenterInput);
        SetY(yCenterInput);
        SetName(nameInput);
        numberOfShapes++;
    }
    
    public void SetX(int input)
    {
        X = input;
    }
    
    public void SetY(int input)
    {
        Y = input;
    }
            
    public void SetName(String input)
    {
        name = input;
    }
    
    public int GetX()
    {
        return X;
    }
    
    public int GetY()
    {
        return Y;
    }
    
    public String GetName()
    {
        return name;
    }
    
    public static int GetNumberOfShapes()
    {
        return numberOfShapes;
    }
    
    public static void ReduceNumberOfShapes()
    {
        numberOfShapes--;
    }
    
    public static void IncreaseNumberOfShapes()
    {
        numberOfShapes++;
    }
    
    //Will be implemented in a child classes
    public abstract void Erase();
    
    public abstract void Draw();
    
    public void GetCenter()
    {
        System.out.println("Center at: (" + GetX() + ", " + GetY() + ")");
    }
    
    public abstract void ToString();   
    
}
