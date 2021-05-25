Delete a given Node when a node is given.
  
static void deleteNode(Node ptr){
        Node temp=ptr.next;
        ptr.data=temp.data;
        ptr.next=temp.next;
    }
    
