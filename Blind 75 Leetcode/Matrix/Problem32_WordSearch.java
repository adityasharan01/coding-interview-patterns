Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
  Java Approach:
class Solution {
  public boolean exist(char[][] board, String word) {
      
    /*
    Idea: Backtracking
    
    -> Iterate through each cell in the matrix & check if char matches index 0 of word
            -> if yes - increment index & find the boundary cells (top, down, bottom, left) to find the char at index 1 of word
            -> if No - return false;
    
    -> Keep visited matrix to avoid recounting visited cells & eliminating endless loop
            -> eg  [["a","a"]]   find if "aaaaaaaa" exists would return Yes without visited matrix but its a No.
    
    -> check for boundary conditions at each stage !important
    
    */
      
    boolean[][] visited = new boolean[board.length][board[0].length];
    int index = 0;
      
    // iterate all cells
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {

        if(findWordInBoard(board, word, visited, index, i, j))
        {
            return true;
        }
      }
    }
    return false;
  }
    
  // recursive calls for each cell
  public boolean findWordInBoard(char[][] board, String word, boolean[][] visited, int index, int i, int j) {
      
    // terminating condition if length of index reaches lenght of word
    if (index == word.length()) {
      return true;
    }

    // else check bounds & if already visited
    if (!withinBounds(i, j, board.length, board[0].length) || visited[i][j]) {
      return false;
    }

    // check index char
    char cell = board[i][j];
    char indexChar = word.charAt(index);

    // mismatch
    if (cell != indexChar) {
      return false;
    }

    // visit this cell if matched
    visited[i][j] = true;

    // check boundary chars
    if (findWordInBoard(board, word, visited, index + 1, i - 1, j)) return true;

    if (findWordInBoard(board, word, visited, index + 1, i + 1, j)) return true;

    if (findWordInBoard(board, word, visited, index + 1, i, j - 1)) return true;

    if (findWordInBoard(board, word, visited, index + 1, i, j + 1)) return true;

    // unvisit cell - after checking all possibilites (would not come here if a valid answer existed using this cell 
    // else clear up visiting for checking with other cells)
    visited[i][j] = false;

    return false;
  }

  // boundary condition checks
  public boolean withinBounds(int i, int j, int rows, int cols) {
    if (i < rows && i >= 0 && j < cols && j >= 0) {
      return true;
    }

    return false;
  }
}
  
  Python Approach:

  class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        def dfs(board, i, j, word, word_position):
            # if the length of the word reaches word position, means, we found the word :)
            if len(word) == word_position:
                return True
            
            # if position of the value that is being searched is outside of the board's boundary 
            # or it is not mathing with the character being searched no point is continuing the search, so, Just return false
            if (i<0 or i>=len(board)) or j<0 or j>=len(board[0]) or board[i][j] != word[word_position]:
                return False

            temp = board[i][j]
            board[i][j]= "#"
            
            # search for the next letter in all the direction from current position
            result = \
            dfs(board, i-1, j, word, word_position+1) or \
            dfs(board, i+1, j, word, word_position+1) or \
            dfs(board, i, j+1, word, word_position+1) or \
            dfs(board, i, j-1, word, word_position+1)
            
            board[i][j]= temp

            return result

        # search for the first character of the word in the board, Once found see if the word in present using dfs approach    
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    result = dfs(board, i, j, word, 0)
                    
                    if result:
                        return True
        
        # If no complete word is not found, return False which means word is not found
        return False
