A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
  
  Here's my ideas:

A path from start to end, goes up on the tree for 0 or more steps, then goes down for 0 or more steps. Once it goes down, it can't go up. Each path has a highest node, which is also the lowest common ancestor of all other nodes on the path.
A recursive method maxPathDown(TreeNode node) (1) computes the maximum path sum with highest node is the input node, update maximum if necessary (2) returns the maximum sum of the path that can be extended to input node's parent.
Code:

public class Solution {
    int maxValue;
    
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
/////////////////////////////////////////////
This is quite a tricky problem where we have to consider the various edge-cases.
We need to remember that we are looking for a SINGLE PATH hence we to previous call we need to pass the maximum of either our left or right sub-tree but not both because then we would end up having multiple paths.

However, for calculating the sum for current node we consider both the left and right traversals along with the current node value.

You have to notice that we are using a global variable to keep track of the maximum sum of path so far because we can't return to our previous call.
This is the important part of this solution.
This lets us keep track of the linkage of sub-paths.

This is a bit hard to understand but try reviewing it and you'll understand it.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: TreeNode) :
        self.ans = -float('inf')
        
        def path(root):
            if not root:
                return 0
            left = max(path(root.left),0)
            right = max(path(root.right),0)
            val = root.val
            self.ans = max(self.ans,val+left+right)
            return val+max(left,right)
        
        path(root)
        return self.ans
