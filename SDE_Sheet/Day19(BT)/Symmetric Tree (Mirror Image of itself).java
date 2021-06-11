Symmetric Tree (Mirror Image of itself)
  Given a binary tree, check whether it is a mirror of itself.

For example, this binary tree is symmetric: 

     1
   /   \
  2     2
 / \   / \
3   4 4   3

But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Recommended: Please solve it on “PRACTICE” first, before moving on to the solution.
The idea is to write a recursive function isMirror() that takes two trees as an argument and returns true if trees are the mirror and false if trees are not mirrored. The isMirror() function recursively checks two roots and subtrees under the root.

Below is the implementation of the above algorithm.

  
  // Java program to check is
// binary tree is symmetric or not
class Node {
    int key;
    Node left, right;
 
    Node(int item)
    {
        key = item;
        left = right = null;
    }
}
 
class BinaryTree {
    Node root;
 
    // returns true if trees
    //  with roots as root1 and root2are mirror
    boolean isMirror(Node node1, Node node2)
    {
        // if both trees are empty,
        //  then they are mirror image
        if (node1 == null && node2 == null)
            return true;
 
        // For two trees to be mirror images, the following
        // three conditions must be true 1 - Their root
        // node's key must be same 2 - left subtree of left
        // tree and right subtree
        //      of right tree have to be mirror images
        // 3 - right subtree of left tree and left subtree
        //      of right tree have to be mirror images
        if (node1 != null && node2 != null
            && node1.key == node2.key)
            return (isMirror(node1.left, node2.right)
                    && isMirror(node1.right, node2.left));
 
        // if none of the above conditions is true then
        // root1 and root2 are not mirror images
        return false;
    }
 
    // returns true if the tree is symmetric i.e
    // mirror image of itself
    boolean isSymmetric()
    {
        // check if tree is mirror of itself
        return isMirror(root, root);
    }
 
    // Driver code
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);
        boolean output = tree.isSymmetric();
        if (output == true)
            System.out.println("Symmetric");
        else
            System.out.println("Not symmetric");
    }
}
Symmetric
Time Complexity: O(N)

Auxiliary Space: O(h) where h is the maximum height of the tree 
