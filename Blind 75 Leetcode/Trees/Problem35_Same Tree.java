Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false
 

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
  
  
 Approach :
As long as the p and q are not null and p.val == q.val are the same,
then continue the recursion by traversing the left node and right node of those trees.
Else, we return p == q which checks the p and q are null.
Either one of them is not equal, then return false.
  
Java Code :

public boolean isSameTree(TreeNode p, TreeNode q) {
	if (p != null && q != null && p.val == q.val)
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	return p == q;
}
