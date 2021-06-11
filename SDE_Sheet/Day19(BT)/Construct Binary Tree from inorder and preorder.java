Construct Binary Tree from inorder and preorder
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
  
  
class Solution {
    
    private int preStart = 0;
    private Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
	
		//fill the values in map for O(1) retrieval
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(0, inorder.length - 1, preorder, inorder);
    }
    
    private TreeNode helper(int inStart, int inEnd, int[] preorder, int[] inorder){
        if(inStart > inEnd){
            return null;
        }
        
		//create the root node with element in preOrder array at preStart
        TreeNode root = new TreeNode(preorder[preStart]);
        
		/*
		 * find the index of root element in the map to divide the problem
		 * into left and right sub-problems (sub-arrays)
		 */
        int inIndex = map.get(preorder[preStart++]);
		
		//get the left and right nodes
        root.left = helper(inStart, inIndex -1, preorder, inorder);
        root.right = helper(inIndex + 1, inEnd, preorder, inorder);
        
        return root;
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd)
    {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int i = inEnd;
		//searching backwards for the root value in inorder traversal array
        while(inorder[i] != preorder[preStart])
            i--;
        //inorder : i is the root for the subtree, [inStart, i-1] is the left child, [i+1, inEnd] is the right child
        //preorder: preStart is the root of the subtree, [preStart+1, preStart+i-inStart] is the left child, and [preStart+i-inStart+1, preEnd] is the right child
        
        root.left = helper(preorder, preStart+1, preStart+i-inStart, inorder, inStart, i-1);
        root.right = helper(preorder, preStart+i-inStart+1, preEnd, inorder, i+1, inEnd);
        return root;
    }
}
