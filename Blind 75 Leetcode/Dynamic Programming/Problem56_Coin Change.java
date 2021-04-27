You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

Bottom Up Approach (1D)
Suggestion :-
the basic approach is to judge Math.min(1+dp[i],dp[coins[j]+i]) on each iteration
Do a dry run once for making it clear, take 1D array and iterate according to given algorithm

class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        
        for(int i=0;i<=amount;i++){
            dp[i]=-1;
        }
        System.out.println(Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<=amount;i++){
            if(dp[i]!=-1){
                for(int j=0;j<coins.length;j++){
                    if(coins[j]+i<=amount && coins[j]!=Integer.MAX_VALUE){             
                        int min=dp[i]+1;
                        if(dp[coins[j]+i]!=-1){
                            dp[coins[j]+i]=Math.min(dp[coins[j]+i],min);
                        }else{
                            dp[coins[j]+i]=min;
                        }}
                    }
                }
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
}
