You are given two lists of integers weights and values which have the same length and an integer capacity. weights[i] and values[i] represent the weight and value of the ith item.

Given that you can take at most capacity weights, and that you can only take at most one copy of each item, return the maximum amount of value you can get.

Constraints

n ≤ 250 where n is the length of weights and values
capacity ≤ 250
Example 1
Input
weights = [1, 2, 3]
values = [1, 5, 3]
capacity = 5
Output
8

Hint1:Similar to original knapsack, but how do you ensure the specific element is only included once?
 
Intuition
Dynamic Programming : Bottom up approach with 2D DP matrix

Implementation
Just like any other DP problems we would start with

Defining dp state : dp[idx][capacity] represents the maximum value one can obtain till index idx with capacity "capacity"

Define DP state transition: How dp[idx][capacity] can be reached based on values from the previous DP states
Here at any index idx , there are two possibility
--- if(weight[idx] > capacity) then i can not choose the current element and hence whatever is the maximum for that capacity till the previous index will be the ans here
---- if weight[idx] <= capacity: i can choose or i can choose to ignore. Value for that dp state would be Max of the values b/w

dp[idx-1][capacity] : Ignore the current
value[idx] + dp[idx-1][capacity-weight[idx] : Include the current which will contribute to the value[idx] and it has to come via the dp state dp[i-1][c-w[i] as part of state transition
Time Complexity
\mathcal{O}(N*C)O(N∗C) For each elem we have to know values for the all the capacity values (1 to capacity) so that it would be usefull in dp state transition

Space Complexity
\mathcal{O}(N*C)O(N∗C) As 2D matrix is used to store the dp[state] for each vaue of idx and capacity

import java.util.*;

class Solution {
    public int solve(int[] weights, int[] values, int capacity) {
        if (weights == null || values == null || weights.length == 0 || values.length == 0)
            return 0;
        int[][] dp = new int[weights.length][capacity + 1];
        dp[0][0] = 0;
        for (int j = 1; j <= capacity; j++) {
            dp[0][j] = (weights[0] <= j) ? values[0] : 0;
        }
        for (int i = 1; i < weights.length; i++) {
            for (int weight = 0; weight <= capacity; weight++) {
                if (weights[i] > weight)
                    dp[i][weight] = dp[i - 1][weight];
                else
                    dp[i][weight] =
                        Math.max(dp[i - 1][weight], values[i] + dp[i - 1][weight - weights[i]]);
            }
        }
        return dp[weights.length - 1][capacity];
    }
}
