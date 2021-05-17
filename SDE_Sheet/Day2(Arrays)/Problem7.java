Set Matrix Zeroes
Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]


//Approach:
public void setZeroes(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length, k = 0;
    // First row has zero?
    while (k < n && matrix[0][k] != 0) ++k;
    // Use first row/column as marker, scan the matrix
    for (int i = 1; i < m; ++i)
        for (int j = 0; j < n; ++j)
            if (matrix[i][j] == 0)
                matrix[0][j] = matrix[i][0] = 0;
    // Set the zeros
    for (int i = 1; i < m; ++i)
        for (int j = n - 1; j >= 0; --j)
            if (matrix[0][j] == 0 || matrix[i][0] == 0)
                matrix[i][j] = 0;
    // Set the zeros for the first row
    if (k < n) Arrays.fill(matrix[0], 0);
}
