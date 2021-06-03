Given a list of integers prices representing the stock prices of a company in chronological order, return the maximum profit you could have made from buying and selling that stock any number of times.

You must buy before you can sell it. But you are not required to buy or sell the stock.

Constraints

0 ≤ n ≤ 100,000 where n is the length of prices
Example 1
Input
prices = [1, 5, 3, 4, 6]
Output
7
Explanation
We can buy at 1, sell at 5, buy at 3, and sell at 6.
  
  Intuition
First:

One thing to note right away is that in order to find the maximum profit, we have to look at the changes in the stock prices and if we sum up all the positive changes than we have reached maximum possible profit.

I will expand on this:
One easy way to visualize this, is to create an array that keeps the changes of the stock prices.

Example 1:

Stock prices = [ 1, 5, 3, 4, 6 ]

Changes = [ 4, -2, 1, 2 ]

( 5-1 = 4, 3-5=-2, 4-3=1, 6-4=2)

If we sum up all the positive changes, we will have the maximum possible profit. Hope this makes sense, leave a comment if you would like further explanation/help.

Next:

Although you could use an array to keep track of the changes, and then sum up the positive changes; a more memory efficient way would be to just keep a max_profit var and only add to it the positive changes.

Implementation
Iterate through the array of prices using two pointers, at one index apart.
Add to max_profit if it is a positive price chance.
Return max_profit
Time Complexity
\mathcal{O}(n)O(n) - We need to iterate one through an array of length n.

Space Complexity
\mathcal{O}(1)O(1) - We keep a variable max_profit.
  
 
  import java.util.*;

class Solution {
    public int solve(int[] prices) {
        if(prices.length==0)
            return 0;
        if(prices.length==1)
            return prices[0];
        int prev=prices[0];
        int profit=0;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]>prev){
                profit+=prices[i]-prev;
            }
            prev=prices[i];
        }
        return profit;
    }
}
