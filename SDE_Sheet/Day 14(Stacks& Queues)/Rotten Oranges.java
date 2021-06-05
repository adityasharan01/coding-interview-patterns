You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
  
  
  class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        //if count of fresh oranges is zero --> return 0 
        if(count_fresh == 0) return 0;
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int dir[] : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    //if x or y is out of bound
                    //or the orange at (x , y) is already rotten
                    //or the cell at (x , y) is empty
                        //we do nothing
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    //mark the orange at (x , y) as rotten
                    grid[x][y] = 2;
                    //put the new rotten orange at (x , y) in queue
                    queue.offer(new int[]{x , y});
                    //decrease the count of fresh oranges by 1
                    count_fresh--;
                }
            }
        }
        return count_fresh == 0 ? count-1 : -1;
    }
}

///////////////////////////////////////////////////////////////SOLUTION 2///////////////////////////////////////////////////////////
class Solution {
    public int orangesRotting(int[][] grid) {
        //bfs, 1 find all rotten == 2
        //put 2 into a queue
        //each time poll 2 then go four directions, if next is 1, change to 2, put back to queue
        //if queue is empty, check if there is still 1
        
        Queue<int[]> qu = new LinkedList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    qu.offer(new int[]{i, j});
                }
            }
        }
        
        int[][] direction = {{1,0}, {0,1}, {0,-1}, {-1, 0}};
        
        int level = 0;
        while (!qu.isEmpty()) {
            level++;
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = qu.poll();
                for (int[] dir : direction) {
                    int nx = dir[0] + rotten[0];
                    int ny = dir[1] + rotten[1];
                    
                    if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || grid[nx][ny] != 1)
                        continue;
                    
                    grid[nx][ny] = 2;
                    qu.offer(new int[]{nx, ny});
                }        
            }
        }
        
        for (int[] x : grid) {
            for (int y : x) {
                if (y == 1)
                    return -1;
            }
        }

        return level == 0 ? 0 : level - 1;
    }
}
