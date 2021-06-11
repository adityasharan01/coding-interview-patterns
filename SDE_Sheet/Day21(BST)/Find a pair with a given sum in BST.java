Given a BST, find a pair with a given sum present in it.
  Mehot1: Inorder Traversal.
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int key;
    Node left, right;
    Node(int x)
    {
        key = x;
        left = right = null;
    }
}

class Gfg
{
    public static ArrayList<Integer> treeToList(Node root, ArrayList<Integer> list) 
    { 
        if (root == null) 
            return list; 
  
        treeToList(root.left, list); 
        list.add(root.key); 
        treeToList(root.right, list); 
  
        return list; 
    }
    
    public static boolean isPairPresent(Node root, int target) 
    { 
        ArrayList<Integer> a1 = new ArrayList<>(); 
  
        ArrayList<Integer> a2 = treeToList(root, a1); 
  
        int start = 0; 
  
        int end = a2.size() - 1;  
  
        while (start < end) { 
  
            if (a2.get(start) + a2.get(end) == target)  
            { 
                System.out.println("Pair Found: " + a2.get(start) + " + " + a2.get(end) + " "
                                   + "= " + target); 
                return true; 
            } 
  
            if (a2.get(start) + a2.get(end) > target) // decrements end 
            { 
                end--; 
            } 
  
            if (a2.get(start) + a2.get(end) < target) // increments start 
            { 
                start++; 
            } 
        } 
  
        System.out.println("No such values are found!"); 
        return false; 
    } 
    
    public static void main(String args[])
    {
        Node root = new Node(10);  
        root.left = new Node(8);  
        root.right = new Node(20);  
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(30);  
        root.right.right.left = new Node(25);
        
        int sum=33;
        
        isPairPresent(root,sum);
    }
}
  Method2: Hashing.
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int key;
    Node left, right;
    Node(int x)
    {
        key = x;
        left = right = null;
    }
}

class Gfg
{
    
    public static boolean isPairSum(Node root, int sum, HashSet<Integer> s) 
    { 
        if(root==null)return false;
        
        if(isPairSum(root.left,sum,s)==true)
            return true;
            
        if(s.contains(sum-root.key))  
            return true;
        else
            s.add(root.key);
        return isPairSum(root.right,sum,s);
    } 
    
    public static void main(String args[])
    {
        Node root = new Node(10);  
        root.left = new Node(8);  
        root.right = new Node(20);  
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(30);  
        root.right.right.left = new Node(25);
        
        int sum=33;
        
        HashSet<Integer> s=new HashSet<>();    
        System.out.print(isPairSum(root,sum,s));
    }
}
