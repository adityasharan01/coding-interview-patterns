Stock buy and sell

The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.
Note: There may be multiple possible solutions. Return any one of them.

Example 1:

Input:
N = 7
A[] = {100,180,260,310,40,535,695}
Output:
1
Explanation:
One possible solution is (0 3) (4 6)
We can buy stock on day 0,
and sell it on 3rd day, which will 
give us maximum profit. Now, we buy 
stock on day 4 and sell it on day 6.
Example 2:

Input:
N = 5
A[] = {4,2,2,2,4}
Output:
1
Explanation:
There are multiple possible solutions.
one of them is (3 4)
We can buy stock on day 3,
and sell it on 4th day, which will 
give us maximum profit.

Your Task:
The task is to complete the function stockBuySell() which takes an array A[] and N as input parameters and finds the days of buying and selling stock. The function must return a 2D list of integers containing all the buy-sell pairs. If there is No Profit, return an empty list. The driver code will return 1 if your answer is correct, otherwise, it will return 0. In case there's no profit the driver code will return the string "No Profit" for a correct solution.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
2 ≤ N ≤ 106
0 ≤ A[i] ≤ 106
  
 Naive approach: A simple approach is to try buying the stocks and selling them on every single day when profitable and keep updating the maximum profit so far.
   // Java implementation of the approach
import java.util.*;

class GFG
{

// Function to return the maximum profit
// that can be made after buying and
// selling the given stocks
static int maxProfit(int price[], int start, int end)
{

    // If the stocks can't be bought
    if (end <= start)
        return 0;

    // Initialise the profit
    int profit = 0;

    // The day at which the stock
    // must be bought
    for (int i = start; i < end; i++) 
    {

        // The day at which the
        // stock must be sold
        for (int j = i + 1; j <= end; j++)
        {

            // If byuing the stock at ith day and
            // selling it at jth day is profitable
            if (price[j] > price[i]) 
            {

                // Update the current profit
                int curr_profit = price[j] - price[i]
                                + maxProfit(price, start, i - 1)
                                + maxProfit(price, j + 1, end);

                // Update the maximum profit so far
                profit = Math.max(profit, curr_profit);
            }
        }
    }
    return profit;
}

// Driver code
public static void main(String[] args)
{
    int price[] = { 100, 180, 260, 310,
                    40, 535, 695 };
    int n = price.length;

    System.out.print(maxProfit(price, 0, n - 1));
}
}

Efficient approach: If we are allowed to buy and sell only once, then we can use following algorithm. Maximum difference between two elements. Here we are allowed to buy and sell multiple times. 
Following is algorithm for this problem.  


Find the local minima and store it as starting index. If not exists, return.
Find the local maxima. and store it as ending index. If we reach the end, set the end as ending index.
Update the solution (Increment count of buy sell pairs)
Repeat the above steps if end is not reached.
  
import java.util.ArrayList;

// Solution structure
class Interval {
    int buy, sell;
}

class StockBuySell {
    // This function finds the buy sell schedule for maximum profit
    void stockBuySell(int price[], int n)
    {
        // Prices must be given for at least two days
        if (n == 1)
            return;

        int count = 0;

        // solution array
        ArrayList<Interval> sol = new ArrayList<Interval>();

        // Traverse through given price array
        int i = 0;
        while (i < n - 1) {
            // Find Local Minima. Note that the limit is (n-2) as we are
            // comparing present element to the next element.
            while ((i < n - 1) && (price[i + 1] <= price[i]))
                i++;

            // If we reached the end, break as no further solution possible
            if (i == n - 1)
                break;

            Interval e = new Interval();
            e.buy = i++;
            // Store the index of minima

            // Find Local Maxima.  Note that the limit is (n-1) as we are
            // comparing to previous element
            while ((i < n) && (price[i] >= price[i - 1]))
                i++;

            // Store the index of maxima
            e.sell = i - 1;
            sol.add(e);

            // Increment number of buy/sell
            count++;
        }

        // print solution
        if (count == 0)
            System.out.println("There is no day when buying the stock "
                               + "will make profit");
        else
            for (int j = 0; j < count; j++)
                System.out.println("Buy on day: " + sol.get(j).buy
                                   + "        "
                                   + "Sell on day : " + sol.get(j).sell);

        return;
    }

    public static void main(String args[])
    {
        StockBuySell stock = new StockBuySell();

        // stock prices on consecutive days
        int price[] = { 100, 180, 260, 310, 40, 535, 695 };
        int n = price.length;

        // fucntion call
        stock.stockBuySell(price, n);
    }
}

