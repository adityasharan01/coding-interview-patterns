Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100
  
  For all cells in 1st row or column, since there is only 1 possible path so calculate cumulative sum for every cell,i.e., add prev cell's value.
For rest of the cells, just pick minimum of top row or left column & add with current cell's value.

public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        for(int i = 1; i < c; i++) grid[0][i] += grid[0][i - 1];
        for(int i = 1; i < r; i++) grid[i][0] += grid[i - 1][0];
        for(int i = 1; i < r; i++)
            for(int j = 1; j < c; j++) 
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        return grid[r - 1][c - 1];
    }
Runtime: 4 ms
Memory Usage: 43.3 MB

Time complexity : O(mn)
Space complexity : O(1), since using input array
