Rotate a LinkedList
Given a singly linked list of size N. The task is to rotate the linked list counter-clockwise by k nodes, where k is a given positive integer smaller than or equal to length of the linked list.

Example 1:

Input:
N = 5
value[] = {2, 4, 7, 8, 9}
k = 3
Output: 8 9 2 4 7
Explanation:
Rotate 1: 4 -> 7 -> 8 -> 9 -> 2
Rotate 2: 7 -> 8 -> 9 -> 2 -> 4
Rotate 3: 8 -> 9 -> 2 -> 4 -> 7
  
  Node rotate(Node head,int k)
 {
    //add code here
    Node newHead=head;
    Node prev=null;
    for(int i=0;i<k;i++)
    {
        prev=newHead;
        newHead=newHead.next;
    }
    
    if (newHead==null) return head;
    
    Node tail=newHead;
    while(tail.next!=null) tail=tail.next;
    
    tail.next=head;
    prev.next=null;
    
    return newHead;
 }
