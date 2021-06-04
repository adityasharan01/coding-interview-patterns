Implement Queue Using Stacks
Suppose we have a Stack class that provides all common operations like push(), pop(), isEmpty()/empty().

Using the instances of this Stack class, implement a Queue class with its enqueue(), dequeue(), and isEmpty() operations.

If the queue is empty, the dequeue() function should return -1;
A good question to ask the interviewer is: what operation needs to be faster in the stack implementation?

Solution 1 #
Runtime complexity #
The runtime complexity of enqueue() is constant, O(1)O(1).
The runtime complexity of dequeue() is linear, O(n)O(n).
Memory complexity #
The memory complexity of this solution is linear, O(n)O(n).

The first solution will make the enqueue() operation faster. We will maintain two stacks named stack1 and stack2. Let’s see the pseudocode for enqueue() and dequeue() operations:

enqueue():
  always push on stack1

dequeue():
  if queue size is 0, 
    return -1

  if stack2 has element(s), 
    pop the topmost and return.

  otherwise if stack1 is non empty, 
    pop all elements from stack1 and push them in stack2.

  at the end pop stack2 top most element and return.
      
class QueueUsingStackClass{
  class QueueUsingStack{

    Stack<Integer> stack1 = new Stack<Integer>(); 
    Stack<Integer> stack2 = new Stack<Integer>(); 

    void enqueue(int data) {
      stack1.push(data);
    }

    boolean isEmpty() {
      return stack1.size() + stack2.size() == 0;
    }

    int dequeue() {
      if(isEmpty()) {
        return -1;
      }

      if(stack2.isEmpty()) {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
      }
      return stack2.pop();
    }
  }
  public static void main(String[] args) {
  
    QueueUsingStackClass qsc = new QueueUsingStackClass();
    QueueUsingStackClass.QueueUsingStack qs = qsc.new QueueUsingStack();

    System.out.println("dequeue()" + " = " + qs.dequeue());
    qs.enqueue(3);
    qs.enqueue(6);
    qs.enqueue(16);
    System.out.println("dequeue()" + " = " + qs.dequeue());
    qs.enqueue(8);
    qs.enqueue(4);
    System.out.println("dequeue()" + " = " + qs.dequeue());
  }   
}  
Solution 2 #
Runtime complexity #
The runtime complexity of enqueue() is linear, O(n)O(n).
The runtime complexity of dequeue() is constant, O(1)O(1).
Memory complexity #
The memory complexity of this solution is linear, O(n)O(n).

The second solution will make the dequeue() operation faster. Similar to solution 1, we will maintain two stacks. Let’s look at the pseudocode enqueue() and dequeue() operations:

enqueue()
  pop each element from stack1 and push it to stack2.
  push item being enqueued to stack1.
  pop each element back from stack2 and push it to stack1.

dequeue()
  if queue size is 0, 
    return -1

  pop from stack1 and return.
//Solution2
 class QueueUsingStackClass{
  class QueueUsingStack{''
    Stack<Integer> stack1 = new Stack<Integer>(); 
    Stack<Integer> stack2 = new Stack<Integer>(); 

    void enqueue(int data) {
      while(!stack1.isEmpty()) {
          stack2.push(stack1.pop());
      }

      stack1.push(data);

      while(!stack2.isEmpty()) {
          stack1.push(stack2.pop());
      }
    }

    boolean isEmpty() {
      return stack1.size() + stack2.size() == 0;
    }

    int dequeue() {
      if(isEmpty()) {
        return -1;
      }

      return stack1.pop();
    }
  }
  public static void main(String[] args) {
  
    QueueUsingStackClass qsc = new QueueUsingStackClass();
    QueueUsingStackClass.QueueUsingStack qs = qsc.new QueueUsingStack();

    System.out.println("dequeue()" + " = " + qs.dequeue());
    qs.enqueue(3);
    qs.enqueue(6);
    qs.enqueue(16);
    System.out.println("dequeue()" + " = " + qs.dequeue());
    qs.enqueue(8);
    qs.enqueue(4);
    System.out.println("dequeue()" + " = " + qs.dequeue());
  }
}  
 
