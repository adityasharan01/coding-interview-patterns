You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

Simple Java O(n) Solution using Hashmap:
public void reorderList(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();
        int n=0;
        ListNode cur = head;
        while(cur!=null){
            n++;
            map.put(n,cur);
            cur= cur.next;
        }
        cur = head;
        
        for(int i=1; i<=n/2; i++){
            cur.next=map.get(n-i+1);
            cur = cur.next;
            cur.next = map.get(i+1);
            cur = cur.next;
            cur.next = null;
        }
    }

Solution in Python
def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        from collections import deque
        p1 = head
        dq = deque()

        while p1:
            dq.append(p1)
            p1 = p1.next
        p1 = None

        while dq:
            n1 = dq.popleft()
            n2 = None if not dq else dq.pop()

            if n2: n2.next = None
            n1.next = n2
            
            if p1: p1.next = n1
            p1 = n2
