Given a binary tree and a key(node) value, find the floor and ceil value for that particular key value.

Floor Value Node: Node with the greatest data lesser than or equal to the key value. 
Ceil Value Node: Node with the smallest data larger than or equal to the key value.
For example, Let’s consider the Binary Tree below – 

          8
        /   \    
      4      12
    /  \    /  \
   2    6  10   14

Key: 11  Floor: 10  Ceil: 12
Key: 1   Floor: -1  Ceil: 2
Key: 6   Floor: 6   Ceil: 6
Key: 15  Floor: 14  Ceil: -1
There are numerous applications where we need to find the floor/ceil value of a key in a binary search tree or sorted array. For example, consider designing a memory management system in which free nodes are arranged in BST. Find the best fit for the input request.

Algorithm: 



Imagine we are moving down the tree, and assume we are root node. 
The comparison yields three possibilities,

A) Root data is equal to key. We are done, root data is ceil value.

B) Root data < key value, certainly the ceil value can't be in left subtree. 
   Proceed to search on right subtree as reduced problem instance.

C) Root data > key value, the ceil value may be in left subtree. 
   We may find a node with is larger data than key value in left subtree, 
   if not the root itself will be ceil node.
//FLOOR 
import java.util.*;
import java.io.*;
import java.lang.*;

class Node  
{ 
  int key; 
  Node left; 
  Node right; 
  Node(int k){
      key=k;
      left=right=null;
  }
}


class GFG { 
    
    public static void main(String args[]) 
    { 
        Node root=new Node(15);
    	root.left=new Node(5);
    	root.left.left=new Node(3);
    	root.right=new Node(20);
    	root.right.left=new Node(18);
    	root.right.left.left=new Node(16);
    	root.right.right=new Node(80);
    	int x=17;
    	
    	System.out.print("Floor: "+(floor(root,17).key));
    } 
    
    public static Node floor(Node root, int x){
        Node res=null;
        while(root!=null){
            if(root.key==x)
                return root;
            else if(root.key>x)
                root=root.left;
            else{
                res=root;
                root=root.right;
            }
        }
        return res;
    } 
} 
Iterative Approach –

1. If tree is empty, i.e. root is null, 
   return back to calling function.
2. If current node address is not null, perform the following steps : 
     (a) If current node data matches with the key value - 
             We have found both our floor and ceil value. 
             Hence, we return back to calling function.
    (b) If data in current node is lesser than the key value - 
            We assign the current node data to the variable keeping
            track of current floor value and explore the right subtree,
            as it may contain nodes with values greater than key value.
    (c) If data in current node is greater than the key value - 
            We assign the current node data to the variable keeping track
            of current ceil value and explore the left subtree, as it may
            contain nodes with values lesser than key value.
3. Once we reach null, we return back to the calling function,
   as we have got our required floor and ceil values for the particular key value.
// Java program to find floor and ceil
// of a given key in BST
import java.io.*;

// A binary tree node has key,
// left child and right child
class Node
{
	int data;
	Node left, right;

	Node(int d)
	{
		data = d;
		left = right = null;
	}
}

class BinaryTree{
	
Node root;
int floor;
int ceil;

// Helper function to find floor and
// ceil of a given key in BST
public void floorCeilBSTHelper(Node root,
							int key)
{
	while (root != null)
	{
		if (root.data == key)
		{
			ceil = root.data;
			floor = root.data;
			return;
		}

		if (key > root.data)
		{
			floor = root.data;
			root = root.right;
		}
		else
		{
			ceil = root.data;
			root = root.left;
		}
	}
	return;
}

// Display the floor and ceil of a
// given key in BST. If key is less
// than the min key in BST, floor
// will be -1; If key is more than
// the max key in BST, ceil will be -1;
public void floorCeilBST(Node root, int key)
{
	
	// Variables 'floor' and 'ceil'
	// are passed by reference
	floor = -1;
	ceil = -1;

	floorCeilBSTHelper(root, key);

	System.out.println(key + " " +
					floor + " " + ceil);
}

// Driver code
public static void main(String[] args)
{
	BinaryTree tree = new BinaryTree();
	tree.root = new Node(8);
	tree.root.left = new Node(4);
	tree.root.right = new Node(12);
	tree.root.left.left = new Node(2);
	tree.root.left.right = new Node(6);
	tree.root.right.left = new Node(10);
	tree.root.right.right = new Node(14);
	
	for(int i = 0; i < 16; i++)
	{
		tree.floorCeilBST(tree.root, i);
	}
}
}
///////////////////////////////////////////////////////////////////////
//CEIL
import java.util.*;
import java.io.*;
import java.lang.*;

class Node  
{ 
  int key; 
  Node left; 
  Node right; 
  Node(int k){
      key=k;
      left=right=null;
  }
}

class GFG { 
    
    public static void main(String args[]) 
    { 
        Node root=new Node(15);
    	root.left=new Node(5);
    	root.left.left=new Node(3);
    	root.right=new Node(20);
    	root.right.left=new Node(18);
    	root.right.left.left=new Node(16);
    	root.right.right=new Node(80);
    	int x=17;
    	
    	System.out.print("Ceil: "+(ceil(root,17).key));
    } 
    
    public static Node ceil(Node root, int x){
        Node res=null;
        while(root!=null){
            if(root.key==x)
                return root;
            else if(root.key<x)
                root=root.right;
            else{
                res=root;
                root=root.left;
            }
        }
        return res;
    } 
} 
