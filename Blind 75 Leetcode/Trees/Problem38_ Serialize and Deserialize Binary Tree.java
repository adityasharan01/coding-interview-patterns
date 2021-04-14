Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:

Input: root = [1,2]
Output: [1,2]
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
  
  ///////////////////////////////////
  Easy-Understanding level-order traversal solution using queue
  
  public class Codec {
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr != null) {
                res.append(curr.val + " ");
                queue.offer(curr.left);
                queue.offer(curr.right);
            } else {
                res.append("null ");
            }
        }

        return res.toString();
    }


    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;

        String[] info = data.split(" ");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(info[0]));
        queue.offer(root);

        for(int i = 1; i < info.length; i = i + 2) {
            TreeNode parent = queue.poll();
            
            int leftIndex = i, rightIndex = i + 1;
            if(!info[leftIndex].equals("null")) {
                TreeNode left = new TreeNode(Integer.valueOf(info[leftIndex]));
                parent.left = left;
                queue.add(left);
            }
            if(!info[rightIndex].equals("null")) {
                TreeNode right = new TreeNode(Integer.valueOf(info[rightIndex]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
  
  
