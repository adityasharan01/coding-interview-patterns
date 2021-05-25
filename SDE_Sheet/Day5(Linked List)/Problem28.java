Remove N-th node from back of LinkedList

Method 1(Using length of Linked List)
  static void printNthFromEnd(Node head,int n){
        int len=0;
        for(Node curr=head;curr!=null;curr=curr.next)
            len++;
        if(len<n)
            return;
        Node curr=head;
        for(int i=1;i<len-n+1;i++)
            curr=curr.next;
        System.out.print(curr.data);
    }
Method 2(Using Two Pointers/References)
  static void printNthFromEnd(Node head,int n){
        if(head==null)return;
        Node first=head;
        for(int i=0;i<n;i++){
            if(first==null)return;
            first=first.next;
        }
        Node second=head;
        while(first!=null){
            second=second.next;
            first=first.next;
        }
        System.out.print(second.data);
    }
