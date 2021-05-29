Greedy algorithm to find minimum number of coins

Given a value V, if we want to make a change for V Rs, and we have an infinite supply of each of the denominations in Indian currency, i.e., we have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, what is the minimum number of coins and/or notes needed to make the change?

Examples:  

Input: V = 70
Output: 2
We need a 50 Rs note and a 20 Rs note.

Input: V = 121
Output: 3
We need a 100 Rs note, a 20 Rs note and a 1 Rs coin.
  
  Solution: Greedy Approach.
Approach: A common intuition would be to take coins with greater value first. This can reduce the total number of coins needed. Start from the largest possible denomination and keep adding denominations while the remaining value is greater than 0. 

Algorithm:  

Sort the array of coins in decreasing order.
Initialize result as empty.
Find the largest denomination that is smaller than current amount.
Add found denomination to result. Subtract value of found denomination from amount.
If amount becomes 0, then print result.
Else repeat steps 3 and 4 for new value of V.

  import java.util.Vector;
 
class GFG
{
 
    // All denominations of Indian Currency
    static int deno[] = {1, 2, 5, 10, 20,
    50, 100, 500, 1000};
    static int n = deno.length;
 
    static void findMin(int V)
    {
        // Initialize result
        Vector<Integer> ans = new Vector<>();
 
        // Traverse through all denomination
        for (int i = n - 1; i >= 0; i--)
        {
            // Find denominations
            while (V >= deno[i])
            {
                V -= deno[i];
                ans.add(deno[i]);
            }
        }
 
        // Print result
        for (int i = 0; i < ans.size(); i++)
        {
            System.out.print(
                " " + ans.elementAt(i));
        }
    }
 
    // Driver code
    public static void main(String[] args)
    {
      Complexity Analysis: 

Time Complexity: O(V).
Auxiliary Space: O(1) as no additional space is used.
Note: The above approach may not work for all denominations. For example, it doesn’t work for denominations {9, 6, 5, 1} and V = 11. The above approach would print 9, 1 and 1. But we can use 2 denominations 5 and 6. 
For general input, below dynamic programming approach can be used: 
        int n = 93;
        System.out.print(
            "Following is minimal number "
            +"of change for " + n + ": ");
        findMin(n);
    }
}
Complexity Analysis: 

Time Complexity: O(V).
Auxiliary Space: O(1) as no additional space is used.
Note: The above approach may not work for all denominations. For example, it doesn’t work for denominations {9, 6, 5, 1} and V = 11. The above approach would print 9, 1 and 1. But we can use 2 denominations 5 and 6. 
For general input, below dynamic programming approach can be used: 
