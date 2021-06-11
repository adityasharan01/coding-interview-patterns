Given the root of a binary search tree and K as input, find Kth smallest element in BST. 
For example, in the following BST, if k = 3, then the output should be 10, and if k = 5, then the output should be 14.

Naive Code :
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


class Gfg { 
    
    public static void main(String args[]) 
    { 
        Node root=new Node(15);
    	root.left=new Node(5);
    	root.left.left=new Node(3);
    	root.right=new Node(20);
    	root.right.left=new Node(18);
    	root.right.left.left=new Node(16);
    	root.right.right=new Node(80);
    	int k=3;
    	
    	System.out.print("Kth Smallest: ");
    	printKth(root,k);
    } 
    
    static int count=0;
    public static void printKth(Node root, int k){
        if(root!=null){
            printKth(root.left,k);
            count++;
            if(count==k)
                {System.out.print(root.key);return;}
            printKth(root.right,k);
        }
    } 
}  
Efficient Code:
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node left, right;
    int lCount;
    Node(int x)
    {
        data = x;
        left = right = null;
        lCount = 0;
    }
}

class Gfg
{
    public static Node insert(Node root, int x)
    {
        if (root == null)
            return new Node(x);
      
        if (x < root.data) {
            root.left = insert(root.left, x);
            root.lCount++;
        }
     
        else if (x > root.data)
            root.right = insert(root.right, x);
        return root;
    }
     
    public static Node kthSmallest(Node root, int k)
    {
        if (root == null)
            return null;
     
        int count = root.lCount + 1;
        if (count == k)
            return root;
     
        if (count > k)
            return kthSmallest(root.left, k);
     
        return kthSmallest(root.right, k - count);
    }
     
    public static void main(String args[])
    {
        Node root = null;
        int keys[] = { 20, 8, 22, 4, 12, 10, 14 };
     
        for (int x : keys)
            root = insert(root, x);
     
        int k = 4;
        Node res = kthSmallest(root, k);
        if (res == null)
            System.out.println("There are less "
                           + "than k nodes in the BST");
        else
            System.out.println("K-th Smallest"
                    + " Element is " + res.data);
    }
}
