Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
  JAVA Approach :-
   * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static boolean validate(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max){
            return false;
        }
        // left subtree must be < root.val && right subtree must be > root.val
        return validate(root.left, min, (long)root.val - 1) && validate(root.right, (long)root.val + 1, max);
    }
}


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def isValidBST(self, root: TreeNode) -> bool:
        def helper(root, min_val, max_val):
            if not root:
                return True
            if root.val <= min_val or root.val >= max_val:
                return False
            return helper(root.left, min_val, root.val) and helper(root.right, root.val, max_val)
        return helper(root, -float('inf'), float('inf'))
