

A simple solution would be to calculate the height of the left and right subtree for each node in the tree.
If for any node, the absolute difference between the height of its left and right subtree is more than 1,
the tree is unbalanced. The time complexity of this solution is O(n^2)  as there are  nodes in the tree,
and for every node, we are calculating the height of its left and right subtree that takes O(n) time.
  
  import java.util.concurrent.atomic.AtomicBoolean;
 
// A class to store a binary tree node
class Node
{
    int data;
    Node left = null, right = null;
 
    Node(int data) {
        this.data = data;
    }
}
 
class Main
{
    // Recursive function to check if a given binary tree is height-balanced or not
    public static int isHeightBalanced(Node root, AtomicBoolean isBalanced)
    {
        // base case: tree is empty or not balanced
        if (root == null || !isBalanced.get()) {
            return 0;
        }
 
        // get the height of the left subtree
        int left_height = isHeightBalanced(root.left, isBalanced);
 
        // get the height of the right subtree
        int right_height = isHeightBalanced(root.right, isBalanced);
 
        // tree is unbalanced if the absolute difference between the height of
        // its left and right subtree is more than 1
        if (Math.abs(left_height - right_height) > 1) {
            isBalanced.set(false);
        }
 
        // return height of subtree rooted at the current node
        return Math.max(left_height, right_height) + 1;
    }
 
    // The main function to check if a given binary tree is height-balanced or not
    public static boolean isHeightBalanced(Node root)
    {
        // use `AtomicBoolean` to get the result since `Boolean` is passed by value
        // in Java
        AtomicBoolean isBalanced = new AtomicBoolean(true);
        isHeightBalanced(root, isBalanced);
 
        return isBalanced.get();
    }
 
    public static void main(String[] args)
    {
        /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     /
            4   5   6
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
 
        if (isHeightBalanced(root)) {
            System.out.print("Binary tree is balanced");
        }
        else {
            System.out.print("Binary tree is not balanced");
        }
    }
}


