Max Product Subarray
Given an array A[] that contains both positive and negative integers, find the maximum product subarray.
Examples : 
 

Input: A[] = { 6, -3, -10, 0, 2 }
Output: 180  // The subarray is {6, -3, -10}

Input: A[] = {-1, -3, -10, 0, 60 }
Output: 60  // The subarray is {60}

Input: A[] = { -2, -3, 0, -2, -40 }
Output: 80  // The subarray is {-2, -40}
  
  ////////METHOD1:
  Naive Solution:

The idea is to traverse over every contiguous subarrays, find the product of each of these subarrays and return the maximum product from these results.

Below is the implementation of the above approach.
  // Java program to find maximum product subarray
import java.io.*;

class GFG {
	/* Returns the product of max product subarray.*/
	static int maxSubarrayProduct(int arr[])
	{
		// Initializing result
		int result = arr[0];
		int n = arr.length;

		for (int i = 0; i < n; i++)
		{
			int mul = arr[i];
			// traversing in current subarray
			for (int j = i + 1; j < n; j++)
			{
				// updating result every time
				// to keep an eye over the
				// maximum product
				result = Math.max(result, mul);
				mul *= arr[j];
			}
			// updating the result for (n-1)th index.
			result = Math.max(result, mul);
		}
		return result;
	}

	// Driver Code
	public static void main(String[] args)
	{
		int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
		System.out.println("Maximum Sub array product is "
						+ maxSubarrayProduct(arr));
	}
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
The idea is to traverse array from left to right keeping two variables minVal and maxVal 
which represents the minimum and maximum product value till the ith index of the array. 
Now, if the ith element of the array is negative that means
now the values of minVal and maxVal will be swapped as value of maxVal will become minimum by multiplying it with a negative number.
Now, compare the minVal and maxVal,The value of minVal and maxVal depends on the current index element or 
the product of the current index element and the previous minVal and maxVal respectively.
  
// Java program to find maximum product subarray
import java.io.*;

class GFG {

	// Function to find maximum product subarray
	static int maxProduct(int arr[], int n)
	{
		
		// Variables to store maximum and minimum
		// product till ith index.
		int minVal = arr[0];
		int maxVal = arr[0];
	
		int maxProduct = arr[0];
	
		for (int i = 1; i < n; i++)
		{
	
			// When multiplied by -ve number,
			// maxVal becomes minVal
			// and minVal becomes maxVal.
			if (arr[i] < 0)
			{
				int temp = maxVal;
				maxVal = minVal;
				minVal =temp;
			
			}
	
			// maxVal and minVal stores the
			// product of subarray ending at arr[i].
			maxVal = Math.max(arr[i], maxVal * arr[i]);
			minVal = Math.min(arr[i], minVal * arr[i]);
	
			// Max Product of array.
			maxProduct = Math.max(maxProduct, maxVal);
		}
	
		// Return maximum product found in array.
		return maxProduct;
	}
	
	// Driver Code
	public static void main (String[] args)
	{
		int arr[] = { -1, -3, -10, 0, 60 };
		int n = arr.length;
	
		System.out.println( "Maximum Subarray product is "
									+ maxProduct(arr, n));
	}
}
Output: 
Maximum Sub array product is 60
 

Time Complexity: O( n ) 
Auxiliary Space: O( 1 )
