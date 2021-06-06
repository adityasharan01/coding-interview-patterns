Postorder Traversal (with recursion and without recursion)  
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
    // Recursive function to perform postorder traversal on the tree
    public static void postorder(Node root)
    {
        // return if the current node is empty
        if (root == null) {
            return;
        }
    
        // Traverse the left subtree
        postorder(root.left);
    
        // Traverse the right subtree
        postorder(root.right);
    
        // Display the data part of the root (or current node)
        System.out.print(root.data + " ");
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
 
        postorder(root);
    }
}

// iterativePostorder(node)
 
// s —> empty stack
// t —> output stack
// while (not s.isEmpty())
//   node —> s.pop()
//   t.push(node)
 
//   if (node.left <> null)
//     s.push(node.left)
 
//   if (node.right <> null)
//     s.push(node.right)
 
// while (not t.isEmpty())
//   node —> t.pop()
//   visit(node)

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
    // Iterative function to perform postorder traversal on the tree
    public static void postorderIterative(Node root)
    {
        // create an empty stack and push the root node
        Stack<Node> stack = new Stack();
        stack.push(root);
    
        // create another stack to store postorder traversal
        Stack<Integer> out = new Stack();
    
        // loop till stack is empty
        while (!stack.empty())
        {
            // pop a node from the stack and push the data into the output stack
            Node curr = stack.pop();
            out.push(curr.data);
    
            // push the left and right child of the popped node into the stack
            if (curr.left != null) {
                stack.push(curr.left);
            }
    
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
    
        // print postorder traversal
        while (!out.empty()) {
            System.out.print(out.pop() + " ");
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
 
        postorderIterative(root);
    }
}

