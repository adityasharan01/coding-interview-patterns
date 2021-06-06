left view of a binary tree
//METHOD1 : PERFORM LEVEL ORDER TRAVERSAL ON THE TREE, MAINTAIN NODES AT CURRENT LEVEL IF IT IS THE
//FIRST NODE OF THE CURRENT LEVEL ,PRINT IT.
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
    // Iterative function to print the left view of a given binary tree
    public static void leftView(Node root)
    {
        // return if the tree is empty
        if (root == null) {
            return;
        }
 
        // create an empty queue and enqueue the root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // to store the current node
        Node curr;
 
        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // calculate the total number of nodes at the current level
            int size = queue.size();
            int i = 0;
 
            // process every node of the current level and enqueue their
            // non-empty left and right child
            while (i++ < size)
            {
                curr = queue.poll();
 
                // if this is the first node of the current level, print it
                if (i == 1) {
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
 
        leftView(root);
    }
}
//2. HASHING .THE IDEA IS TO TRAVERSE THE TREE IN A PREORDER FASHION AND PASS LEVEL INFO IN FUNCTION
//ARGUMENTS. IF THE LEVEL IS VISITED FOR THE FIRST TIME, INSERT THE CURRENT NODE AND LEVEL OF INFORMATION TO MAP.
//FINALLY WHEN ALL THE NODES ARE PROCESSED TRAVERSE THE MAP AND PRINT THE LEFT VIEW.
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
    // Recursive function to traverse the nodes in a preorder fashion
    public static void leftView(Node root, int level, Map<Integer, Integer> map)
    {
        // base case
        if (root == null) {
            return;
        }
 
        // if the level is visited for the first time, insert the current node
        // and level information into the map
        map.putIfAbsent(level, root.key);
 
        leftView(root.left, level + 1, map);
        leftView(root.right, level + 1, map);
    }
 
    // Function to print the left view of a given binary tree
    public static void leftView(Node root)
    {
        // create an empty HashMap to store the first node for each level
        Map<Integer, Integer> map = new HashMap<>();
 
        // traverse the tree and fill the map
        leftView(root, 1, map);
 
        // iterate through the HashMap in sorted order of its keys
        // and print the left view
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
 
        leftView(root);
    }
}
