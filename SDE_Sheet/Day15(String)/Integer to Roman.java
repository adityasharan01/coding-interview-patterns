Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
Hint:
What is the range of the numbers?
Solution:
Roman Literal Decimal
I 1
V 5
X 10
L 50
C 100
D 500
M 1000

  For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.

 

Example 1:

Input: num = 3
Output: "III"
Example 2:

Input: num = 4
Output: "IV"
Example 3:

Input: num = 9
Output: "IX"
Example 4:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
  /////////////////////////////////////////////////////////////////////////////////
  
  
  
  private static final int[] values = {
 1000, 900, 500, 400,
 100, 90, 50, 40,
 10, 9, 5, 4,
 1
};
private static final String[] symbols = {
 "M", "CM", "D", "CD",
 "C", "XC", "L", "XL",
 "X", "IX", "V", "IV",
 "I"
};
public String intToRoman(int num) {
  StringBuilder roman = new StringBuilder();
  int i = 0;
  while (num > 0)
  {
    int k = num / values[i];
    for (int j = 0; j < k; j++)
    {
       roman.append(symbols[i]);
        num -= values[i];
    }
    i++;
    }
    return roman.toString();
  }
