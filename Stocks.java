/*
Binary Search
Author: Damian Bouch
CIT 130 Z02B
Due: November 11, 2017
 */
//package bouch_binary_search_2;

public class Stocks implements Comparable
{
    private String stockName;
    private double stockPrice;
    
    public Stocks()
    {
        
    }
    
    public Stocks(String nameIn, double priceIn)
    {
        stockName = nameIn;
        stockPrice = priceIn;
    }
    
    public String GetName()
    {
        return this.stockName;
    }
    
    public double GetPrice()
    {
        return this.stockPrice;
    }
    
    public String toString()
    {
        return ("Stock: " + this.GetName());
    }
    
    public int compareTo(Object obj)
    {
        Stocks s1 = (Stocks)obj;
        if(this.stockPrice > s1.stockPrice)
        {
            return 1;
        }
        else if (this.stockPrice < s1.stockPrice)
        {
            return -1;
        }
        else
            return 0;
    }  
   
}
