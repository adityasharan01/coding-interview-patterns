Given the head of a linked list, remove the nth node from the end of the list and return its head.

Follow up: Could you do this in one pass?
 Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]

1. First find the total length of the linked list.
2. Subtracted the n value from the linked list.
3. Iterate till (length-n) value.
4. Then delete the next node.
5. In case value of len and n is same then just return head.next.

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null)
        {
            
            return null ;
        }
        ListNode temp=head;int len=1;
        while(temp.next!=null)
        {
            len++;temp=temp.next;
        }
        //System.out.println(len);
        int k=len-n;int i=1;
        
        if(k==0)
        {
            return head.next;
        }
        temp=head;
        while(temp!=null &&i<k )
        {
            i++;temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
        
    }
}
  Solution in Python:
def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        
        nodes = []
        root = head
        
        while root:
            nodes.append(root)
            root = root.next
        
        if n==1:
            if len(nodes) == 1: # special case for only one element in linkedList
                return None
            else:
                precesor = nodes[len(nodes) - 2]
                precesor.next = None
        
        elif n==len(nodes): # special case for removing the first node in the linkedlist
            return nodes[1]
        
        else:
            precesor = nodes[len(nodes) - n - 1]
            following = nodes[len(nodes) - n + 1]
            precesor.next = following
            
        return head
