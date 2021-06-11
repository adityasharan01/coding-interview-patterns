K’th Largest element in BST using constant extra space
Difficulty Level : Hard
Last Updated : 21 May, 2021
Given a binary search tree, task is to find Kth largest element in the binary search tree. 
Example: 
 

Input :  k = 3
         Root of following BST
            10
          /    \
         4      20
        /      /   \
       2     15     40
Output : 15

Algorithm
 

1) Initialize Current as root.
2) Initialize a count variable to 0.
3) While current is not NULL :
   3.1) If current has no right child
   a) Increment count and check if count is equal to K.
      1) If count is equal to K, simply return current 
         Node as it is the Kth largest Node.
   b) Otherwise, Move to the left child of current.

   3.2) Else, here we have 2 cases:
   a) Find the inorder successor of current Node. 
      Inorder successor is the left most Node 
      in the right subtree or right child itself.
   b) If the left child of the inorder successor is NULL:
      1) Set current as the left child of its inorder 
         successor.
      2) Move current Node to its right.
   c) Else, if the threaded link between the current Node 
      and it's inorder successor already exists :
      1) Set left pointer of the inorder successor as NULL.
      2) Increment count and check if count is equal to K.
           a) If count is equal to K, simply return current
              Node as it is the Kth largest Node.

      3) Otherwise, Move current to it's left child.
// Java Program for finding K-th largest Node using O(1)
// extra memory and reverse Morris traversal.
class GfG
{

static class Node
{
	int data;
	Node left, right;
}

// helper function to create a new Node
static Node newNode(int data)
{
	Node temp = new Node();
	temp.data = data;
	temp.right = null;
	temp.left = null;
	return temp;
}

static Node KthLargestUsingMorrisTraversal(Node root, int k)
{
	Node curr = root;
	Node Klargest = null;

	// count variable to keep count of visited Nodes
	int count = 0;

	while (curr != null)
	{
		// if right child is NULL
		if (curr.right == null)
		{

			// first increment count and check if count = k
			if (++count == k)
				Klargest = curr;

			// otherwise move to the left child
			curr = curr.left;
		}

		else
		{

			// find inorder successor of current Node
			Node succ = curr.right;

			while (succ.left != null && succ.left != curr)
				succ = succ.left;

			if (succ.left == null)
			{

				// set left child of successor to the
				// current Node
				succ.left = curr;

				// move current to its right
				curr = curr.right;
			}

			// restoring the tree back to original binary
			// search tree removing threaded links
			else
			{

				succ.left = null;

				if (++count == k)
					Klargest = curr;

				// move current to its left child
				curr = curr.left;
			}
		}
	}
	return Klargest;
}

// Driver code
public static void main(String[] args)
{
	// Your Java Code
	/* Constructed binary tree is
		4
		/ \
	2 7
	/ \ / \
	1 3 6 10 */

	Node root = newNode(4);
	root.left = newNode(2);
	root.right = newNode(7);
	root.left.left = newNode(1);
	root.left.right = newNode(3);
	root.right.left = newNode(6);
	root.right.right = newNode(10);

	System.out.println("Finding K-th largest Node in BST : " +
					KthLargestUsingMorrisTraversal(root, 2).data);
}
}
Time Complexity : O(n) 
Auxiliary Space : O(1)
