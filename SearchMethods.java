/*
Binary Search
Author: Damian Bouch
CIT 130 Z02B
Due: November 11, 2017
 */
//package bouch_binary_search_2;

public class SearchMethods<T,S>
{
    public <T extends Comparable, S extends Comparable> int BinarySearch(T[] inputArray, T searchValue)
    {
        int result = 0;
        int low = 0;
        int high = inputArray.length - 1;
        int mid;  
        
        boolean found = false;
        
        while((low <= high) && !(found))
        {
            mid = ((low + high)/2);
            
            if(searchValue.compareTo(inputArray[mid]) == 0)
            {
                found = true;
                result = mid;
                System.out.print("Found at index " + result);
                return 0;
            }
            else if(searchValue.compareTo(inputArray[mid]) < 0)
            {
                high = mid - 1;
            }
            else if(searchValue.compareTo(inputArray[mid]) > 0 )
            {
                low = mid + 1;
            }
        }    
        return -1;
    }    
}
