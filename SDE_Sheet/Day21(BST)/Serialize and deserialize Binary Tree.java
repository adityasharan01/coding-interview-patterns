Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:

Input: root = [1,2]
Output: [1,2]

public class Codec {

    private static final String DELIMETER = ",";
    private static final String NULL_VALUE = "null";
    
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        Queue<TreeNode> stack = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        stack.add(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            if (node == null) {
                sb.append(NULL_VALUE).append(DELIMETER);
                continue;
            }
            sb.append(node.val).append(DELIMETER);
            stack.add(node.left);
            stack.add(node.right);
        }
        
        sb.deleteCharAt(sb.length() - 1);
        
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        
        String[] values = data.split(DELIMETER);
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        
        int i = 1;
        while (i < values.length) {
            TreeNode parent = stack.poll();
            if (!values[i].equals(NULL_VALUE)) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                stack.add(left);
            }
            
            i++;
            if (!values[i].equals(NULL_VALUE)) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                stack.add(right);
            }
            
            i++;
        }
        
        return root;
    }
}

//Serialize
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
        Node root=new Node(10);
    	root.left=new Node(20);
    	
    	ArrayList<Integer> arr=new ArrayList<>();
    	serialize(root,arr);
    	for (int x : arr) {
    	    System.out.print(x+" ");
    	}
    	
    } 
    
    static final int EMPTY=-1;
    public static void serialize(Node root, ArrayList<Integer> arr){
       if(root==null){
           arr.add(EMPTY);
           return;
       }
        arr.add(root.key);
        serialize(root.left,arr);
        serialize(root.right,arr);
    }  
} 
//Deserialize
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
        Node root=new Node(10);
    	root.left=new Node(20);
    	
    	ArrayList<Integer> arr=new ArrayList<>();
    	serialize(root,arr);
    	for (int x : arr) {
    	    System.out.print(x+" ");
    	}
    	System.out.println();;
	    Node root_new=deSerialize(arr);
	    inorder(root_new);
    	
    } 
    
    static final int EMPTY=-1;
    public static void serialize(Node root, ArrayList<Integer> arr){
       if(root==null){
           arr.add(EMPTY);
           return;
       }
        arr.add(root.key);
        serialize(root.left,arr);
        serialize(root.right,arr);
    }
    
    static int index=0;
    public static Node deSerialize(ArrayList<Integer> arr){
        if(index==arr.size())
            return null;
        int val=arr.get(index);
        index++;
        if(val==EMPTY)return null;
        Node root=new Node(val);
        root.left=deSerialize(arr);
        root.right=deSerialize(arr);
        return root;
    }
    
    public static void inorder(Node root){
    if(root!=null){
        inorder(root.left);
        System.out.print(root.key+" ");
        inorder(root.right);    
    }
} 
} 
