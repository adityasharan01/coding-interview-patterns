Roman to Integer
Easy

743

67

Add to List

Share
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Example 2:

Input: s = "IV"
Output: 4
Example 3:

Input: s = "IX"
Output: 9
Example 4:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
  ////////
  Let’s work through some examples. Assume the input is “VII”, using the [additive 
notation], we could simply add up each roman literal, ‘V’ + ‘I’ + ‘I’ = 5 + 1 + 1 = 7.
Now let’s look at another example input “IV”. Now we need to use the [subtractive 
notation]. We first look at ‘I’, and we add 1 to it. Then we look at ‘V’ and since a 
smaller roman literal ‘I’ appears before it, we need to subtract ‘I’ from ‘V’. Remember 
that we already added another ‘I’ before it, so we need to subtract a total of two one’s 
from it.
Below is a more complex example that involves both additive and subtractive notation: 
“MXCVI”.
  
    private Map<Character, Integer> map = 
        new HashMap<Character, Integer>() 
      {{
         put('I', 1); put('V', 5); put('X', 10);
         put('L', 50); put('C', 100); put('D', 500);
         put('M', 1000);
     }};
        public int romanToInt(String s) 
        {
         int prev = 0, total = 0;
         for (char c : s.toCharArray())
         {
             int curr = map.get(c);
             total += (curr > prev) ? (curr - 2 * prev) : curr;
             prev = curr;
         }
         return total;
        }
  
