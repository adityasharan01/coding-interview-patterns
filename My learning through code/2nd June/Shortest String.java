Given a string s consisting only of "1"s and "0"s, you can delete any two adjacent letters if they are different.

Return the length of the smallest string that you can make if you're able to perform this operation as many times as you want.

Constraints

0 ≤ n ≤ 100,000 where n is the length of s
Example 1
Input
s = "11000"
Output
1
Explanation
After deleting "10" we get "100" and we can delete another "10" to get "0" which has a length of 1.
  
Intuition
replace all '01's and '10's, return length of the remain.

Implementation
Loop and replace '01' and '10's test length after replacement, if length remain same, exit loop;

Time Complexity
\mathcal{O}(\log n )O(logn) loop for n times of the 01 and 10s

Space Complexity
\mathcal{O}(1)O(1) s's replacement________________________
  
  //this could be used when continuos we need to remove something from the string until certain condition
 
  import java.util.*;

class Solution {
    public int solve(String s) {
        while(true)
        {
            int len=s.length();
            s=s.replace("01","");
            s=s.replace("10","");
            if(s.length()==len)
                break;
        }
        return s.length();
    }
}


