You are given a string s containing "1", "2", "3" and "?". 
Given that you can replace any “?” with "1", "2" or "3", return the smallest number you can make as a string such that no two adjacent digits are the same.

Constraints

n ≤ 100,000 where n is the length of s
Example 1
Input
s = "3?2??"
Output
"31212"
Example 2
Input
s = "???"
Output
"121"


Since the number 1333 is smaller than the number 2111 for example, we always want to minimize the left most digit that can be minimized, to get the smallest number.

We solve this greedily. If the current digit is a question mark, we check the digit on the left and on the right and set it to be the smallest untaken digit.

Implementation
My code maintains the string in a character array and sweeps from left to right. When a question mark is updated to a new value, my code updates the array (since this update will affect the next index).

At the end, my code turns the array back into a string and outputs that string.

Example #1
"3?2??"
My code skips the indices which aren't question marks (index 0 and 2).
On index 1 it sets the character to 1, so the string becomes "312??".
On index 3 it sets the character to 1, so the becomes "3121?".
On index 4 it sets the character to 2 (since 1 is taken), and the final answer is "31212".

Time Complexity
\mathcal{O}(n)O(n) because of the linear sweep through the string.

Space Complexity
\mathcal{O}(n)O(n) because we maintain a character array of the new string we build.

import java.util.*;

class Solution {
    public String solve(String s) {
        char[] c = s.toCharArray();
        int N = s.length();
        for (int i = 0; i < N; i++) {
            if (c[i] != '?')
                continue;
            boolean[] b = new boolean[3];
            if (i > 0)
                b[c[i - 1] - '1'] = true;
            if (i < N - 1 && c[i + 1] != '?')
                b[c[i + 1] - '1'] = true;
            for (int j = 0; j < 3; j++) {
                if (!b[j]) {
                    c[i] = (char) (j + '1');
                    break;
                }
            }
        }
        return new String(c);
    }
}
