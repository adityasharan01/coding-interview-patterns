An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.
  
Example 1:


Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
Output: [[2,2,2],[2,2,2]]
 

Constraints:

m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], newColor < 216
0 <= sr < m
0 <= sc < n
Hint1:Write a recursive function that paints the pixel if it's the correct color, then recurses on neighboring pixels.
The basic idea is to check all the adjacent (4-directionally) nodes of the present node are of same color. if so, change them to the newColor.

public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //make sure current color is different from newColor
        if(image[sr][sc] == newColor)
            return image;
        //dfs util
        dfs(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
    
     void dfs(int[][] g, int i, int j, int current, int newColor) {
         //either of these two checks can be used.
         
    // if (Math.min(i, j) < 0 || Math.max(i, j) >= g.length || g[i][j] != 0)
    //     return ;
    
         //every time you traverse, make sure the color is same as the current color so that it can be changed to the newColor.
        if(i<0 || j<0 || i>=g.length || j>=g[0].length || g[i][j] != current)
            return;
    g[i][j] = newColor;
    dfs(g, i - 1, j, current, newColor);
    dfs(g, i + 1, j, current, newColor);
    dfs(g, i, j - 1, current, newColor);
    dfs(g, i, j + 1, current, newColor);
     return;
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private int[] dr = new int[] {-1, 0, 1, 0};
    private int[] dc = new int[] {0, 1, 0, -1};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] != newColor) {
            floodFill(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }
    
    private void floodFill(int[][] image, int xCoordinate, int yCoordinate, int oldColor, int newColor) {
        
        image[xCoordinate][yCoordinate] = newColor;
        
        for(int i = 0; i < dr.length; ++i) {
            int x = xCoordinate + dr[i];
            int y = yCoordinate + dc[i];
            
            if(x >= 0 && 
               y >= 0 && 
               x < image.length && 
               y < image[x].length && 
               image[x][y] == oldColor) {
                floodFill(image, x, y, oldColor, newColor);
            }
        }
    }
