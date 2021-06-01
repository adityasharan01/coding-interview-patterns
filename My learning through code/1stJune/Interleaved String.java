Given two strings s0 and s1, return the two strings interleaved, starting with s0. If there are leftover characters in a string they should be added to the end.

Constraints

n ≤ 100,000 where n is the length of s0
m ≤ 100,000 where n is the length of s1
Example 1
Input
s0 = "abc"
s1 = "xyz"
Output
"axbycz"
Example 2
Input
s0 = "abc"
s1 = "x"
Output
"axbc"


import java.util.*;

class Solution {
    public String solve(String s0, String s1) {
        if(s0.length()==0){
            return s1;
        }
        if(s1.length()==0){
            return s0;
        }
        int i=0;
        int j=0;int pos=0;
        char[] st=new char[s0.length()+s1.length()];  // NOTE THIS
        for(;i<s0.length()||j<s1.length();i++,j++)
        {
            if(i<s0.length())
                st[pos++]=s0.charAt(i);
            if(j<s1.length())
                st[pos++]=s1.charAt(j);
        }
        return new String(st);   // OBSERVE THIS
    }
}
