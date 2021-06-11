Binary Tree Maximum Path Sum
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

A path from start to end, goes up on the tree for 0 or more steps, then goes down for 0 or more steps. 
  Once it goes down, it can't go up. Each path has a highest node, 
  which is also the lowest common ancestor of all other nodes on the path.
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
//////////////////////////////////////////////////////////////////////////////////////////////////////
The idea of mine approach is similar to recursive solutions which can be found in other posts but made in iterative manner. We just need to traverse the nodes in post-order (the same as the order of topological sorting, actually) storing the maximum root paths in a cache and updating the result value. Here's how it looks like in Java:

// just returns the nodes in post-order
public Iterable<TreeNode> topSort(TreeNode root) {
    Deque<TreeNode> result = new LinkedList<>();
    if (root != null) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.push(curr);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }
    return result;
}

public int maxPathSum(TreeNode root) {
    int result = Integer.MIN_VALUE;
    Map<TreeNode, Integer> maxRootPath = new HashMap<>(); // cache
    maxRootPath.put(null, 0); // for simplicity we want to handle null nodes
    for (TreeNode node : topSort(root)) {
        // as we process nodes in post-order their children are already cached
        int left = Math.max(maxRootPath.get(node.left), 0);
        int right = Math.max(maxRootPath.get(node.right), 0); 
        maxRootPath.put(node, Math.max(left, right) + node.val);
        result = Math.max(left + right + node.val, result);
    }
    return result;
}
