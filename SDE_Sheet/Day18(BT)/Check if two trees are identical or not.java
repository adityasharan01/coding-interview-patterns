Check if two trees are identical or not

The idea is to traverse both trees and compare values at their root node. If the value matches, 
recursively check if the first tree’s left subtree is identical to the left subtree of the second tree 
and the right subtree of the first tree is identical to the right subtree of the second tree. 
 If the value at their root node differs, the trees violate data property. If at any point in the recursion,
the first tree is empty and the second tree is non-empty,
or the second tree is empty and the first tree is non-empty, the trees violate structural property, and they cannot be identical.
  
  class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
 
class Main
{
    // Recursive function to check if two given binary trees are identical or not
    public static boolean isIdentical(Node x, Node y)
    {
        // if both trees are empty, return true
        if (x == null && y == null) {
            return true;
        }
 
        // if both trees are non-empty and the value of their root node matches,
        // recur for their left and right subtree
        return (x != null && y != null) && (x.key == y.key) &&
                    isIdentical(x.left, y.left) &&
                    isIdentical(x.right, y.right);
    }
 
    public static void main(String[] args)
    {
        // construct the first tree
        Node x = new Node(15);
        x.left = new Node(10);
        x.right = new Node(20);
        x.left.left = new Node(8);
        x.left.right = new Node(12);
        x.right.left = new Node(16);
        x.right.right = new Node(25);
 
        // construct the second tree
        Node y = new Node(15);
        y.left = new Node(10);
        y.right = new Node(20);
        y.left.left = new Node(8);
        y.left.right = new Node(12);
        y.right.left = new Node(16);
        y.right.right = new Node(25);
 
        if (isIdentical(x, y)) {
            System.out.print("The given binary trees are identical");
        }
        else {
            System.out.print("The given binary trees are not identical");
        }
    }
}

//////////////////////////////////iterative solution //////////////////////////////////////////////iterative solution ///////////////////////////////////////////

import java.util.ArrayDeque;
import java.util.Deque;
 
// A class to store a binary tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
 
    @Override
    public String toString() {
        return "" + key + " ";
    }
}
 
// A Pair class
class Pair<U, V>
{
    public final U first;       // first field of a pair
    public final V second;      // second field of a pair
 
    // Constructs a new Pair with specified values
    private Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }
 
    // Factory method for creating a Typed Pair immutable instance
    public static <U, V> Pair <U, V> of(U a, V b)
    {
        // calls private constructor
        return new Pair<>(a, b);
    }
}
 
class Main
{
    // Iterative function to check if two given binary trees are identical or not
    public static boolean isIdentical(Node x, Node y)
    {
        // if both trees are empty, return true
        if (x == null && y == null) {
            return true;
        }
 
        // if the first tree is empty (and the second tree is non-empty), return false
        if (x == null) {
            return false;
        }
 
        // if the second tree is empty (and the first tree is non-empty), return false
        if (y == null) {
            return false;
        }
 
        // create a stack to hold `Node` pairs
        Deque<Pair<Node, Node>> stack = new ArrayDeque<>();
        stack.add(Pair.of(x, y));
 
        // loop till stack is empty
        while (!stack.isEmpty())
        {
            // pop the top pair from the stack and process it
            x = stack.peekLast().first;
            y = stack.peekLast().second;
 
            stack.pollLast();
 
            // if the value of their root node doesn't match, return false
            if (x.key != y.key) {
                return false;
            }
 
            // if the left subtree of both `x` and `y` exists, push their addresses
            // to stack; otherwise, return false if only one left child exists
            if (x.left != null && y.left != null) {
                stack.add(Pair.of(x.left, y.left));
            }
            else if (x.left != null || y.left != null) {
                return false;
            }
 
            // if the right subtree of both `x` and `y` exists, push their addresses
            // to stack; otherwise, return false if only one right child exists
            if (x.right != null && y.right != null) {
                stack.add(Pair.of(x.right, y.right));
            }
            else if (x.right != null || y.right != null) {
                return false;
            }
        }
 
        // we reach here if both binary trees are identical
        return true;
    }
 
    public static void main(String[] args)
    {
        // construct the first tree
        Node x = new Node(15);
        x.left = new Node(10);
        x.right = new Node(20);
        x.left.left = new Node(8);
        x.left.right = new Node(12);
        x.right.left = new Node(16);
        x.right.right = new Node(25);
 
        // construct the second tree
        Node y = new Node(15);
        y.left = new Node(10);
        y.right = new Node(20);
        y.left.left = new Node(8);
        y.left.right = new Node(12);
        y.right.left = new Node(16);
        y.right.right = new Node(25);
 
        if (isIdentical(x, y)) {
            System.out.print("The given binary trees are identical");
        }
        else {
            System.out.print("The given binary trees are not identical");
        }
    }
}


