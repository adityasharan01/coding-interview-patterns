Minimum String
You are given two strings s and t of equal length only consisting of lowercase letters. Assuming that you can first rearrange s into any order, return the minimum number of changes needed to turn s into t.

Constraints

0 ≤ n ≤ 100,000 where n is the length of s and t
Example 1
Input
s = "ehyoe"
t = "hello"
Output
2
Explanation
We can shuffle "ehyoe" to be "heyeo" and then turn "y" and the 2nd "e" into "l".
  
  import java.util.*;

class Solution {
    public int solve(String s, String t) {
    int []freq1 = new int[26];
    int []freq2 = new int[26];
    Arrays.fill(freq1, 0);
    Arrays.fill(freq2, 0);
    int i, count = 0;
 
    for (i = 0; i < s.length();i++)
        freq1[s.charAt(i) - 'a']++;
    for (i = 0; i < t.length(); i++)
        freq2[t.charAt(i) - 'a']++;

    for (i = 0; i < 26; i++)
        count += (Math.abs(freq1[i]-freq2[i]));
 
    return count/2;
    }
}
