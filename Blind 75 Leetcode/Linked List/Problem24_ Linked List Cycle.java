Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
  
  Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
  
  //SLOW POINTERS FAST POINTERS SOLUTION
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
        return false;
    }
    ListNode slow = head, fast = head.next.next;
    // if "fast" is null, there is no circle
    while (fast != null && fast.next != null) {
        if (slow == fast) {
            return true;
        }
        fast = fast.next.next;
        slow = slow.next;
    } 
    return false;
}
  
  
  
  
  If modifying the linked list is OK then it can done even shorter:

public boolean hasCycle(ListNode head) {
    while( head != null ) {
        if( head.val == 0xcafebabe ) return true;
        head.val = 0xcafebabe; // Mark this node as visited
        head = head.next;
    }
    return false;
}
even more shorter:

public boolean hasCycle(ListNode head) {
    if ( head == null ) return false;
    if( head.val == 0xcafebabe ) return true;
    head.val = 0xcafebabe; // Mark this node as visited
    return hasCycle(head.next);
}
