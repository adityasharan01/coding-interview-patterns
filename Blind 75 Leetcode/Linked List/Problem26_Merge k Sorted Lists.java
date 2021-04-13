You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.
  
  
  
  
  
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head  = new ListNode(-1);
        ListNode point = head;
        // PriorityQueue sorted by asceding over of val for each ListNode element
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);           // add all headers to the priority queue 
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        // until the queue is empty - remove the smallest entry and 
        // add to result while making sure adding all its decendents to the 
        // priority queue
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            point.next = new ListNode(node.val);
            point = point.next;
            node = node.next;
            if (node!=null)
                pq.offer(node);
        }
        return head.next;
    }
}
