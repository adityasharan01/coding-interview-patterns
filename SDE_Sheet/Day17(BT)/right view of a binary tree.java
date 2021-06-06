Right view of a binary tree
//ITERATIVE IMPLEMENTATION USING QUEUE
METHOD :Perform the level order traversal, modify level order traversal to maintain nodes at current level.
then if the current node is the last node of the current level,print it.
import java.util.ArrayDeque;
import java.util.Queue;
 
// A class to store a binary tree node
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
    // Iterative function to print the right view of a given binary tree
    public static void printRightView(Node root)
    {
        // return if the tree is empty
        if (root == null) {
            return;
        }
 
        // create an empty queue and enqueue the root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // to store the current node
        Node curr = null;
 
        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // calculate the total number of nodes at the current level
            int size = queue.size();
            int i = 0;
 
            // process every node of the current level and enqueue their
            // non-empty right and right child
            while (i++ < size)
            {
                curr = queue.poll();
 
                // if this is the last node of the current level, print it
                if (i == size) {
                    System.out.print(curr.key + " ");
                }
 
                if (curr.left != null) {
                    queue.add(curr.left);
                }
 
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
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
 
        printRightView(root);
    }
}

//RECURSIVE IMPLEMENTATION USING HASHING 
//Method 2: We can solve it using hashing. The idea is to traverse tree in preorder fashion and pass 
the level info in fnction arguments.
for every node encountered, insert the node and level info to map. Finally when all the nodes are processed,
traverse the map and print the right view.

import java.util.HashMap;
import java.util.Map;
 
// A class to store a binary tree node
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
    // Traverse nodes in reverse preorder fashion
    public static void printRightView(Node root, int level, Map<Integer, Integer> map)
    {
        if (root == null) {
            return;
        }
 
        // insert the current node and level information into the map
        map.put(level, root.key);
 
        // recur for the left subtree before the right subtree
        printRightView(root.left, level + 1, map);
        printRightView(root.right, level + 1, map);
    }
 
    // Function to print the right view of a given binary tree
    public static void printRightView(Node root)
    {
        // create an empty map to store the last node for each level
        Map<Integer, Integer> map = new HashMap<>();
 
        // traverse the tree and fill the map
        printRightView(root, 1, map);
 
        // iterate through the map in sorted order of its keys and print the right view
        for (int i = 1; i <= map.size(); i++) {
            System.out.print(map.get(i) + " ");
        }
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
 
        printRightView(root);
    }
}




