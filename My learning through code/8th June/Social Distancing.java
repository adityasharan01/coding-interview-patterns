You are given a string s and an integer k. Each character in the string is either '.' or 'x', where '.' represents an empty space and 'x' represents a person.

Return whether it's possible to choose a position to stand on such that the distance between you and the closest person to you is at least k. (The distance between each neighbouring indices is 1).

Constraints

1 ≤ k ≤ n ≤ 100,000 where n is the length of s
Example 1
Input
s = "x.."
k = 2
Output
true
Explanation
You can stand at s[2]

Example 2
Input
s = "x..x"
k = 2
Output
false
Explanation
There's a person standing next to both of the empty spaces (distance of 1).

Example 3
Input
s = "x...x"
k = 2
Output
true
Explanation
You can stand at s[2].

Example 4
Input
s = "..x"
k = 2
Output
true
Explanation
You can stand at s[0]

Example 5
Input
s = "."
k = 1
Output
true
Explanation
You can stand at s[0]

Hint1:Suffix & Prefix to store last occurrence of 'x'
  
  Intuition
Check the beginning and end to see if there's enough space. Then iterate through the string for substring length k*2-1. If any of these substrings do not contain "x", return true.

import java.util.*;

class Solution {
    public boolean solve(String s, int k) {
        String beg = s.substring(0, k);
        String end = s.substring(s.length() - k, s.length());
        if (!beg.contains("x") || !end.contains("x")) {
            return true;
        }
        int check = k * 2 - 1;
        for (int i = 0; i < s.length() - check; i++) {
            if (!s.substring(i, i + check).contains("x")) {
                return true;
            }
        }
        return false;
    }
}
