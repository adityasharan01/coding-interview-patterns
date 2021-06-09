
Instead of calculating the height of the left and the right subtree for every node in the tree, get the height in constant time.
The idea is to start from the bottom of the tree and return the height of the subtree rooted at a given node to its parent.
The height of a subtree rooted at any node is one more than the maximum height of the left or right subtree.
  

A simple solution would be to calculate the left and right subtree’s height for each node in the tree. The maximum node path
 that passes through a node will have a value one more than the sum of the height of its left and right subtree.
  Finally, the diameter is maximum among all maximum node paths  for every node in the tree. The time complexity of this solution is 
   as there are  nodes in the tree, and for every node, we are calculating the height of its left and right subtree that takes O(n)  time.
     
 import java.util.concurrent.atomic.AtomicInteger;
 
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
    // Function to find the diameter of the binary tree. Note that the
    // function returns the height of the subtree rooted at a given node,
    // and the diameter is updated within the function as it is passed by
    // reference using the `AtomicInteger` class.
    public static int getDiameter(Node root, AtomicInteger diameter)
    {
        // base case: tree is empty
        if (root == null) {
            return 0;
        }
 
        // get heights of left and right subtrees
        int left_height = getDiameter(root.left, diameter);
        int right_height = getDiameter(root.right, diameter);
 
        // calculate diameter "through" the current node
        int max_diameter = left_height + right_height + 1;
 
        // update maximum diameter (note that diameter "excluding" the current
        // node in the subtree rooted at the current node is already updated
        // since we are doing postorder traversal)
        diameter.set(Math.max(diameter.get(), max_diameter));
 
        // it is important to return the height of the subtree rooted at the
        // current node
        return Math.max(left_height, right_height) + 1;
    }
 
    public static int getDiameter(Node root)
    {
        AtomicInteger diameter = new AtomicInteger(0);
        getDiameter(root, diameter);
 
        return diameter.get();
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        System.out.print("The diameter of the tree is " + getDiameter(root));
    }
}   
