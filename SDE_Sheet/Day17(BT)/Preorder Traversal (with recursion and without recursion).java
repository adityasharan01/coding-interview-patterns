Preorder Traversal (with recursion and without recursion)
  // Data structure to store a binary tree node
class Node
{
    int data;
    Node left, right;
 
    // Function to create a new binary tree node having a given key
    public Node(int key)
    {
        data = key;
        left = right = null;
    }
}
 
class Main
{
    // Recursive function to perform preorder traversal on the tree
    public static void preorder(Node root)
    {
        // return if the current node is empty
        if (root == null) {
            return;
        }
    
        // Display the data part of the root (or current node)
        System.out.print(root.data + " ");
    
        // Traverse the left subtree
        preorder(root.left);
    
        // Traverse the right subtree
        preorder(root.right);
    }
 
    public static void main(String[] args)
    {
        /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        preorder(root);
    }
}
//Iterative
//IDEA
// iterativePreorder(node)
 
// if (node = null)
//   return
// s —> empty stack
// s.push(node)
// while (not s.isEmpty())
//   node —> s.pop()
//   visit(node)
//   if (node.right != null)
//     s.push(node.right)
//   if (node.left != null)
//     s.push(node.left)

import java.util.Stack;
 
// Data structure to store a binary tree node
class Node
{
    int data;
    Node left, right;
 
    // Function to create a new binary tree node having a given key
    public Node(int key)
    {
        data = key;
        left = right = null;
    }
}
 
class Main
{
    // Iterative function to perform preorder traversal on the tree
    public static void preorderIterative(Node root)
    {
        // return if the tree is empty
        if (root == null) {
            return;
        }
    
        // create an empty stack and push the root node
        Stack<Node> stack = new Stack();
        stack.push(root);
    
        // loop till stack is empty
        while (!stack.empty())
        {
            // pop a node from the stack and print it
            Node curr = stack.pop();
    
            System.out.print(curr.data + " ");
    
            // push the right child of the popped node into the stack
            if (curr.right != null) {
                stack.push(curr.right);
            }
    
            // push the left child of the popped node into the stack
            if (curr.left != null) {
                stack.push(curr.left);
            }
    
            // the right child must be pushed first so that the left child
            // is processed first (LIFO order)
        }
    }
 
    public static void main(String[] args)
    {
        /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        preorderIterative(root);
    }
}
/////The above solution can further be optimized by pushing the right child into the stack 
import java.util.Stack;
 
// Data structure to store a binary tree node
class Node
{
    int data;
    Node left, right;
 
    // Function to create a new binary tree node having a given key
    public Node(int key)
    {
        data = key;
        left = right = null;
    }
}
 
class Main
{
    // Iterative function to perform preorder traversal on the tree
    public static void preorderIterative(Node root)
    {
        // return if the tree is empty
        if (root == null) {
            return;
        }
    
        // create an empty stack and push the root node
        Stack<Node> stack = new Stack();
        stack.push(root);
    
        // start from the root node (set current node to the root node)
        Node curr = root;
    
        // loop till stack is empty
        while (!stack.empty())
        {
            // if the current node exists, print it and push its right child
            // to the stack before moving to its left child
            if (curr != null)
            {
                System.out.print(curr.data + " ");
    
                if (curr.right != null) {
                    stack.push(curr.right);
                }
    
                curr = curr.left;
            }
            // if the current node is null, pop a node from the stack
            // set the current node to the popped node
            else {
                curr = stack.pop();
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
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        preorderIterative(root);
    }
}
