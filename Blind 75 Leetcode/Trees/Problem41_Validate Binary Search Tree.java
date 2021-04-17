Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 APPROACH 1 :

  In the tree above, each node meets the condition that the node contains a value larger than its left child and smaller than its right child hold, and yet its not a BST;
the value 5 is on the right subtree of the node containing a voilation of the BST property.
  Instead of deciding based solely on a node values and its children,we also need information flowing down from the parent.
  So the condition we need to check at each node is :
- If the node is the left child of its parent, it must be smaller than (or equal to) the parent and it must pass down the value from its parent to its right subtree to make
sure none of the nodes in that subtree is greater than the parent.
 -If the node is the right child of its parent,it mus be larger than the parent, and it must pass down the value from its parent to its left subtree to make sure none of the nodes
 in that subtree is lesser than the parent.
 
 a. JAVA SOLUTION 
  
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

B. PYTHON SOLUTION 
import sys
 
 
# A class to store a BST node
class Node:
    def __init__(self, data, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right
 
 
# Recursive function to insert a key into a BST
def insert(root, key):
 
    # if the root is None, create a new node and return it
    if root is None:
        return Node(key)
 
    # if the given key is less than the root node, recur for the left subtree
    if key < root.data:
        root.left = insert(root.left, key)
 
    # if the given key is more than the root node, recur for the right subtree
    else:
        root.right = insert(root.right, key)
 
    return root
 
 
# Function to determine whether a given binary tree is a BST by keeping a
# valid range (starting from [-INFINITY, INFINITY]) and keep shrinking
# it down for each node as we go down recursively
def isBST(node, minKey, maxKey):
 
    # base case
    if node is None:
        return True
 
    # if the node's value falls outside the valid range
    if node.data < minKey or node.data > maxKey:
        return False
 
    # recursively check left and right subtrees with an updated range
    return isBST(node.left, minKey, node.data) and \
        isBST(node.right, node.data, maxKey)
 
 
# Function to determine whether a given binary tree is a BST
def checkForBST(root):
 
    if isBST(root, -sys.maxsize, sys.maxsize):
        print("The tree is a BST.")
    else:
        print("The tree is not a BST")
 
 
def swap(root):
 
    left = root.left
    root.left = root.right
    root.right = left
 
 
if __name__ == '__main__':
 
    keys = [15, 10, 20, 8, 12, 16, 25]
 
    root = None
    for key in keys:
        root = insert(root, key)
 
    # swap left and right nodes
    swap(root)
    checkForBST(root)
 APPROACH 2:
We know that an inorder traversal of a binary search tree that returns the nodes in sorted order.TO determine whether a given binary tree is a BST,keep track of the last visited
node while traversing the tree. then for each encountered node in the inorder traversal, check whether the last visited node is smaller compared to the current node.
  
  Java:
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

Python:
import sys
 
 
# A class to store a BST node
class Node:
    def __init__(self, data, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right
 
 
# Recursive function to insert a key into a BST
def insert(root, key):
 
    # if the root is None, create a new node and return it
    if root is None:
        return Node(key)
 
    # if the given key is less than the root node, recur for the left subtree
    if key < root.data:
        root.left = insert(root.left, key)
 
    # if the given key is more than the root node, recur for the right subtree
    else:
        root.right = insert(root.right, key)
 
    return root
 
 
# Function to perform inorder traversal on the given binary tree and
# check if it is a BST or not. Here, `prev` is the previously processed node
def isBST(root, prev):
 
    # base case: empty tree is a BST
    if root is None:
        return True
 
    # check if the left subtree is BST or not
    left = isBST(root.left, prev)
 
    # value of the current node should be more than that of the previous node
    if root.data <= prev.data:
        return False
 
    # update previous node data and check if the right subtree is BST or not
    prev.data = root.data
    return left and isBST(root.right, prev)
 
 
# Function to determine whether a given binary tree is a BST
def checkForBST(node):
 
    # pointer to store previously processed node in the inorder traversal
    prev = Node(-sys.maxsize)
 
    # check if nodes are processed in sorted order
    if isBST(node, prev):
        print("The tree is a BST!")
    else:
        print("The tree is not a BST!")
 
 
def swap(root):
 
    left = root.left
    root.left = root.right
    root.right = left
 
 
if __name__ == '__main__':
 
    keys = [15, 10, 20, 8, 12, 16, 25]
 
    root = None
    for key in keys:
        root = insert(root, key)
 
    # swap nodes
    swap(root)
    checkForBST(root)


  
  
