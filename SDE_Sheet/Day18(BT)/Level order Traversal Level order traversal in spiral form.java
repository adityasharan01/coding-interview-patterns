Level order Traversal / Level order traversal in spiral form

levelorder(root)
q —> empty queue
q.enqueue(root)
while (not q.isEmpty())
  node —> q.dequeue()
  visit(node)
  if (node.left <> null)
    q.enqueue(node.left)
  if (node.right <> null)
    q.enqueue(node.right)
    
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
    // Function to print level order traversal of a given binary tree
    public static void levelOrderTraversal(Node root)
    {
        // create an empty queue and enqueue the root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // to store the current node
        Node curr;
 
        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // process each node in the queue and enqueue their
            // non-empty left and right child
            curr = queue.poll();
 
            System.out.print(curr.key + " ");
 
            if (curr.left != null) {
                queue.add(curr.left);
            }
 
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
 
        levelOrderTraversal(root);
    }
}

////////////////////////////////////////////////SPIRAL TRAVERSAL LEVEL ORDER ////////////////////////////////////////////////////////////////////
levelorder(root)
q —> empty double ended queue
q.push(root)
while (not q.isEmpty())
  while (level is even)
    node —> q.popFront()
    visit(node)
    if (node.left <> null)
      q.pushBack(node.left)
    if (node.right <> null)
      q.pushBack(node.right)
 
  while (level is odd)
    node —> q.popBack()
    visit(node)
    if (node.right <> null)
      q.pushFront(node.right)
    if (node.left <> null)
      q.pushFront(node.left)
      
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
}
 
class Main
{
    // Function to print spiral order traversal of a given binary tree
    public static void spiralOrderTraversal(Node root)
    {
        if (root == null) {
            return;
        }
 
        // create an empty double-ended queue and enqueue the root node
        Deque<Node> deque = new ArrayDeque<>();        // or use deque
        deque.addFirst(root);
 
        // `flag` is used to differentiate between odd or even level
        boolean flag = false;
 
        // loop till deque is empty
        while (!deque.isEmpty())
        {
            // calculate the total number of nodes at the current level
            int nodeCount = deque.size();
 
            // print left to right
            if (flag)
            {
                // process each node of the current level and enqueue their
                // non-empty left and right child to deque
                while (nodeCount > 0)
                {
                    // pop from the front if `flag` is true
                    Node curr = deque.pollFirst();
                    System.out.print(curr.key + " ");
 
                    // it is important to push the left child into the back,
                    // followed by the right child
 
                    if (curr.left != null) {
                        deque.addLast(curr.left);
                    }
 
                    if (curr.right != null) {
                        deque.addLast(curr.right);
                    }
 
                    nodeCount--;
                }
            }
 
            // print right to left
            else {
                // process each node of the current level and enqueue their
                // non-empty right and left child
                while (nodeCount > 0)
                {
                    // it is important to pop from the back
                    Node curr = deque.pollLast();
                    System.out.print(curr.key + " ");    // print front node
 
                    // it is important to push the right child at the front,
                    // followed by the left child
 
                    if (curr.right != null) {
                        deque.addFirst(curr.right);
                    }
 
                    if (curr.left != null) {
                        deque.addFirst(curr.left);
                    }
 
                    nodeCount--;
                }
            }
 
            // flip the flag for the next level
            flag = !flag;
            System.out.println();
        }
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
 
        spiralOrderTraversal(root);
    }
}
/////////////////////////////////////////////////CAN SOLVE PROBLEM USING HASHING ///////////////////////////////////////////////////////
import java.util.ArrayDeque;
import java.util.Deque;
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
    // Traverse the tree in a preorder fashion and store nodes in a map
    // corresponding to their level
    public static void preorder(Node root, int level, Map<Integer, Deque<Integer>> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }
 
        // insert the current node and its level into the map
        map.putIfAbsent(level, new ArrayDeque<>());
 
        // if the level is odd, insert at the back; otherwise, search at front
        if (level % 2 == 1) {
            map.get(level).addLast(root.key);
        }
        else {
            map.get(level).addFirst(root.key);
        }
 
        // recur for the left and right subtree by increasing the level by 1
        preorder(root.left, level + 1, map);
        preorder(root.right, level + 1, map);
    }
 
    // Recursive function to print spiral order traversal of a given binary tree
    public static void levelOrderTraversal(Node root)
    {
        // create an empty map to store nodes between given levels
        Map<Integer, Deque<Integer>> map = new HashMap<>();
 
        // traverse the tree and insert its nodes into the map
        // corresponding to their level
        preorder(root, 1, map);
 
        // iterate through the map and print all nodes present at every level
        for (int i = 1; i <= map.size(); i++) {
            System.out.println("Level " + i + ": " + map.get(i));
        }
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
        root.left.left.left = new Node(20);
        root.right.right.right = new Node(30);
 
        levelOrderTraversal(root);
    }
}
