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

Intuition
Iterate over both strings and appending the char at s0 and then s1 as long as either string has not reach the end. Once it has, we check if the index is equal or greater to s0 length, and if it is we add the remaining of string s1, else we add the remaining of string s0. Note, if both strings are equal we would be adding the remaining empty string and thus effectively not adding at all.

Implementation
=> Initialize str with StringBuilder to ""
=> Iterate over s0 and s1 while one of them have not reached the end of the string. In each iteration we append the char at s0 and then s1 to str.
=> Once we have iterated we append the remaining of s0 or s1 depending on if our indexing variable i is >= to the length of the string.
=> We then return the str as a String.

Time Complexity
\mathcal{O}(n)O(n) Time is proportional to the length of s0 or s1, whichever is shorter, as that is how long we are iterating in our loop at maximum.

Space Complexity
\mathcal{O}(n)O(n) str is proportional to the length of s0 and s1 combined.

import java.util.*;

class Solution {
    public String solve(String s0, String s1) {
        StringBuilder str = new StringBuilder("");

        int i = 0;

        while (i < s0.length() && i < s1.length()) {
            str.append(s0.charAt(i));
            str.append(s1.charAt(i++));
        }

        if (i >= s0.length())
            str.append(s1.substring(i));
        else
            str.append(s0.substring(i));

        return str.toString();
    }
}
