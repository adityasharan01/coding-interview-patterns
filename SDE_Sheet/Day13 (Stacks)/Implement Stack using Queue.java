//SOLUTION 1
The memory complexity for this solution is linear, O(n)O(n).

The first solution will make the push() operation faster. We will maintain two queues named queue1 and queue2. Let’s see what our push() and pop() operations look like:

push():
    always enqueue on queue1

pop():
  if stack size is 0, 
    return -1
  
  if queue1 has element(s), 
    dequeue all elements from queue1 and enqueue on queue2 except the last element.
    
  the last element found above will be returned after swapping queue1 and queue2 references.
      class StackUsingQueueClass{
  class StackUsingQueue{
    Queue<Integer> queue1 = new ArrayDeque<Integer>(); 
    Queue<Integer> queue2 = new ArrayDeque<Integer>(); 

    void push(int data) {
      queue1.add(data);
    }

    boolean isEmpty() {
      return queue1.size() + queue2.size() == 0;
    }
    
    void swap_queues() {
      Queue<Integer> queue3 = queue1;
      queue1 = queue2;
      queue2 = queue3;
    }

    int pop() {
      if(isEmpty()) {
        return -1;
      }

      while(queue1.size() > 1){
        queue2.add(queue1.remove());
      }

      int value = queue1.remove();
      swap_queues();
      return value;
    }
  }
  
  public static void main(String[] args) {
    StackUsingQueueClass sqc = new StackUsingQueueClass();
    StackUsingQueueClass.StackUsingQueue sq = sqc.new StackUsingQueue();
    System.out.println("Pop(): " + sq.pop());
    sq.push(3);
    sq.push(5);
    sq.push(9);
    System.out.println("Pop(): " + sq.pop());
    sq.push(10);
    sq.push(16);
    System.out.println("Pop(): " + sq.pop());
  }    
}  
//SOLUTION 2
Memory complexity #
The memory complexity for this solution is linear, O(n)O(n).

The second solution will make the pop() operation faster. Similar to solution 1, we will maintain two queues. Let’s see what our push and pop operations look like:

push():
  if queue1 is empty, 
    then enqueue on queue1.
  
  otherwise,
    enqueue on queue2 and dequeue all elements from queue1 and push them on queue2. 
    then swap the queue references.

pop():
  if stack size is 0, 
    return -1.
  
  dequeue from queue1 and return.
      
class StackUsingQueueClass{  
  class StackUsingQueue{

    Queue<Integer> queue1 = new ArrayDeque<Integer>(); 
    Queue<Integer> queue2 = new ArrayDeque<Integer>(); 

    void push(int data) {
      if(queue1.isEmpty()) {
        queue1.add(data);
      }
      else {
        queue2.add(data);
        while(!queue1.isEmpty()) {
          queue2.add(queue1.remove());
        }
        swap_queues();
      }
    }  

    boolean isEmpty() {
      return queue1.size() + queue2.size() == 0;
    }

    int pop() {
      if(isEmpty()) {
        return -1;
      }
      return queue1.remove();
    }

    void swap_queues() {
      Queue<Integer> queue3 = queue1;
      queue1 = queue2;
      queue2 = queue3;
    }
  }
  
  public static void main(String[] args) {
    StackUsingQueueClass sqc = new StackUsingQueueClass();
    StackUsingQueueClass.StackUsingQueue sq = sqc.new StackUsingQueue();
    System.out.println("Pop(): " + sq.pop());
    sq.push(3);
    sq.push(5);
    sq.push(9);
    System.out.println("Pop(): " + sq.pop());
    sq.push(10);
    sq.push(16);
    System.out.println("Pop(): " + sq.pop());
  }    
}
