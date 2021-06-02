Implement Stack / Implement Queue
Stack Implementation in Java
A stack is a linear data structure that follows the LIFO (Last–In, First–Out) principle. That means the objects can be inserted or removed only at one end of it, also called a top.

The stack supports the following operations:

push inserts an item at the top of the stack (i.e., above its current top element).
pop removes the object at the top of the stack and returns that object from the function. The stack size will be decremented by one.

Data stack
isEmpty tests if the stack is empty or not.
isFull tests if the stack is full or not.
peek returns the object at the top of the stack without removing it from the stack or modifying the stack in any way.
size returns the total number of elements present in the stack.
Stack Implementation using an array
A stack can easily be implemented as an array. Following is the stack implementation in Java using an array:

class Stack
{
    private int arr[];
    private int top;
    private int capacity;
 
    // Constructor to initialize the stack
    Stack(int size)
    {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
 
    // Utility function to add an element `x` to the stack
    public void push(int x)
    {
        if (isFull())
        {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(1);
        }
 
        System.out.println("Inserting " + x);
        arr[++top] = x;
    }
 
    // Utility function to pop a top element from the stack
    public int pop()
    {
        // check for stack underflow
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }
 
        System.out.println("Removing " + peek());
 
        // decrease stack size by 1 and (optionally) return the popped element
        return arr[top--];
    }
 
    // Utility function to return the top element of the stack
    public int peek()
    {
        if (!isEmpty()) {
            return arr[top];
        }
        else {
            System.exit(1);
        }
 
        return -1;
    }
 
    // Utility function to return the size of the stack
    public int size() {
        return top + 1;
    }
 
    // Utility function to check if the stack is empty or not
    public Boolean isEmpty()
    {
        return top == -1;               // or return size() == 0;
    }
 
    // Utility function to check if the stack is full or not
    public Boolean isFull() {
        return top == capacity - 1;     // or return size() == capacity;
    }
}
 
class Main
{
    public static void main (String[] args)
    {
        Stack stack = new Stack(3);
 
        stack.push(1);      // inserting 1 in the stack
        stack.push(2);      // inserting 2 in the stack
 
        stack.pop();        // removing the top element (2)
        stack.pop();        // removing the top element (1)
 
        stack.push(3);      // inserting 3 in the stack
 
        System.out.println("The top element is " + stack.peek());
        System.out.println("The stack size is " + stack.size());
 
        stack.pop();        // removing the top element (3)
 
        // check if the stack is empty
        if (stack.isEmpty()) {
            System.out.println("The stack is empty");
        }
        else {
            System.out.println("The stack is not empty");
        }
    }
}
Download  Run Code


Output:
 
Inserting 1
Inserting 2
Removing 2
Removing 1
Inserting 3
The top element is 3
The stack size is 1
Removing 3
The stack is empty

 
The time complexity of push(), pop(), peek(), isEmpty(), isFull() and size() is constant, i.e., O(1).

Using Java Collections
The stack is also included in Java’s collection framework.
import java.util.Stack;
 
class Main
{
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<String>();
 
        stack.push("A");    // Insert `A` into the stack
        stack.push("B");    // Insert `B` into the stack
        stack.push("C");    // Insert `C` into the stack
        stack.push("D");    // Insert `D` into the stack
 
        // prints the top of the stack (`D`)
        System.out.println("The top element is " + stack.peek());
 
        stack.pop();        // removing the top element (`D`)
        stack.pop();        // removing the next top (`C)
 
        // returns the total number of elements present in the stack
        System.out.println("The stack size is " + stack.size());
 
        // check if the stack is empty
        if (stack.empty()) {
            System.out.println("The stack is empty");
        }
        else {
            System.out.println("The stack is not empty");
        }
    }
}

Output:
 
The top element is D
The stack size is 2
The stack is not empty
/////////////////////////////////////////////////////////////QUEUE//////////////////////////////////////////////////QUEUE/////////////////////////////////////////////////////////


The queue supports the following core operations:

Enqueue: Inserts an item at the rear of the queue.
Dequeue: Removes the object from the front of the queue, thereby decrementing queue size by one.
Peek: Returns the object at the front of the queue without removing it.
IsEmpty: Tests if the queue is empty or not.
Size: Returns the total number of elements present in the queue.

Queue Implementation using an array:
// A class to represent a queue
class Queue
{
    private int[] arr;      // array to store queue elements
    private int front;      // front points to the front element in the queue
    private int rear;       // rear points to the last element in the queue
    private int capacity;   // maximum capacity of the queue
    private int count;      // current size of the queue
 
    // Constructor to initialize a queue
    Queue(int size)
    {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }
 
    // Utility function to dequeue the front element
    public void dequeue()
    {
        // check for queue underflow
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }
 
        System.out.println("Removing " + arr[front]);
 
        front = (front + 1) % capacity;
        count--;
    }
 
    // Utility function to add an item to the queue
    public void enqueue(int item)
    {
        // check for queue overflow
        if (isFull())
        {
            System.out.println("Overflow\nProgram Terminated");
            System.exit(1);
        }
 
        System.out.println("Inserting " + item);
 
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }
 
    // Utility function to return the front element of the queue
    public int peek()
    {
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }
        return arr[front];
    }
 
    // Utility function to return the size of the queue
    public int size() {
        return count;
    }
 
    // Utility function to check if the queue is empty or not
    public Boolean isEmpty() {
        return (size() == 0);
    }
 
    // Utility function to check if the queue is full or not
    public Boolean isFull() {
        return (size() == capacity);
    }
}
 
class Main
{
    public static void main (String[] args)
    {
        // create a queue of capacity 5
        Queue q = new Queue(5);
 
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
 
        System.out.println("The front element is " + q.peek());
        q.dequeue();
        System.out.println("The front element is " + q.peek());
 
        System.out.println("The queue size is " + q.size());
 
        q.dequeue();
        q.dequeue();
 
        if (q.isEmpty()) {
            System.out.println("The queue is empty");
        }
        else {
            System.out.println("The queue is not empty");
        }
    }
}
Output:
 
Inserting 1
Inserting 2
Inserting 3
The front element is 1
Removing 1
The front element is 2
The queue size is 2
Removing 2
Removing 3
The queue is empty
Using Queue Interface:

Java’s library also contains Queue interface that specifies queue operations. 
  Following is an example of the Queue interface using the LinkedList class:

import java.util.LinkedList;
import java.util.Queue;
 
class Main
{
    public static void main(String[] args)
    {
        Queue<String> queue = new LinkedList<String>();
 
        queue.add("A");     // Insert `A` into the queue
        queue.add("B");     // Insert `B` into the queue
        queue.add("C");     // Insert `C` into the queue
        queue.add("D");     // Insert `D` into the queue
 
        // Prints the front of the queue (`A`)
        System.out.println("The front element is " + queue.peek());
 
        queue.remove();     // removing the front element (`A`)
        queue.remove();     // removing the front element (`B`)
 
        // Prints the front of the queue (`C`)
        System.out.println("The front element is " + queue.peek());
 
        // Returns the total number of elements present in the queue
        System.out.println("The queue size is " + queue.size());
 
        // check if the queue is empty
        if (queue.isEmpty()) {
            System.out.println("The queue is empty");
        }
        else {
            System.out.println("The queue is not empty");
        }
    }
}
