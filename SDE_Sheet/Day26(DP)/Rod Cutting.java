You are given a list of integers prices where prices[i] represents the price to sell a rod of size i + 1, and an integer n which represents the current size of the rod.

Given you can cut the rod into any number of different sizes, return the maximum profit that can be earned.

Constraints

m = n ≤ 1000 where m is the length of prices.
Example 1
Input
prices = [1, 3, 5, 7, 7, 7]
n = 6
Output
10
Explanation
The price table shows that we can

Sell a rod of size 1 for price of 1
Sell a rod of size 2 for price of 3
Sell a rod of size 3 for price of 5
Sell a rod of size 4 for price of 7
Sell a rod of size 5 for price of 7
Sell a rod of size 6 for price of 7
The optimal way to cut the rod is to split it into 2 pieces of length 3, to achieve profit of 10.
  
 Intuition
This is an unbounded knapsack problem.
A useful technique for such problems is to use recursion to figure out all possible combination this rod can be cut and then maximize the profit.
While figuring out the combinations, we will surely come across a lot of repeating sub-combinations. We can keep track of max profit of these sub-combinations and reuse them.

Implementation
Suppose a rod is of length 6. The rod can be cut in 6 different ways (since the allowed sizes are the index+1 of prices)
For every (index+1), you have two choices : either you cut or you skip cutting. For example, you can cut at 1 and divide the rod into two sizes (1,5)
We are using bottom up dynamic programming approach here.

Example #1
prices = [1, 3, 5, 7, 7, 7] and n = 6
Here the length of rod is 6, so it can be cut in max 6 ways. Hence, maximum size of dp[] array will be n+1.
When you cut the rod at certain 'i', you divide it into two parts.
The first part has the previous profit and the next part becomes sum of prices[i] and new sub-division profit. We then select the highest profit and save it in dp[n] for reuse.
At the end, n=0 will have the maximum profit.

Time Complexity
\mathcal{O}(n^2)O(n 
2
 ) The loop runs n times (0 to n) initially and calls the function recursively. n + (n-1) + (n-2) ...

Space Complexity
\mathcal{O}(n)O(n) The dp array is used of length n. (Ignoring the recursion stack memory)

import java.util.*;

class Solution {
    int calculate(int[] prices, int n, int[] dp) {
        if (n <= 0)
            return 0;
        if (dp[n] != 0)
            return dp[n];
        for (int i = 0; i < n; i++) {
            dp[n] = Math.max(dp[n], prices[i] + calculate(prices, n - i - 1, dp));
        }
        return dp[n];
    }
    public int solve(int[] prices, int n) {
        int[] dp = new int[n + 1];
        return calculate(prices, n, dp);
    }
}
