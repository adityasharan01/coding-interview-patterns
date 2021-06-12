Given two strings a and b, find the minimum edit distance between the two. One edit distance is defined as

Deleting a character or
Inserting a character or
Replacing a character
Constraints

n ≤ 1,000 where n is the length of a
m ≤ 1,000 where m is the length of b
Example 1
Input
a = "zhello"
b = "helli"
Output
2
Explanation
"z" is removed and the "o" is replaced with "i"

Example 2
Input
a = "dycare"
b = "daycare"
Output
1
Explanation
"a" is inserted into the first string to get "daycare".
  
Intuition
We can obeserve that this is dynamic programming because we can find a recurrence and store a smaller sub-solution to build up from the bottom to find the answer we are looking for.

Implementation
Botom-Up Tabulation. We are going to iterate through both strings, and if each string shares a common character at the same i, j index, then we know that the edit distance is 0. Thus, we take the previous row and column index. Otherwise, we take the minimum of the previous row, previous column, or previous column and previous row, and then add 1. The final answer will be stored in the bottom-right of our matrix[b.length()][a.length()]

Time Complexity
\mathcal{O}(m * n)O(m∗n), where m and n are the sizes of each string respectively.

Space Complexity
\mathcal{O}(m * n)O(m∗n), where our dynamic programming table is of size m * n.

import java.util.*;

class Solution {
    public int solve(String a, String b) {
        int[][] edits = new int[b.length() + 1][a.length() + 1];
        for (int i = 0; i < edits.length; i++) {
            for (int j = 0; j < edits[0].length; j++) {
                edits[0][j] = j;
            }
            edits[i][0] = i;
        }
        for (int i = 1; i < b.length() + 1; i++) {
            for (int j = 1; j < a.length() + 1; j++) {
                if (b.charAt(i - 1) == a.charAt(j - 1)) {
                    edits[i][j] = edits[i - 1][j - 1];
                } else {
                    edits[i][j] = 1
                        + Math.min(edits[i - 1][j - 1], Math.min(edits[i - 1][j], edits[i][j - 1]));
                }
            }
        }
        return edits[b.length()][a.length()];
    }
}
Intuition
at each point we have 3 steps either insert , delete, replace or no change ( ony when the characters match ), so we try to build the big string from the smaller one ,our recursive relation will be at each step if we try to equalize a[0 ... i] to b[0 ... j]
now if a[i] != b[j]

now if we insert a character in a we see how many steps it will take to match from b[0 .... j-1] and insert the character in the end of a to match it with b[j]
else if we try to delete a character in a we see how many steps it will take to match a[0 ... i - 1] to b[0 ... j]
else we replace a character in a , so we just check how many steps it will take to match a[ 0 ... i-1] to b[0  ... j - 1]
Implementation
we use bottom approach for the implementation

maintiain a 2-d table where dp[i][j] represents the minimu cost to equalize the i length of a with j length of b.
Time Complexity
\mathcal{O}(n \cdot m)O(n⋅m) since we use two nester for loops . so it's overall quadratic.

Space Complexity
\mathcal{O}(n \cdot m)O(n⋅m) since we will a two dimensional array of size n * m

class Solution:
    def solve(self, a, b):
        n, m = len(a), len(b)
        dp = [[1e9 for _ in range(m + 1)] for p in range(n + 1)]
        dp[0][0] = 0
        for i in range(1, n):
            dp[i][0] = i

        for i in range(1, m):
            dp[0][i] = i

        for i in range(1, n + 1):
            for j in range(1, m + 1):
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
                if a[i - 1] == b[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
        return dp[n][m]
