/*
Damian Bouch 
CIT 130
Week 5
Due: October 14, 2017
 */
package bouch_week_5;


public class Circle extends Figure
{
    int radius;
    
    public Circle()
    {
        super(0,0,"Default Circle");
        radius = 0;
    }
    
    public Circle(int xCenterInput, int yCenterInput, int radiusInput, String nameInput)
    {
        super(xCenterInput, yCenterInput, nameInput);
        radius = radiusInput;               
    }
    
    public int GetRadius()
    {
        return this.radius;
    }           
    
    public void SetRadius(int radiusInput)
    {
        radius = radiusInput;
    }
    
    public void Draw()
    {
        GetCenter();
        System.out.println("Circle " + this.GetName() + " drawn.");
        this.ToString();
        System.out.println("");        
    }
    
    public void Erase()
    {
        System.out.println("Erasing " + this.GetName());
        ReduceNumberOfShapes();
        this.ToString();
        System.out.println("Circle " + this.GetName() + " Erased.");
        System.out.println("");

    }
    
    public void ToString()
    {
        System.out.println(this.GetName() + " drawn at (" + GetX() + ", " + GetY() + ")");
        System.out.println(this.GetName() + " has a radius of " + this.radius);
        System.out.println("Total shapes: " + GetNumberOfShapes());

    }
    
}
