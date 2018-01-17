/*
Binary Search
Author: Damian Bouch
CIT 130 Z02B
Due: November 11, 2017
 */
//package bouch_binary_search_2;

public class Student implements Comparable
{
    private String studName;
    private Integer gradeAverage;
    
    public Student()
    {
        
    }
    
    public Student(String nameIn, int gradeIn)
    {
        studName = nameIn;
        gradeAverage = gradeIn;
    }
    
    public String GetName()
    {
        return this.studName;
    }
    
    public int GetGrade()
    {
        return this.gradeAverage;
    }
    
    public String toString()
    {
        return ("Student " + this.GetName());
    }
       
    public int compareTo(Object obj)
    {
        Student s1 = (Student)obj;
        if(this.gradeAverage < s1.gradeAverage)
        {
            return -1;
        }
        else if(this.gradeAverage > s1.gradeAverage)
        {
            return 1;
        }
        else
            return 0;        
    }
}
