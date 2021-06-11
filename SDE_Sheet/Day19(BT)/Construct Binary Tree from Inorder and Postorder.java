Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.

  
//   JAVA solution | simple recursion
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd)
    {
        if (inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        int i = inStart;
		//search for the root value from the beginning of inorder array
        while(inorder[i] != postorder[postEnd])
            i++;
        
        //inorder: i is the root of the subtree, [inStart, i-1] is the left child, [i+1, inEnd] is the right child
        //postorder: postEnd is the root of the subtree,[postStart, postEnd-inEnd+i-1] is the left child, [postEnd-inEnd+i, postEnd-1] is the right child
        
        root.left = helper(inorder, inStart, i-1, postorder, postStart, postEnd-inEnd+i-1);
        root.right = helper(inorder, i+1, inEnd, postorder, postEnd-inEnd+i, postEnd-1);
        return root;
    }
}
