/*
Binary Search
Author: Damian Bouch
CIT 130 Z02B
Due: November 11, 2017
 */
//package bouch_binary_search_2;

import java.util.ArrayList;

public class Bouch_binary_search_2 {

    public static void main(String[] args) 
    {
        Student studentOne = new Student("James",75);
        Student studentTwo = new Student("Mary",82);
        Student studentThree = new Student("Bobbie",88);
        Student studentFour = new Student("Emily",92);
        Student studentFive = new Student("Joey",95);
        Student studentLeftOut = new Student("Jimbob",100);
        
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(studentOne);
        studentList.add(studentTwo);
        studentList.add(studentThree);
        studentList.add(studentFour);
        studentList.add(studentFive);
        
        SearchMethods<ArrayList, Student> searchMethods = new SearchMethods<ArrayList, Student>();
        
        Student testStudent = studentLeftOut;
        int studResult = searchMethods.BinarySearch(studentList.toArray(new Student[studentList.size()]), testStudent);
        
        if(studResult == 0)
        {
            System.out.println(": " + testStudent.GetName());
        }
        else
        {
            System.out.println(testStudent.GetName() + " not found");
        }
        
        testStudent = studentOne;
        studResult = searchMethods.BinarySearch(studentList.toArray(new Student[studentList.size()]), testStudent);
        
        if(studResult == 0)
        {
            System.out.println(": " + testStudent.GetName());
        }
        else
        {
            System.out.println(testStudent.GetName() + " not found");
        }        
        
        testStudent = studentThree;
        studResult = searchMethods.BinarySearch(studentList.toArray(new Student[studentList.size()]), testStudent);
        
        if(studResult == 0)
        {
            System.out.println(": " + testStudent.GetName());
        }
        else
        {
            System.out.println(testStudent.GetName() + " not found");
        }        
        
        //old methods
        //searchMethods.BinarySearch(studentList.toArray(new Student[studentList.size()]), studentOne);  //Should print that it was found at index 0
        //searchMethods.BinarySearch(studentList.toArray(new Student[studentList.size()]), studentLeftOut); 
        
        //Starting work on second type
        System.out.println();
        
        Stocks stockOne = new Stocks("Big Shops, Inc",46.2);
        Stocks stockTwo = new Stocks("Portfolio Builders",74.5);
        Stocks stockThree = new Stocks("Duck Calls R Us",78.45);
        Stocks stockFour = new Stocks("Master Java Generics, Inc",89);
        Stocks stockFive = new Stocks("Book Buyers Unlimited",100.26);
        Stocks stockLeftOut = new Stocks("Shrubcutters",126.2);
        
        ArrayList<Stocks> stockList = new ArrayList<Stocks>();
        stockList.add(stockOne);
        stockList.add(stockTwo);
        stockList.add(stockThree);
        stockList.add(stockFour);
        stockList.add(stockFive);       
       
        SearchMethods<ArrayList, Stocks> stockSearch = new SearchMethods<ArrayList, Stocks>();        
        
        Stocks testStock = stockOne;
        int stockResult = stockSearch.BinarySearch(stockList.toArray(new Stocks[stockList.size()]), testStock);
        
        if(stockResult == 0)
        {
            System.out.println(": " + testStock.GetName());
        }
        else
        {
            System.out.println(testStock.GetName() + " not found");
        }
        
        testStock = stockFour;
        stockResult = stockSearch.BinarySearch(stockList.toArray(new Stocks[stockList.size()]), testStock);
        
        if(stockResult == 0)
        {
            System.out.println(": " + testStock.GetName());
        }
        else
        {
            System.out.println(testStock.GetName() + " not found");
        }
        
        testStock = stockLeftOut;
        stockResult = stockSearch.BinarySearch(stockList.toArray(new Stocks[stockList.size()]), testStock);
        
        if(stockResult == 0)
        {
            System.out.println(": " + testStock.GetName());
        }
        else
        {
            System.out.println(testStock.GetName() + " not found");
        }
        
        //old methods
        //stockSearch.BinarySearch(stockList.toArray(new Stocks[stockList.size()]), stockFour);  //Should print that it was found at index 3
        //stockSearch.BinarySearch(stockList.toArray(new Stocks[stockList.size()]), stockLeftOut);  //Should print that it was found at index 3        
        System.out.println("Finished");
    }    
}
