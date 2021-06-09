Given two strings a, and b, both representing an integer, add them and return it in the same string representation.

This should be implemented directly, instead of using eval or built-in big integers.

Constraints`

n ≤ 200 where n is the length of a
m ≤ 200 where m is the length of b
Example 1
Input
a = "12"
b = "23"
Output
"35"
Explanation
12 + 23 = 35

import java.util.*;

class Solution {
    public String solve(String a, String b) {
        if(a.length()>b.length()){
            String t=a;
            a=b;
            b=t;
        }
        int l1=a.length();
        int l2=b.length();
        String res="";
        int carry=0;
        a=new StringBuilder(a).reverse().toString();
        b=new StringBuilder(b).reverse().toString();
        int i=0;
        for(i=0;i<l1;i++)
        {
            int sum = ((int)(a.charAt(i) - '0')+(int)(b.charAt(i) - '0')+ carry);
            res += (char)(sum % 10 + '0');
            carry = sum / 10;
        }
        for(int j=i;j<l2;j++)
        {
            int sum = ((int)(b.charAt(i) - '0')+ carry);
            res += (char)(sum % 10 + '0');
            carry = sum / 10;
        }
        if(carry>0){
            res+=(char)(carry+'0');
        }
        res=new StringBuilder(res).reverse().toString();
        return res;
    }
}
