Given the root of a binary tree, invert the tree, and return its root.

 

Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 Approach: 
Idea is to traverse the tree in a preorder fashion and for every node encountered, swap its and right child before recursively inverting its left and right subtree.
We can also traverse tree in postorder fashion.
  Java Solution:
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
    // Function to perform preorder traversal on a given binary tree
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
 
    // Utility function to swap left subtree with right subtree
    public static void swap(Node root)
    {
        if (root == null) {
            return;
        }
 
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
 
    // Function to invert a given binary tree using preorder traversal
    public static void invertBinaryTree(Node root)
    {
        // base case: if the tree is empty
        if (root == null) {
            return;
        }
 
        // swap left subtree with right subtree
        swap(root);
 
        // invert left subtree
        invertBinaryTree(root.left);
 
        // invert right subtree
        invertBinaryTree(root.right);
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
 
        invertBinaryTree(root);
        preorder(root);
    }
}
  
 Python Solution :
 class Node:
    def __init__(self, data, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right
 
 
# Function to perform preorder traversal on a given binary tree
def preorder(root):
 
    if root is None:
        return
 
    print(root.data, end=' ')
    preorder(root.left)
    preorder(root.right)
 
 
# Utility function to swap left subtree with right subtree
def swap(root):
 
    if root is None:
        return
 
    temp = root.left
    root.left = root.right
    root.right = temp
 
 
# Function to invert a given binary tree using preorder traversal
def invertBinaryTree(root):
 
    # base case: if the tree is empty
    if root is None:
        return
 
    # swap left subtree with right subtree
    swap(root)
 
    # invert left subtree
    invertBinaryTree(root.left)
 
    # invert right subtree
    invertBinaryTree(root.right)

Iterative Solution :
The code is almost similar to level order traversal of a binary tree.

import java.util.ArrayDeque;
import java.util.Queue;
 
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
    // Function to perform preorder traversal on a given binary tree
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
 
    // Utility function to swap left subtree with right subtree
    public static void swap(Node root)
    {
        if (root == null) {
            return;
        }
 
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
 
    // Iterative function to invert a given binary tree using a queue
    public static void invertBinaryTree(Node root)
    {
        // base case: if the tree is empty
        if (root == null) {
            return;
        }
 
        // maintain a queue and push the root node
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
 
        // loop till queue is empty
        while (!q.isEmpty())
        {
            // dequeue front node
            Node curr = q.poll();
 
            // swap the left child with the right child
            swap(curr);
 
            // enqueue left child of the popped node
            if (curr.left != null) {
                q.add(curr.left);
            }
 
            // enqueue right child of the popped node
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
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
 
        invertBinaryTree(root);
        preorder(root);
    }
}


