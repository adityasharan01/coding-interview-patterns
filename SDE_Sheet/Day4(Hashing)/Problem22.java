Largest subarray with 0 sum 
Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
Your Task:
You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

Expected Time Complexity: O(N*Log(N)).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
-1000 <= A[i] <= 1000, for each valid i

Naive Approach: This involves the use of brute force where two nested loops are used. 
  The outer loop is used to fix the starting position of the sub array, 
and the inner loop is used for the ending position of the sub-array and if the sum of elements is equal to zero then increase the count.
 
  
Algorithm:
Consider all sub-arrays one by one and check the sum of every sub-array.
Run two loops: the outer loop picks the starting point i and the inner loop tries all sub-arrays starting from i.

 class GFG {
    // Returns length of the largest subarray
    // with 0 sum
    static int maxLen(int arr[], int n)
    {
        int max_len = 0;

        // Pick a starting point
        for (int i = 0; i < n; i++) {
            // Initialize curr_sum for every
            // starting point
            int curr_sum = 0;

            // try all subarrays starting with 'i'
            for (int j = i; j < n; j++) {
                curr_sum += arr[j];

                // If curr_sum becomes 0, then update
                // max_len
                if (curr_sum == 0)
                    max_len = Math.max(max_len, j - i + 1);
            }
        }
        return max_len;
    }

    public static void main(String args[])
    {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        int n = arr.length;
        System.out.println("Length of the longest 0 sum "
                           + "subarray is " + maxLen(arr, n));
    }
}

Complexity Analysis: 
 


Time Complexity: O(n^2) due to the use of nested loops.
Space complexity: O(1) as no extra space is used.


 





Efficient Approach: The brute force solution is calculating the sum of each and every sub-array and checking whether the sum is zero or not. Let's now try to improve the time complexity by taking an extra space of 'n' length. The new array will store the sum of all the elements up to that index. The sum-index pair will be stored in a hash-map. A Hash map allows insertion and deletion of key-value pair in constant time. Therefore, the time complexity remains unaffected. So, if the same value appears twice in the array, it will be guaranteed that the particular array will be a zero-sum sub-array. 
 
  
Algorithm: 
 


Create a extra space, an array of length n (prefix), a variable (sum) , length (max_len) and a hash map (hm) to store sum-index pair as a key-value pair
Move along the input array from starting to the end
For every index update the value of sum = sum + array[i]
Check for every index, if the current sum is present in the hash map or not
If present update the value of max_len to maximum of difference of two indices (current index and index in the hash-map) and max_len
Else Put the value (sum) in the hash map, with the index as a key-value pair.
Print the maximum length (max_len)
  
class MaxLenZeroSumSub {

    // Returns length of the maximum length subarray with 0 sum
    static int maxLen(int arr[])
    {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        int sum = 0; // Initialize sum of elements
        int max_len = 0; // Initialize result

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum
            sum += arr[i];

            if (arr[i] == 0 && max_len == 0)
                max_len = 1;

            if (sum == 0)
                max_len = i + 1;

            // Look this sum in hash table
            Integer prev_i = hM.get(sum);

            // If this sum is seen before, then update max_len
            // if required
            if (prev_i != null)
                max_len = Math.max(max_len, i - prev_i);
            else // Else put this sum in hash table
                hM.put(sum, i);
        }

        return max_len;
    }

    // Drive method
    public static void main(String arg[])
    {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println("Length of the longest 0 sum subarray is "
                           + maxLen(arr));
    }
}
