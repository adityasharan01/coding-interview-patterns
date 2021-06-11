Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 

Follow up: Could you solve it both recursively and iteratively?

//Recursion
  class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        return root==null || isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left==null && right == null){
            return true;
        }
        if((left==null&&right!=null)||(right==null&&left!=null))
            return false;
        if(left.val!=right.val){
            return false;
        }
        return isSymmetric(left.left, right.right)&&isSymmetric(left.right, right.left);
    }
}

//Iterative Solution
class Solution {
    public boolean isSymmetric(TreeNode root) {
		
		//if root is null, then tree is symmetric
        if(root == null) return true;
        
		//make arraylist to hold the nodes, starting with root
        ArrayList<TreeNode> arr = new ArrayList<>();
        arr.add(root);
		
		boolean same = false; //variable to track progress
        
		//iterate until we have no nodes left.
        while(arr.size() != 0)
        {
			//Go through the arraylist to check if the layer is symmetric
            for(int i = 0; i < arr.size() / 2; i++)
			{
				//Nodes are symmetric only if value are same or both are null. If this is true, set our progress variable to true. Otherwise, return false.
                if(arr.get(i) != null && arr.get(arr.size() - i - 1) != null && 
                   arr.get(i).val == arr.get(arr.size() - i - 1).val || arr.get(i) == null && arr.get(arr.size() - i - 1) == null) same = true;
                else return false;
            }
            
			//create a temp arraylist to hold next layer of nodes.
            ArrayList<TreeNode> temp = new ArrayList<>();
            
			//add nodes only if we are not at the end of the tree.
            for(int i = 0; i < arr.size(); i++)
            {
                if(arr.get(i) != null)
                { 
                    temp.add(arr.get(i).left);
                    temp.add(arr.get(i).right);
                }
            }
            
			//set the original arraylist to the new one we just created
            arr = temp;
        }
        
        return same;
    }
}
