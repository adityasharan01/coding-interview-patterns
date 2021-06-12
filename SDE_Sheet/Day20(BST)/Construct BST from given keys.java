Construct BST from given keys.
Given an unsorted integer array that represents binary search tree keys,construct a height balanced BST from it.

  Intuition:
 The height of such BST in the worst-case can be as much as the total number of keys in the BST.
  The worst case happens when given keys are sorted in ascending or descending order, 
and we get a skewed tree where all the nodes except the leaf have one and only one child.

For height-balanced BSTs, with each comparison, skip about half of the tree 
so that each insertion operation takes time proportional to the logarithm of the total number of items .
  
  
We can easily modify the solution to get height-balanced BSTs if all keys are known in advance. The idea is to 
sort the given keys.

import java.util.Arrays;
 
// A class to store a BST node
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
    // Function to perform inorder traversal on the tree
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
 
    // Function to construct balanced BST from the given sorted array
    public static Node convert(int[] keys, int low, int high, Node root)
    {
        // base case
        if (low > high) {
            return root;
        }
 
        // find the middle element of the current range
        int mid = (low + high) / 2;
 
        // construct a new node from the middle element and assign it to the root
        root = new Node(keys[mid]);
 
        // left subtree of the root will be formed by keys less than middle element
        root.left = convert(keys, low, mid - 1, root.left);
 
        // right subtree of the root will be formed by keys more than the
        // middle element
        root.right = convert(keys, mid + 1, high, root.right);
 
        return root;
    }
 
    // Function to construct balanced BST from the given unsorted array
    public static Node convert(int[] keys)
    {
        // sort the keys first
        Arrays.sort(keys);
 
        // construct a balanced BST and return the root node of the tree
        return convert(keys, 0, keys.length - 1, null);
    }
 
    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        // construct a balanced binary search tree
        Node root = convert(keys);
 
        // print the keys in an inorder fashion
        inorder(root);
    }
}
