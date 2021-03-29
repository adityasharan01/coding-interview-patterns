Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Note:

The input string length won't exceed 1000.
 Here is video explaining the code :
https://www.youtube.com/watch?v=e3XuZFqH9ZA
Approach1:
  Brute Force Solution:-
 class Solution {
    // TC : O(2*O(n2))

    // SC : O(1)
    public int countSubstrings(String s) {

        int totalCount = 0;
        for(int i=0;i<s.length();i++){
            totalCount += getCountOfPalindromicSubstring(i,i, s);   // aba

            totalCount += getCountOfPalindromicSubstring(i,i+1, s); // abba

        }

        return totalCount;
    }

    private int getCountOfPalindromicSubstring(int start, int end, String s ){
        int tCount = 0;
        // O(n)
        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
            tCount++;
        }

        return tCount;
    }


}
  
  
  
  
  This approach uses Top Down DP i.e memoized version of recursion.

Recursive soln:
1. Here base condition comes out to be i>j if we hit this condition, return 1.
2. We check for each and every i and j, if the characters are equal, 
   if that is not the case, return 0.
3. Call the is_palindrome function again with incremented i  and decremented j.
4. Check this for all values of i and j by applying 2 for loops.

import java.util.*;
public class Main
{
    static int dp[][] = new int[1001][1001]; // 2D matrix
     
    public static int isPal(String s, int i, int j)
    {
        // Base condition
        if (i > j)
            return 1;
      
        // check if the recursive tree
        // for given i, j
        // has already been executed
        if (dp[i][j] != -1)
            return dp[i][j];
      
        // If first and last characters of
        // substring are unequal
        if (s.charAt(i) != s.charAt(j))
            return dp[i][j] = 0;
      
        // memoization
        return dp[i][j] = isPal(s, i + 1, j - 1);
    }
      
    public static int countSubstrings(String s)
    {
        for (int[] row: dp)
        {
            Arrays.fill(row, -1);
        }
        int n = s.length();
        int count = 0;
      
        // 2 for loops are required to check for
        // all the palindromes in the string.
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                // Increment count for every palindrome
                if (isPal(s, i, j) != 0)
                    count++;
            }
        }
       
        // return total palindromic substrings
        return count;
    }
 
    public static void main(String[] args) {
        String s = "abbaeae";
  
        System.out.println(countSubstrings(s));
    }
}
