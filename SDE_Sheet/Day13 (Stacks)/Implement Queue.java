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

Output:
 
The front element is A
The front element is C
The queue size is 2
The queue is not empty
