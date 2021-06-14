Removing Triple Successive Duplicates

Given a string s containing "0"s and "1"s, consider an operation where you pick a character and toggle its value from "0" to "1" or from "1" to "0". Return the minimum number of operations required to obtain a string containing no instances of three identical consecutive characters.

Constraints

0 ≤ n ≤ 100,000 where n is the length of s
Example 1
Input
s = "1100011"
Output
1
Explanation
We can toggle the middle "0" to a "1".

Example 2
Input
s = "0001000"
Output
2
Explanation
We can toggle the first and the last characters to get "1001001"
  
  
 import java.util.*;

class Solution {
    public int solve(String s) {
        int count=0;
        if(s.length()<3){
            return 0;
        }
        for(int i=2;i<s.length();){
            char c1=s.charAt(i-2);
            char c2=s.charAt(i-1);
            char c3=s.charAt(i);
            if(c1==c2 && c2==c3){
                i=i+3;
                count++;
            }
            else{
                i++;
            }
        }
        return count;
    }
}
