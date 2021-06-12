You need to find the inorder successor and predecessor of a given key. In case the given key is not found in BST, then return the two values within which this key will lie.
  
  Following is the algorithm to reach the desired result. Its a recursive method: 

Input: root node, key
output: predecessor node, successor node

1. If root is NULL
      then return
2. if key is found then
    a. If its left subtree is not null
        Then predecessor will be the right most 
        child of left subtree or left child itself.
    b. If its right subtree is not null
        The successor will be the left most child 
        of right subtree or right child itself.
    return
3. If key is smaller then root node
        set the successor as root
        search recursively into left subtree
    else
        set the predecessor as root
        search recursively into right subtree

// Java program to find predecessor
// and successor in a BST
class GFG{

// BST Node
static class Node
{
	int key;
	Node left, right;

	public Node()
	{}

	public Node(int key)
	{
		this.key = key;
		this.left = this.right = null;
	}
};

static Node pre = new Node(), suc = new Node();

// This function finds predecessor and
// successor of key in BST. It sets pre
// and suc as predecessor and successor
// respectively
static void findPreSuc(Node root, int key)
{
	
	// Base case
	if (root == null)
		return;

	// If key is present at root
	if (root.key == key)
	{
		
		// The maximum value in left
		// subtree is predecessor
		if (root.left != null)
		{
			Node tmp = root.left;
			while (tmp.right != null)
				tmp = tmp.right;
				
			pre = tmp;
		}

		// The minimum value in
		// right subtree is successor
		if (root.right != null)
		{
			Node tmp = root.right;
			
			while (tmp.left != null)
				tmp = tmp.left;
				
			suc = tmp;
		}
		return;
	}

	// If key is smaller than
	// root's key, go to left subtree
	if (root.key > key)
	{
		suc = root;
		findPreSuc(root.left, key);
	}
	
	// Go to right subtree
	else
	{
		pre = root;
		findPreSuc(root.right, key);
	}
}

// A utility function to insert a
// new node with given key in BST
static Node insert(Node node, int key)
{
	if (node == null)
		return new Node(key);
	if (key < node.key)
		node.left = insert(node.left, key);
	else
		node.right = insert(node.right, key);
		
	return node;
}

// Driver code
public static void main(String[] args)
{
	
	// Key to be searched in BST
	int key = 65;

	/*
	* Let us create following BST
	*		 50
	*		 / \
	*	 30 70
	*	 / \ / \
	*	 20 40 60 80
	*/

	Node root = new Node();
	root = insert(root, 50);
	insert(root, 30);
	insert(root, 20);
	insert(root, 40);
	insert(root, 70);
	insert(root, 60);
	insert(root, 80);

	findPreSuc(root, key);
	if (pre != null)
		System.out.println("Predecessor is " + pre.key);
	else
		System.out.println("No Predecessor");

	if (suc != null)
		System.out.println("Successor is " + suc.key);
	else
		System.out.println("No Successor");
}
}
Output: 
Predecessor is 60
Successor is 70
/////////////////////////////////////////////////
///////////////////////////////////////////////// 
Another Approach : 
We can also find the inorder successor and inorder predecessor using inorder traversal . 
Check if the current node is smaller than the given key for predecessor and for successor, 
check if it is greater than the given key. If it is greater than the given key then, 
check if it is smaller than the already stored value in successor then, update it. 
At last, get the predecessor and successor stored in q(successor) and p(predecessor). 
  
// CPP code for inorder successor
// and predecessor of tree
#include<iostream>
#include<stdlib.h>

using namespace std;

struct Node
{
	int data;
	Node* left,*right;
};

// Function to return data
Node* getnode(int info)
{
	Node* p = (Node*)malloc(sizeof(Node));
	p->data = info;
	p->right = NULL;
	p->left = NULL;
	return p;
}

/*
since inorder traversal results in
ascending order visit to node , we
can store the values of the largest
no which is smaller than a (predecessor)
and smallest no which is large than
a (successor) using inorder traversal
*/
void find_p_s(Node* root,int a,
			Node** p, Node** q)
{
	// If root is null return
	if(!root)
		return ;
		
	// traverse the left subtree
	find_p_s(root->left, a, p, q);
	
	// root data is greater than a
	if(root&&root->data > a)
	{
		
		// q stores the node whose data is greater
		// than a and is smaller than the previously
		// stored data in *q which is successor
		if((!*q) || (*q) && (*q)->data > root->data)
				*q = root;
	}
	
	// if the root data is smaller than
	// store it in p which is predecessor
	else if(root && root->data < a)
	{
		*p = root;
	}
	
	// traverse the right subtree
	find_p_s(root->right, a, p, q);
}

// Driver code
int main()
{
	Node* root1 = getnode(50);
	root1->left = getnode(20);
	root1->right = getnode(60);
	root1->left->left = getnode(10);
	root1->left->right = getnode(30);
	root1->right->left = getnode(55);
	root1->right->right = getnode(70);
	Node* p = NULL, *q = NULL;

	find_p_s(root1, 55, &p, &q);
	
	if(p)
		cout << p->data;
	if(q)
		cout << " " << q->data;
	return 0;
}
Output :  

50 60
  
  
