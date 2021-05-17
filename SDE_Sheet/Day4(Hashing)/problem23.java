Count the number of subarrays having a given XOR
A Simple Solution is to use two loops to go through all possible subarrays of arr[] and count the number of subarrays having XOR of their elements as m. 

public class GFG {
 
    // Simple function that returns
    // count of subarrays of arr with
    // XOR value equals to m
    static long subarrayXor(int arr[],
                             int n, int m)
    {
         
        // Initialize ans
        long ans = 0;
 
        // Pick starting point i of
        // subarrays
        for (int i = 0; i < n; i++)
        {
             
            // Store XOR of current
            // subarray
            int xorSum = 0;
 
            // Pick ending point j of
            // subarray for each i
            for (int j = i; j < n; j++)
            {
                 
                // calculate xorSum
                xorSum = xorSum ^ arr[j];
 
                // If xorSum is equal to
                // given value, increase
                // ans by 1.
                if (xorSum == m)
                    ans++;
            }
        }
         
        return ans;
    }
 
    // Driver code
    public static void main(String args[])
    {
 
        int[] arr = { 4, 2, 2, 6, 4 };
        int n = arr.length;
        int m = 6;
 
        System.out.println("Number of subarrays"
                       + " having given XOR is "
                       + subarrayXor(arr, n, m));
    }
}
 Efficient Approach:
An Efficient Solution solves the above problem in O(n) time. Let us call the XOR of all elements in the range [i+1, j] as A, in the range [0, i] as B, and in the range [0, j] as C. If we do XOR of B with C, the overlapping elements in [0, i] from B and C zero out, and we get XOR of all elements in the range [i+1, j], i.e. A. Since A = B XOR C, we have B = A XOR C. Now, if we know the value of C and we take the value of A as m, we get the count of A as the count of all B satisfying this relation. Essentially, we get the count of all subarrays having XOR-sum m for each C. As we take the sum of this count overall C, we get our answer.
1) Initialize ans as 0.
2) Compute xorArr, the prefix xor-sum array.
3) Create a map mp in which we store count of 
   all prefixes with XOR as a particular value. 
4) Traverse xorArr and for each element in xorArr
   (A) If m^xorArr[i] XOR exists in map, then 
       there is another previous prefix with 
       same XOR, i.e., there is a subarray ending
       at i with XOR equal to m. We add count of
       all such subarrays to result. 
   (B) If xorArr[i] is equal to m, increment ans by 1.
   (C) Increment count of elements having XOR-sum 
       xorArr[i] in map by 1.
5) Return ans.
  
  
import java.util.*;
 
class GFG {
 
    // Returns count of subarrays of arr with XOR
    // value equals to m
    static long subarrayXor(int arr[], int n, int m)
    {
        long ans = 0; // Initialize answer to be returned
 
        // Create a prefix xor-sum array such that
        // xorArr[i] has value equal to XOR
        // of all elements in arr[0 ..... i]
        int[] xorArr = new int[n];
 
        // Create map that stores number of prefix array
        // elements corresponding to a XOR value
        HashMap<Integer, Integer> mp
            = new HashMap<Integer, Integer>();
 
        // Initialize first element of prefix array
        xorArr[0] = arr[0];
 
        // Computing the prefix array.
        for (int i = 1; i < n; i++)
            xorArr[i] = xorArr[i - 1] ^ arr[i];
 
        // Calculate the answer
        for (int i = 0; i < n; i++) {
            // Find XOR of current prefix with m.
            int tmp = m ^ xorArr[i];
 
            // If above XOR exists in map, then there
            // is another previous prefix with same
            // XOR, i.e., there is a subarray ending
            // at i with XOR equal to m.
            ans = ans
                  + (mp.containsKey(tmp) == false
                         ? 0
                         : ((long)mp.get(tmp)));
 
            // If this subarray has XOR equal to m itself.
            if (xorArr[i] == m)
                ans++;
 
            // Add the XOR of this subarray to the map
            if (mp.containsKey(xorArr[i]))
                mp.put(xorArr[i], mp.get(xorArr[i]) + 1);
            else
                mp.put(xorArr[i], 1);
        }
 
        // Return total count of subarrays having XOR of
        // elements as given value m
        return ans;
    }
 
    // Driver code
    public static void main(String[] args)
    {
        int arr[] = { 4, 2, 2, 6, 4 };
        int n = arr.length;
        int m = 6;
 
        System.out.print(
            "Number of subarrays having given XOR is "
            + subarrayXor(arr, n, m));
    }
}
