Add two numbers as LinkedList
Given two numbers represented by two linked lists of size N and M. The task is to return a sum list. The sum list is a linked list representation of the addition of two input numbers from the last.

Example 1:

Input:
N = 2
valueN[] = {4,5}
M = 3
valueM[] = {3,4,5}
Output: 3 9 0  
Explanation: For the given two linked
list (4 5) and (3 4 5), after adding
the two linked list resultant linked
list will be (3 9 0).
Example 2:

Input:
N = 2
valueN[] = {6,3}
M = 1
valueM[] = {7}
Output: 7 0
Explanation: For the given two linked
list (6 3) and (7), after adding the
two linked list resultant linked list
will be (7 0).
Approach: Traverse both lists and One by one pick nodes of both lists and add the values. If the sum is more than 10 then make carry as 1 and reduce sum. If one list has more elements than the other than consider the remaining values of this list as 0. 

The steps are: 


Traverse the two linked lists from start to end
Add the two digits each from respective linked lists.
If one of the lists has reached the end then take 0 as its digit.
Continue it until both the end of the lists.
If the sum of two digits is greater than 9 then set carry as 1 and the current digit as sum % 10
      Node addTwoLists(Node first, Node second)
    {
        // res is head node of the resultant list
        Node res = null;
        Node prev = null;
        Node temp = null;
        int carry = 0, sum;

        // while both lists exist
        while (first != null || second != null) {
            // Calculate value of next
            // digit in resultant list.
            // The next digit is sum
            // of following things
            // (i)  Carry
            // (ii) Next digit of first
            // list (if there is a next digit)
            // (ii) Next digit of second
            // list (if there is a next digit)
            sum = carry + (first != null ? first.data : 0)
                  + (second != null ? second.data : 0);

            // update carry for next calulation
            carry = (sum >= 10) ? 1 : 0;

            // update sum if it is greater than 10
            sum = sum % 10;

            // Create a new node with sum as data
            temp = new Node(sum);

            // if this is the first node then set
            // it as head of the resultant list
            if (res == null) {
                res = temp;
            }

            // If this is not the first
            // node then connect it to the rest.
            else {
                prev.next = temp;
            }

            // Set prev for next insertion
            prev = temp;

            // Move first and second pointers
            // to next nodes
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }

        if (carry > 0) {
            temp.next = new Node(carry);
        }

        // return head of the resultant list
        return res;
    }
 
