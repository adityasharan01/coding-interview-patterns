Given two strings a and b, return the length of their longest common subsequence.

Constraints

n ≤ 1,000 where n is the length of a
m ≤ 1,000 where m is the length of b
Example 1
Input
a = "abcvc"
b = "bv"
Output
2
Explanation
bv is the longest common subsequence.

Example 2
Input
a = "abc"
b = "abc"
Output
3
Example 3
Input
a = "abc"
b = "def"
Output
0
Example 4
Input
a = "binarysearch"
b = "searchbinary"
Output
6

Intuition
Longest Common Subsequence (LCS) :
Before attempting the sum there are few mathematical/ logical observations we need to make

Brute Force wont work since it takes exponential time

Target Time / Space Complexity = NxM
--> observations :
A comparison between two strings abcd and aebd for LCS can be broken down to four parts
LCS( abcd , aebd) ==>
_bcd , _ebd
_bcd , aebd
abcd, _ebd
abcd , aebd
from these comparisions we can write a generalized form of the letters as follows:

_[rem1] ,  _[rem2]
 _[rem1] ,  s2[rem2]
 s1[rem1,  _[rem2]
 s1[rem1], s2[rem2]
we can make two broad cases from these four categories of comparision:
I) case 1: s1==s2
in this case only the fourth condition ( s1[rem1], s2[rem2]) gives the maximum answer for LCS as the other answers would be smaller than this due to inclusion of another character s1/ s2 in the subsequence
Therefore from this case to get the answer for LCS we can perform this operation
memo[i][j] = memo[i + 1][j + 1] + 1

II) case 2: s1!=s2
In this case we need to get the answer from the remaining three
for which we can write the pairing as

_[rem1] --> s2[rem2] / _[rem2]
s1[rem1] / _[rem1] --> _[rem2]]
the maximum of these two would be the answer for memo[i][j]

Implementation
The implementation of the code contains the iterative approach where we will be travelling from n-1 , m-1 till 0,0 while memoizing the answer and then finally return memo[0][0] which would contain the LCS value of the whole string

Time Complexity
\mathcal{O}(nm)O(nm) is the overall time complexity of the code ( two for loops n x m)

Space Complexity
\mathcal{O}(nm)O(nm) is the overall space complexity of the code required for the memo array [ 2d]

class Solution:
    def solve(self, a, b):
        # initializing a dp array of size
        n = len(a)
        m = len(b)
        memo = [[0 for i in range(m + 1)] for i in range(n + 1)]

        for i in range(n - 1, -1, -1):
            for j in range(m - 1, -1, -1):
                if a[i] == b[j]:
                    memo[i][j] = memo[i + 1][j + 1] + 1
                else:
                    memo[i][j] = max(memo[i + 1][j], memo[i][j + 1])
        return memo[0][0]

/////////////////////////////////////////////////////////////
Intuition
The idea is to use bottom up dynamic programming. Top down with memorisation will also work

Implementation
Define DP state : dp[i][j] = lcs of strings a and b ending at indices i and j
Define DP state transition :
if(a.char[i] == b.char[j]) -> lcs[i][j] = 1 + lcs[i-1][j-1]
else lcs[i][j] = Math.max(lcs[i][j-1), lcs[i-1][j])

Bases cases should be buit for zero index of a with all index of b and zero index of b with all index of a and then start the bottom up computation from index pair

Time Complexity
\mathcal{O}(n^2)O(n 
2
 ) DP state is {i,j} hence we need to fill the dp states for every {i,j} so that dp state transition works seamlessly

Space Complexity
\mathcal{O}(n^2)O(n 
2
 ) extra space is used to store the dp states

import java.util.*;

class Solution {
    public int solve(String a, String b) {
        if (a == null || b == null || a.isEmpty() || b.isEmpty())
            return 0;
        int maxLen = 0;

        int[][] lcs = new int[a.length()][b.length()];
        lcs[0][0] = a.charAt(0) == b.charAt(0) ? 1 : 0;
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(0))
                lcs[i][0] = 1;
            else
                lcs[i][0] = lcs[i - 1][0];
            maxLen = Math.max(maxLen, lcs[i][0]);
        }

        for (int i = 1; i < b.length(); i++) {
            if (b.charAt(i) == a.charAt(0))
                lcs[0][i] = 1;
            else
                lcs[0][i] = lcs[0][i - 1];
            maxLen = Math.max(maxLen, lcs[0][i]);
        }

        for (int i = 1; i < a.length(); i++) {
            for (int j = 1; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                maxLen = Math.max(maxLen, lcs[i][j]);
            }
        }
        return maxLen;
    }
}
