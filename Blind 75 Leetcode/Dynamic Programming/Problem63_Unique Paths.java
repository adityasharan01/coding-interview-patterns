A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6
 

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 109.
 
 
 Similar questions:
91. Decode Ways
70. Climbing Stairs
509. Fibonacci Number

Practice them in a row for better understanding 😉

public class Solution {
public int uniquePaths(int m, int n) {
    int[][] grid = new int[m][n];
    for(int i = 0; i<m; i++){
        for(int j = 0; j<n; j++){
            if(i==0||j==0)
                grid[i][j] = 1;
            else
                grid[i][j] = grid[i][j-1] + grid[i-1][j];
        }
    }
    return grid[m-1][n-1];
}
}

Memoization approach:
Here, we store the value for number of unique paths calculated for cell(i, j), so that if we encounter same subproblem in further recursive calls, we can directly use the calculated value instead of re-calculating for that cell.

class Solution {
    private Map<String, Integer> map = new HashMap<String, Integer>();
    public int uniquePaths(int m, int n) {
        // base case       
        if(m == 1 || n == 1) return 1;
        
        // check if we have already calculated unique paths for cell(m, n)
        String cell = new String(m + "," + n);
        // if yes, then get its value from our memoization table
        if(map.containsKey(cell)) 
            return map.get(cell);
        
        // else, explore the down move
        int downMove = uniquePaths(m-1, n);
        // explore the right move
        int rightMove = uniquePaths(m, n-1);
        
        // put the value obtained for unique paths from cell(m, n)
        map.put(cell, downMove + rightMove);
        
        return downMove + rightMove;
    }    
}
DP approach:
Using DP, we find the number of unique paths from a given cell is equal to as the sum of the values of its previous possible states.
dp[i,j] = dp[i-1,j] + dp[i,j-1] gives us the idea. To reach the position (i, j), the path should either be coming from (i-1, j) or (i, j-1).

Now, we can tabulate number of paths in two methods:

We start from top-left corner i.e. (0, 0) and finding paths in forward approach by using the formula dp[i][j] = dp[i-1][j] + dp[i][j-1]. The base case here is when i == 0 || j == 0, dp[i][j] = 1. Here, dp[i][j] represents the number of paths from cell (0, 0) to cell (i, j).
image

We will start from the bottom-right corner (m, n) and find finding paths using backward approach using the formula dp[i][j] = dp[i+1][j] + dp[i][j+1], where m = no. of rows and n = no. of columns. The base case here is when i == m-1 || j == n-1, dp[i][j] = 1. Here, dp[i][j]  represents the number of paths from cell (m, n) to cell (i, j).
image

Method 1:

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
Method 2:

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 || j == n - 1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}

Link: -https://leetcode.com/problems/unique-paths/discuss/1175465/Java-oror-3-approaches
