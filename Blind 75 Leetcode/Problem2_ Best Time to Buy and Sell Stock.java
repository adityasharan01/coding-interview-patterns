You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
  
  
Approach:-
  
  
class Main
{
    // Function to find the maximum profit earned by buying and
    // selling shares any number of times
    public static int findMaxProfit(int[] price)
    {
        // keep track of the maximum profit gained
        int profit = 0;
 
        // initialize the local minimum to the first element's index
        int j = 0;
 
        // start from the second element
        for (int i = 1; i < price.length; i++)
        {
            // update the local minimum if a decreasing sequence is found
            if (price[i - 1] > price[i]) {
                j = i;
            }
 
            // sell shares if the current element is the peak,
            // i.e., (`previous <= current > next`)
            if (price[i - 1] <= price[i] &&
                (i + 1 == price.length || price[i] > price[i + 1]))
            {
                profit += (price[i] - price[j]);
                System.out.printf("Buy on day %d and sell on day %d\n", j + 1, i + 1);
            }
        }
 
        return profit;
    }
 
    public static void main(String[] args)
    {
        int[] price = { 1, 5, 2, 3, 7, 6, 4, 5 };
 
        System.out.print("\nTotal profit earned is " + findMaxProfit(price));
    }
}


Approach 2:-

public int maxProfit(int[] prices) {
            int ans=0;
            if(prices.length==0)
            {
                return ans;
            }
            int bought=prices[0];                                
            for(int i=1;i<prices.length;i++)
            {
                if(prices[i]>bought)
                {
                    if(ans<(prices[i]-bought))
                    {
                        ans=prices[i]-bought;
                    }
                }
                else
                {
                    bought=prices[i];
                }
            }
     return ans;
}
