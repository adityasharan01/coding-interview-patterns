Given values of two values n1 and n2 in a Binary Search Tree, find the Lowest Common Ancestor (LCA). You may assume that both the values exist in the tree.

Examples:

Tree: 
BST_LCA

Input: LCA of 10 and 14
Output:  12
Explanation: 12 is the closest node to both 10 and 14 
which is a ancestor of both the nodes.

Input: LCA of 8 and 14
Output:  8
Explanation: 8 is the closest node to both 8 and 14 
which is a ancestor of both the nodes.

Input: LCA of 10 and 22
Output:  20
Explanation: 20 is the closest node to both 10 and 22 
which is a ancestor of both the nodes.
 
  
Approach: For Binary search tree, while traversing the tree from top to bottom the first node
which lies in between the two numbers n1 and n2 is the LCA of the nodes, i.e. the first node n 
with the lowest depth which lies in between n1 and n2 (n1<=n<=n2) n1 < n2. So just recursively traverse the BST in, 
if node's value is greater than both n1 and n2 then our LCA lies in the left side of the node,
if it's is smaller than both n1 and n2, then LCA lies on the right side.
Otherwise, the root is LCA (assuming that both n1 and n2 are present in BST).

Algorithm:

Create a recursive function that takes a node and the two values n1 and n2.
If the value of the current node is less than both n1 and n2, then LCA lies in the right subtree. Call the recursive function for thr right subtree.
If the value of the current node is greater than both n1 and n2, then LCA lies in the left subtree. Call the recursive function for thr left subtree.
If both the above cases are false then return the current node as LCA.
Implementation:
// Recursive Java program to print lca of two nodes

// A binary tree node
class Node
{
	int data;
	Node left, right;

	Node(int item)
	{
		data = item;
		left = right = null;
	}
}

class BinaryTree
{
	Node root;
	
	/* Function to find LCA of n1 and n2. The function assumes that both
	n1 and n2 are present in BST */
	Node lca(Node node, int n1, int n2)
	{
		if (node == null)
			return null;

		// If both n1 and n2 are smaller than root, then LCA lies in left
		if (node.data > n1 && node.data > n2)
			return lca(node.left, n1, n2);

		// If both n1 and n2 are greater than root, then LCA lies in right
		if (node.data < n1 && node.data < n2)
			return lca(node.right, n1, n2);

		return node;
	}

	/* Driver program to test lca() */
	public static void main(String args[])
	{
		// Let us construct the BST shown in the above figure
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		int n1 = 10, n2 = 14;
		Node t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 14;
		n2 = 8;
		t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 10;
		n2 = 22;
		t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

	}
}
Output:
LCA of 10 and 14 is 12
LCA of 14 and 8 is 8
LCA of 10 and 22 is 20
Complexity Analysis:

Time Complexity: O(h).
The time Complexity of the above solution is O(h), where h is the height of the tree.
Space Complexity: O(1).
If recursive stack space is ignored, the space complexity of the above solution is constant.
////////////////////////////////////////
Iterative Implementation: The above solution uses recursion. The recursive solution requires extra space in the form of the function call stack. So an iterative solution can be implemented which does not occupy space in the form of the function call stack.
  
 // Recursive Java program to print lca of two nodes

// A binary tree node
class Node
{
	int data;
	Node left, right;

	Node(int item)
	{
		data = item;
		left = right = null;
	}
}

class BinaryTree
{
	Node root;
	
/* Function to find LCA of n1 and n2.
The function assumes that both
n1 and n2 are present in BST */
static Node lca(Node root, int n1, int n2)
{
	while (root != null)
	{
		// If both n1 and n2 are smaller
		// than root, then LCA lies in left
		if (root.data > n1 &&
			root.data > n2)
		root = root.left;

		// If both n1 and n2 are greater
		// than root, then LCA lies in right
		else if (root.data < n1 &&
				root.data < n2)
		root = root.right;

		else break;
	}
	return root;
}


	/* Driver program to test lca() */
	public static void main(String args[])
	{
		// Let us construct the BST shown in the above figure
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		int n1 = 10, n2 = 14;
		Node t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 14;
		n2 = 8;
		t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 10;
		n2 = 22;
		t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

	}
}
 
Time Complexity: O(h).
The Time Complexity of the above solution is O(h), where h is the height of the tree.
Space Complexity: O(1).
The space complexity of the above solution is constant.
  
  
Implementation:
