Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


// APPROACH 1:
class Main
{
    // Function to return the maximum product of a subarray of a given array
    public static int findMaxProduct(int[] A)
    {
        // maintain two variables to store the maximum and minimum product
        // ending at the current index
        int max_ending = 0, min_ending = 0;
 
        // to store the maximum product subarray found so far
        int max_so_far = 0;
 
        // traverse the given array
        for (int i: A)
        {
            int temp = max_ending;
 
            // update the maximum product ending at the current index
            max_ending = Integer.max(i, Integer.max(i * max_ending, i * min_ending));
 
            // update the minimum product ending at the current index
            min_ending = Integer.min(i, Integer.min(i * temp, i * min_ending));
 
            max_so_far = Integer.max(max_so_far, max_ending);
        }
 
        // return maximum product
        return max_so_far;
    }
 
    public static void main(String[] args)
    {
        int[] A = { -6, 4, -5, 8, -10, 0, 8 };
 
        System.out.print("The maximum product of a subarray is " + findMaxProduct(A));
    }
}
