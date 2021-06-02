Subset Sums
Given an array of integers, print sums of all subsets in it. Output sums can be printed in any order.

Examples : 

Input : arr[] = {2, 3}
Output: 0 2 3 5

Input : arr[] = {2, 4, 5}
Output : 0 2 4 5 6 7 9 11
  
  
  
  
import java.io.*;
 
class GFG {
 
    // Prints sums of all
    // subsets of arr[l..r]
    static void subsetSums(int[] arr, int l, int r, int sum)
    {
 
        // Print current subset
        if (l > r) {
            System.out.print(sum + " ");
            return;
        }
 
        // Subset including arr[l]
        subsetSums(arr, l + 1, r, sum + arr[l]);
 
        // Subset excluding arr[l]
        subsetSums(arr, l + 1, r, sum);
    }
 
    // Driver code
    public static void main(String[] args)
    {
        int[] arr = { 5, 4, 3 };
        int n = arr.length;
 
        subsetSums(arr, 0, n - 1, 0);
    }
}
 
// Iterative Java program to print sums of all
// possible subsets.
import java.util.*;
 
class GFG {
 
    // Prints sums of all subsets of array
    static void subsetSums(int arr[], int n)
    {
 
        // There are totoal 2^n subsets
        int total = 1 << n;
 
        // Consider all numbers from 0 to 2^n - 1
        for (int i = 0; i < total; i++) {
            int sum = 0;
 
            // Consider binary reprsentation of
            // current i to decide which elements
            // to pick.
            for (int j = 0; j < n; j++)
                if ((i & (1 << j)) != 0)
                    sum += arr[j];
 
            // Print sum of picked elements.
            System.out.print(sum + " ");
        }
    }
 
    // Driver code
    public static void main(String args[])
    {
        int arr[] = new int[] { 5, 4, 3 };
        int n = arr.length;
 
        subsetSums(arr, n);
    }
}
