/*
Damian Bouch 
CIT 130
Week 5
Due: October 14, 2017
 */

package bouch_week_5;

public class Bouch_Week_5 {

    public static void main(String[] args) 
    {
        //This is the test
        
        Figure[] figArray = new Figure[8];
        
        Figure rect_1 = new Rectangle(1,1,2,1,"Rect George");          
        Figure rect_2 = new Rectangle(2,2,3,1,"Rect Billy");
        Figure rect_3 = new Rectangle(5,5,2,1,"Rect Susie");
        Figure rect_4 = new Rectangle(4,4,3,2,"Rect Mary");
        Figure rect_5 = new Rectangle(10,10,5,2,"Rect Bobby");
        
        Figure circ_1 = new Circle(-1,-1,2,"Circle Sinclair");
        Figure circ_2 = new Circle(-2,-2,1,"Circle Emily");
        Figure circ_3 = new Circle(-3,-3,3,"Circle Rebecca"); 
        
        figArray[0] = rect_1;
        figArray[1] = rect_2;
        figArray[2] = rect_3;
        figArray[3] = rect_4;
        figArray[4] = rect_5;
        figArray[5] = circ_1;
        figArray[6] = circ_2;
        figArray[7] = circ_3;
        
        int numShapes = Figure.GetNumberOfShapes();
        
        for(int i = 0; i < numShapes; i++)
        {
            figArray[i].Draw();
        }
        
        for(int i = 0; i < numShapes/2; i++)
        {
            figArray[i].Erase();
        }
        
    }
    
}
