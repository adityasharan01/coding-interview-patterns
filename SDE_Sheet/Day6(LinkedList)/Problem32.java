 Check if a LinkedList is palindrome or not.
   
   // Naive Code 
   static boolean isPalindrome(Node head){
        Deque<Character> stack=new ArrayDeque<Character>();
        for(Node curr=head;curr!=null;curr=curr.next)
            stack.push(curr.data);
        for(Node curr=head;curr!=null;curr=curr.next){
            if(stack.pop()!=curr.data)
                return false;
        }
        return true;
    }
   
   
 // Efficient code
static boolean isPalindrome(Node head){
        if(head==null)return true;
        Node slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node rev=reverseList(slow.next);
        Node curr=head;
        while(rev!=null){
            if(rev.data!=curr.data)
                return false;
            rev=rev.next;
            curr=curr.next;
        }
        return true;
    }
