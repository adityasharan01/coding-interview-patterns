Clone a Linked List with random and next pointer

Clone a linked list with next and random pointer 
Hard Accuracy: 49.62% Submissions: 25784 Points: 8
You are given a special linked list with N nodes where each node has a next pointer pointing to its next node. You are also given M random pointers , where you will be given M number of pairs denoting two nodes a and b  i.e. a->arb = b.

ArbitLinked List1

Example 1:

Input:
N = 4, M = 2
value = {1,2,3,4}
pairs = {{1,2},{2,4}}
Output: 1
Explanation: In this test case, there
re 4 nodes in linked list.  Among these
4 nodes,  2 nodes have arbit pointer
set, rest two nodes have arbit pointer
as NULL. Second line tells us the value
of four nodes. The third line gives the
information about arbitrary pointers.
The first node arbit pointer is set to
node 2.  The second node arbit pointer
is set to node 4.
Example 2:

Input:
N = 4, M = 2
value[] = {1,3,5,9}
pairs[] = {{1,1},{3,4}}
Output: 1
Explanation: In the given testcase ,
applying the method as stated in the
above example, the output will be 1.
Your Task:
The task is to complete the function copyList() which takes one argument the head of the linked list to be cloned and should return the head of the cloned linked list.
NOTE : If their is any node whose arbitrary pointer is not given then its by default null.

Expected Time Complexity : O(n)
Expected Auxilliary Space : O(1)
  //Approach 1:
  public LinkedList clone()
    {
        // Initialize two references, one with original
        // list's head.
        Node origCurr = this.head, cloneCurr = null;

        // Hash map which contains node to node mapping of
        // original and clone linked list.
        Map<Node, Node> map = new HashMap<Node, Node>();

        // Traverse the original list and make a copy of that
        // in the clone linked list.
        while (origCurr != null)
        {
            cloneCurr = new Node(origCurr.data);
            map.put(origCurr, cloneCurr);
            origCurr = origCurr.next;
        }

        // Adjusting the original list reference again.
        origCurr = this.head;

        // Traversal of original list again to adjust the next
        // and random references of clone list using hash map.
        while (origCurr != null)
        {
            cloneCurr = map.get(origCurr);
            cloneCurr.next = map.get(origCurr.next);
            cloneCurr.random = map.get(origCurr.random);
            origCurr = origCurr.next;
        }

        //return the head reference of the clone list.
        return new LinkedList(map.get(this.head));
    }

//Approach2:
  Node copyList(Node head) {
        // your code here
      Node temphead=head;
		while(temphead!=null)             //adding nodes with only next refrence
		{
			Node newnode=new Node(temphead.data);
			newnode.next=temphead.next;
			temphead.next=newnode;
			temphead=temphead.next.next;
		}
		temphead=head;
		while(temphead!=null)             //adding random pointer
		{
			if(temphead.arb!=null)
			{
			temphead.next.arb=temphead.arb.next;
			}
			temphead=temphead.next.next;
		}
		Node permhead1=head;
		Node permhead2=head.next;
		Node returnnode=permhead2;
		while(permhead1.next.next!=null)                //remove pointer
		{
			Node temp1=permhead1.next.next;
			Node temp2=permhead2.next.next;
			permhead1.next=temp1;
			permhead2.next=temp2;
			permhead1=temp1;
			permhead2=temp2;
		}
		permhead1.next=null;
		return returnnode;
    }
  
  
