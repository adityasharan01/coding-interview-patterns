Given a string s, consisting of digits and lowercase alphabet characters, that's a run-length encoded string, return its decoded version.

Note: The original string is guaranteed not to have numbers in it.

Constraints

0 ≤ n ≤ 100,000 where n is the length of s
Example 1
Input
s = "4a3b2c1d2a"
Output
"aaaabbbccdaa"

Try to add x number of characters to a string where x is a number occurred before character
import java.util.*;

class Solution {
    public String solve(String s) {
        String result="";
        int k=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(s.charAt(i))){
                k=(k*10)+Character.getNumericValue(c);
            }
            else{
                while(k>0){
                    result+=s.charAt(i);
                    k--;
                }
                k=0;
            }
        }
        return result;
    }
}


