/*
Damian Bouch 
CIT 130
Week 5
Due: October 14, 2017
 */
package bouch_week_5;


public class Rectangle extends Figure 
{
    int height, width;
    
    public Rectangle()
    {
        super(0,0,"Default Rectangle");
        SetWidth(0);
        SetHeight(0);
    }
    
    public Rectangle(int xCenterInput, int yCenterInput, int widthInput, int heightInput, String nameInput)
    {
        super(xCenterInput, yCenterInput, nameInput);
        SetWidth(widthInput);
        SetHeight(heightInput);
    }
    
    public int GetHeight()
    {
        return this.height;
    }
    
    public int GetWidth()
    {
        return this.width;
    }
    
    public void SetWidth(int input)
    {
        width = input;
    }
    
    public void SetHeight(int input)
    {
        height = input;
    }
    
    public void Erase()
    {
        System.out.println("Erasing " + this.GetName());
        ReduceNumberOfShapes();
        this.ToString();
        System.out.println("Rectangle " + this.GetName() + " erased."); 
        System.out.println("");
        
    }
    
    public void Draw()
    {
        GetCenter();
        System.out.println("Rectangle " + this.GetName() + " drawn.");
        this.ToString();
        System.out.println("");       

    }
    
    public void ToString()
    {
        System.out.println(this.GetName() + " center at (" + GetX() + " " + GetY() + ")");
        System.out.println(this.GetName() + " Height: " + GetHeight() + "   Width: " + GetWidth());
        System.out.println("Total shapes: " + GetNumberOfShapes());
    }
}
