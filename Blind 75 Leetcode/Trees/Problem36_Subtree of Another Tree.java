Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
 

Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
     
   APPROACH:
For each node during pre-order traversal of s, use a recursive function isSame to validate if sub-tree started with this node is the same with t.

public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        
        if (s.val != t.val) return false;
        
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
//////////////////////////////////////////
class Solution:
    def isSubtree(self, s: TreeNode, t: TreeNode) -> bool:
        if not s: 
            return False
        if self.isSameTree(s, t): 
            return True
        return self.isSubtree(s.left, t) or self.isSubtree(s.right, t)

    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        if p and q:
            return p.val == q.val and self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)
        return p is q
        /////////////////////////////////////
     
 import java.util.ArrayList;
import java.util.List;
 
// A class to store a binary tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
 
    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
 
class Main
{
    // Function to store inorder traversal on the tree in a list
    public static void inorder(Node node, List<Node> list)
    {
        if (node == null) {
            return;
        }
 
        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }
 
    // Function to store postorder traversal on the tree in a list
    public static void postorder(Node node, List<Node> list)
    {
        if (node == null) {
            return;
        }
 
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node);
    }
 
    // Utility function to convert the list to a string and remove opening &
    // closing brackets from it
    public static String toString(List<Node> list)
    {
        if (list == null) {
            return "";
        }
        return list.toString().replace("[", "").replace("]", "");
    }
 
    // Function to check if a given binary tree is a subtree of another
    // binary tree or not
    public static boolean checkSubtree(Node tree, Node subtree)
    {
        // base case: both trees are the same
        if (tree == subtree) {
            return true;
        }
 
        // base case: if the first tree is empty but the second tree is non-empty
        if (tree == null) {
            return false;
        }
 
        // store the inorder traversal of both trees in `first` and `second`,
        // respectively
        List<Node> first = new ArrayList<>(), second = new ArrayList<>();
        inorder(tree, first);
        inorder(subtree, second);
 
        // return false if the second list is not a sublist of the first list
        if (!toString(first).contains(toString(second))) {
            return false;
        }
 
        // reset both lists
        first.clear();
        second.clear();
 
        // Now store postorder traversal of both trees in `first` and `second`,
        // respectively
        postorder(tree, first);
        postorder(subtree, second);
 
        // return false if the second list is not a sublist of the first list
        if (!toString(first).contains(toString(second))) {
            return false;
        }
 
        return true;
    }
 
    public static void main(String[] args)
    {
        /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        if (checkSubtree(root, root.right)) {
            System.out.print("Yes");
        }
        else {
            System.out.print("No");
        }
    }
}
