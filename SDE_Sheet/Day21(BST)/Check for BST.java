Given a binary tree. Check whether it is a BST or not.
Note: We are considering that BSTs can not contain duplicate Nodes.

Example 1:

Input:
    2
 /    \
1      3
Output: 1 
Explanation: 
The left subtree of root node contains node 
with key lesser than the root node’s key and 
the right subtree of root node contains node 
with key greater than the root node’s key.
Hence, the tree is a BST.
Example 2:

Input:
  2
   \
    7
     \
      6
       \
        5
         \
          9
           \
            2
             \
              6
Output: 0 
Explanation: 
Since the node with value 7 has right subtree 
nodes with keys less than 7, this is not a BST.
Your Task:
You don't need to read input or print anything. Your task is to complete the function isBST() which takes the root of the tree as a parameter and returns true if the given binary tree is BST, else returns false. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
0 <= Number of edges <= 100000

So, the condition we need to check at each node is:
If the node is the left child of its parent, it must be smaller than (or equal to) the parent,
and it must pass down the value from its parent to its right subtree to make sure none of the nodes in that subtree is greater than the parent.
If the node is the right child of its parent, it must be larger than the parent, and it must pass down the value from its parent to 
its left subtree to make sure none of the nodes in that subtree is lesser than the parent.
Following is the Java implementation of the idea:
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
    // Recursive function to insert a key into a BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }
 
        // if the given key is less than the root node, recur for the left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
        // if the given key is more than the root node, recur for the right subtree
        else {
            root.right = insert(root.right, key);
        }
 
        return root;
    }
 
    // Function to determine whether a given binary tree is a BST by keeping a
    // valid range (starting from [-INFINITY, INFINITY]) and keep shrinking
    // it down for each node as we go down recursively
    public static boolean isBST(Node node, int minKey, int maxKey)
    {
        // base case
        if (node == null) {
            return true;
        }
 
        // if the node's value falls outside the valid range
        if (node.data < minKey || node.data > maxKey) {
            return false;
        }
 
        // recursively check left and right subtrees with an updated range
        return isBST(node.left, minKey, node.data) &&
            isBST(node.right, node.data, maxKey);
    }
 
    // Function to determine whether a given binary tree is a BST
    public static void isBST(Node root)
    {
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("The tree is a BST.");
        }
        else {
            System.out.println("The tree is not a BST!");
        }
    }
 
    private static void swap(Node root)
    {
        Node left = root.left;
        root.left = root.right;
        root.right = left;
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }
 
        // swap left and right nodes
        swap(root);
        isBST(root);
    }
}
//Another METHOD 
We know that an inorder traversal  of a binary search tree returns the nodes in sorted order. 
To determine whether a given binary tree is a BST, keep track of the last visited node while traversing the tree.
Then for each encountered node in the inorder traversal, check whether the last visited node is smaller (or smaller/equal,
if duplicates are to be allowed in the tree) compared to the current node.
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
    // Recursive function to insert a key into a BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }
 
        // if the given key is less than the root node, recur for the left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
 
        // if the given key is more than the root node, recur for the right subtree
        else {
            root.right = insert(root.right, key);
        }
 
        return root;
    }
 
 
    // Function to perform inorder traversal on the given binary tree and
    // check if it is a BST or not. Here, `prev` is the previously processed node
    public static boolean isBST(Node root, Node prev)
    {
        // base case: empty tree is a BST
        if (root == null) {
            return true;
        }
 
        // check if the left subtree is BST or not
        boolean left = isBST(root.left, prev);
 
        // value of the current node should be more than that of the previous node
        if (root.data <= prev.data) {
            return false;
        }
 
        // update previous node data and check if the right subtree is BST or not
        prev.data = root.data;
 
        return left && isBST(root.right, prev);
    }
 
    // Function to determine whether a given binary tree is a BST
    public static void isBST(Node node)
    {
        // pointer to store previously processed node in the inorder traversal
        Node prev = new Node(Integer.MIN_VALUE);
 
        // check if nodes are processed in sorted order
        if (isBST(node, prev)) {
            System.out.println("The tree is a BST.");
        }
        else {
            System.out.println("The tree is not a BST!");
        }
    }
 
    private static void swap(Node root)
    {
        Node left = root.left;
        root.left = root.right;
        root.right = left;
    }
 
    public static void main(String[] args)
    {
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }
 
        // swap nodes
        swap(root);
        isBST(root);
    }
}




