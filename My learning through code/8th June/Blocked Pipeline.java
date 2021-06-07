You are given an integer n and a two-dimensional list of integers requests. Consider a 2 x n matrix m
where each cell can either be blocked or unblocked. It starts off as completely unblocked. 
Each element in requests contains [row, col, type] meaning that m[row][col] becomes blocked if type = 1 and it becomes unblocked if type = 0.

You want to process requests one by one and after processing each one check whether 
there is an unblocked path from left to right. That is, whether you can start off either m[0][0] or m[1][0] and 
on each step either move right, up, or down and then end up at either m[0][n - 1] or m[1][n - 1]. 
Return the number of requests that result in such unblocked path after processing

Constraints

1 ≤ n ≤ 100,000
0 ≤ r ≤ 100,000 where r is the length of requests
Example 1
Input
n = 4
requests = [
    [0, 2, 1],
    [1, 3, 1],
    [1, 3, 0]
]
Output
2
Explanation
After setting m[0][2] there is still a path from left to right. But if we block m[1][3], there is no longer a path. 
After we unblock m[1][3], there is a path again. So the first and last request result in an unblocked path.

Hint1: 
What could be the ways to block a path in 2xN matrix? Do you sense a pattern?
Intuition
A passage is possible only if all the columns have atleast one free cell among the two rows and there no cross blockages.
A cross blockage is defined as a something like below:

000000x000000
0000000x00000

Here the two x's form a cross blockage and hence make it impossible to have a path from 1st column to last column

Implementation
Let,
freeCols => number of columns with alteast one free cell
crossBlocks => number of cross blocks like explained above

So, we iterate over the requests, and cleverly update the values of freeCols and crossBlocks.
And if we find that freeCols = n (means all columns have atleast one free cell) and crossBlocks==0 (means there are no cross blockages), then there exists a path from 1st column to last column.

Time Complexity
\mathcal{O}(n)O(n) where n is the number of columns

Space Complexity
\mathcal{O}(n)O(n) to store the cell states of the original matrix

import java.util.*;

class Solution {
    public int solve(int n, int[][] requests) {
        int[][] a = new int[2][n];

        // successfull requests
        int ans = 0;

        // free columns with no blocked cells in both rows
        int freeCols = n;

        // cross blocks like illustrated before
        // 000x000
        // 0000x00
        int crossBlocks = 0;

        for (int[] request : requests) {
            int col = request[1];
            int row = request[0];
            int type = request[2];

            if (type == 0) {
                if (a[row][col] == 1) {
                    a[row][col] = 0;
                    if (a[1 - row][col] == 1) {
                        freeCols++;
                    }
                    if (col - 1 >= 0 && a[1 - row][col - 1] == 1) {
                        crossBlocks--;
                    }
                    if (col + 1 < n && a[1 - row][col + 1] == 1) {
                        crossBlocks--;
                    }
                }
            } else {
                if (a[row][col] == 0) {
                    a[row][col] = 1;
                    if (a[1 - row][col] == 1) {
                        freeCols--;
                    }
                    if (col - 1 >= 0 && a[1 - row][col - 1] == 1) {
                        crossBlocks++;
                    }
                    if (col + 1 < n && a[1 - row][col + 1] == 1) {
                        crossBlocks++;
                    }
                }
            }

            // Passage is possible only if all cols are free and there are not crossBlocks
            if (freeCols == n && crossBlocks == 0) {
                ans++;
            }
        }

        return ans;
    }
}
//Method2 :
Intuition
Lets keep track of the totally blocked columns - that is, if we cannot access an entire column, we will add to a blocked hashset. A column is blocked if either the entire column is blocked or the there is a diagonal wall formed with the previous column.

Similarly, we can check for the reverse, if we can access a column, we will remove it from the blocked hashset.

Then, we can check if a request is valid if the blocked hashset is size 0

Implementation
The implementation is really messy and a lot of if checks. Probably look at other editorials for implementation

Time Complexity
\mathcal{O}(n)O(n) I visit every request exactly once and there are n of them

Space Complexity
\mathcal{O}(n)O(n) i store at most n columns in my blocked hashset

import java.util.*;

class Solution {
    public int solve(int n, int[][] requests) {
        int[][] grid = new int[2][n];
        int res = 0;
        int blocked = 1;
        int unblocked = 0;
        HashSet<Integer> blocks = new HashSet();

        for (int[] req : requests) {
            int row = req[0], col = req[1], type = req[2];
            if (grid[row][col] == blocked && grid[row ^ 1][col] == blocked && type == unblocked) {
                blocks.remove(col);
            }
            grid[row][col] = type;

            if (col + 1 < n) {
                if (grid[row][col] == blocked && grid[row ^ 1][col + 1] == blocked) {
                    blocks.add(col + 1);
                } else if (grid[row ^ 1][col] == blocked && grid[row][col + 1] == blocked) {
                    blocks.add(col + 1);
                } else if (grid[row][col + 1] == unblocked && grid[row][col] == unblocked) {
                    blocks.remove(col + 1);
                } else if (grid[row ^ 1][col + 1] == unblocked && grid[row ^ 1][col] == unblocked) {
                    blocks.remove(col + 1);
                } else if (grid[row ^ 1][col + 1] == unblocked && grid[row][col] == unblocked) {
                    blocks.remove(col + 1);
                } else if (grid[row][col + 1] == unblocked && grid[row ^ 1][col] == unblocked) {
                    blocks.remove(col + 1);
                }
            }

            if (col - 1 >= 0) {
                if (grid[row][col] == blocked && grid[row ^ 1][col - 1] == blocked) {
                    blocks.add(col);
                } else if (grid[row ^ 1][col] == blocked && grid[row][col - 1] == blocked) {
                    blocks.add(col);
                } else if (grid[row][col - 1] == unblocked && grid[row][col] == unblocked) {
                    blocks.remove(col);
                } else if (grid[row ^ 1][col - 1] == unblocked && grid[row ^ 1][col] == unblocked) {
                    blocks.remove(col);
                } else if (grid[row ^ 1][col - 1] == unblocked && grid[row][col] == unblocked) {
                    blocks.remove(col);
                } else if (grid[row][col - 1] == unblocked && grid[row ^ 1][col] == unblocked) {
                    blocks.remove(col);
                }
            }
            if (grid[row ^ 1][col] == blocked && grid[row][col] == blocked) {
                blocks.add(col);
            }

            if (blocks.size() == 0)
                res++;
        }
        return res;
    }
}

