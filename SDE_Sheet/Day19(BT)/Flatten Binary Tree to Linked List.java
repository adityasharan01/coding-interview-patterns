Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 

Follow up: Can you flatten the tree in-place (with O(1) extra space)?
Hint1:If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

//JAVA Recursion
class Solution {
    public void flatten(TreeNode root) {
        inOrderTraversal(root);
    }
    
    private void inOrderTraversal(TreeNode root){
        if(root == null || (root.left == null && root.right == null))
            return;

		// Store the right node for specific level
		// go as left as possible, (storing the right val in Stack)

		if(root.left != null){
            inOrderTraversal(root.left);
            TreeNode rightNode = root.right;
            root.right =  root.left;
            root.left = null;
            while(root.right != null)
                root = root.right;
				
				// bring back thre right node, once all processing under left node is done
            root.right = rightNode;
        }
        inOrderTraversal(root.right);
    }
}
