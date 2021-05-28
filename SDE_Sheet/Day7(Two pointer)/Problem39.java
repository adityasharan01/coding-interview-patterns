Trapping Rain Water
 Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 
 

Example 1:

Input:
N = 6
arr[] = {3,0,0,2,0,4}
Output:
10
Explanation: 

Example 2:

Input:
N = 4
arr[] = {7,4,0,9}
Output:
10
Explanation:
Water trapped by above 
block of height 4 is 3 units and above 
block of height 0 is 7 units. So, the 
total unit of water trapped is 10 units.
Example 3:

Input:
N = 3
arr[] = {6,9,9}
Output:
0
Explanation:
No water will be trapped.
  
  
  
//  Naive Method
import java.util.*;
import java.io.*;
import java.lang.*;
class GFG 
{ 
    

    static int getWater(int arr[], int n)
    {
    	int res = 0;

    	for(int i = 1; i < n - 1; i++)
    	{
    		int lMax = arr[i];

    		for(int j = 0; j < i; j++)
    			lMax = Math.max(lMax, arr[j]);

    		int rMax = arr[i];

    		for(int j = i + 1; j < n; j++)
    			rMax = Math.max(rMax, arr[j]);

    		res = res + (Math.min(lMax, rMax) - arr[i]);
    	}
    
    	return res;
    }


    public static void main(String args[]) 
    { 
       int arr[] = {3, 0, 1, 2, 5}, n = 5;

      System.out.println( getWater(arr, n));

    } 

}

//Efficient Method 
static int getWater(int arr[], int n)
    {
    	int res = 0;

    	int lMax[] = new int[n];
    	int rMax[] = new int[n];

    	lMax[0] = arr[0];
    	for(int i = 1; i < n; i++)
    		lMax[i] = Math.max(arr[i], lMax[i - 1]);


    	rMax[n - 1] = arr[n - 1];
    	for(int i = n - 2; i >= 0; i--)
    		rMax[i] = Math.max(arr[i], rMax[i + 1]);

    	for(int i = 1; i < n - 1; i++)
    		res = res + (Math.min(lMax[i], rMax[i]) - arr[i]);
    	
    	return res;
    }
