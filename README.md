
# Leetcode Solutions
The repository full of solutions to questions hosted on [Leetcode](https://www.leetcode.com/) along with data structures in Python,So that one can simply understand how all data structure works and build up.

It is **NOT** advisable to directly copy and paste the solution and make them work for you, but I would recommend you to first try out finding right, efficient and optimized solution by yourself and in case after a lot of tries you are unable to do so then you can anyday take help from this repository.
Consider asking the following questions.

How big is the size of the input?
How big is the range of values?
What kind of values are there? Are there negative numbers? Floating points? Will there be empty inputs?
Are there duplicates within the input?
What are some extreme cases of the input?
How is the input stored? If you are given a dictionary of words, is it a list of strings or a trie?

General tips
Always validate input first. Check for inputs that are invalid, empty, negative, or different. Never assume you are given the valid parameters. Alternatively, clarify with the interviewer whether you can assume valid input (usually yes), which can save you time from writing code that does input validation.

Are there any time and space complexities requirements or constraints?

Check for off-by-one errors.

In languages where there are no automatic type coercion, check that concatenation of values are of the same type: int,str, and list.

After you finish your code, use a few example inputs to test your solution.

Is the algorithm supposed to run multiple times, perhaps on a web server? If yes, the input can likely be pre-processed to improve the efficiency in each API call.

Use a mix of functional and imperative programming paradigms:

Write pure functions as often as possible.
Use pure functions because they are easier to reason with and can help reduce bugs in your implementation.
Avoid mutating the parameters passed into your function, especially if they are passed by reference, unless you are sure of what you are doing.
Achieve a balance between accuracy and efficiency. Use the right amount of functional and imperative code where appropriate. Functional programming is usually expensive in terms of space complexity because of non-mutation and the repeated allocation of new objects. On the other hand, imperative code is faster because you operate on existing objects.
Avoid relying on mutating global variables. Global variables introduce state.
Make sure that you do not accidentally mutate global variables, especially if you have to rely on them. 

You can come and say thanks for compiling all these for you at - [Contact](mailto:ranjan.aditya2009@gmail.com)
My personal website [Aditya Sharan](https://adityasharan.netlify.app/)

![Coder at Work](https://cloud.githubusercontent.com/assets/4745789/21447248/0884e3b8-c8f8-11e6-8ce3-74ff6502cbca.gif)

Happy Coding :)


+ Thinking Patterns that I have used for solving Algorithmic Problems
1. Constraints → These are useful for narrowing down the time complexity which will solve the problem.
N ≤ 10^18 → O(log N) or O(1)
N ≤ 10 ^ 7 → O(N)
N ≤ 10 ^ 5 → O(N) or O(N log N)
N ≤ 10 ^ 4 → O(N log N) or O(N^2) in some cases
N ≤ 10 ^ 3 → O(N^2)
N ≤ 10^2 → O(N^3)
N ≤ 20 → O(2 ^ n)

2. To have a better time complexity increase space complexity and use precomputation.

3. To understand recursion, first understand mathematical induction. Both are exactly the same.

4. If the problem does not require the ordering of elements then consider sorting the array.

5. If the problem asks to find "x" or maximize/minimize x with huge constraints then probably it can be solved with binary search.

6. If we want efficient insert and delete operations from both sides of a list, we use the deque data structure.

7. O(1) complexity problems are usually solved by either a linked list (LRU cache) or 2 pointers.
8.  To choose which tree traversal to use for Binary trees and BST, check these
a. Do we need the answers for children first, then use the post order.
b. If we calculate the answer from the parent node then use the pre-order traversal else we can use the inorder traversal.
c. If we want to calculate the answer for a particular level before moving to the next, use the level order traversal.
d. If it's a BST and we want to iterate in the sorted order then we use the inorder traversal.

9. We usually tend to think about traversing the array from left to right direction. Sometimes the problem can be easily solved if we travel from right to left. Similarly for binary trees it might be useful to first traverse the right subtree and then the left. To generalize, think about solving the problem in reverse.

10. If our solution involves multiple choices at each step then probably it's based on dynamic programming.

11. Most dp problems have "position" as state. If it is 1-D dp, then "pos/i" will be in the state. If it's a matrix then "i, j" will be part of the state. To find other members which are part of the state, from the problem try to find variables which change with every transition.

If input array is sorted then
    - Binary search
    - Two pointers

If asked for all permutations/subsets then
    - Backtracking

If given a tree then
    - DFS
    - BFS

If given a graph then
    - DFS
    - BFS

If given a linked list then
    - Two pointers

If recursion is banned then
    - Stack

If must solve in-place then
    - Swap corresponding values
    - Store one or more different values in the same pointer

If asked for maximum/minumum subarray/subset/options then
    - Dynamic programming

If asked for top/least K items then
    - Heap

If asked for common strings then
    - Map
    - Trie

Else
    - Map/Set for O(1) time & O(n) space
    - Sort input for O(nlogn) time and O(1) space
## Arrays
Corner Cases
Empty sequence
Sequence with 1 or 2 elements
Sequence with repeated elements
## Strings
Corner Cases
Empty string
Single-character string
Strings with only one distinct character
## Binary
Corner Cases
Check for overflow/underflow
Negative numbers
## Interval
Corner Cases
Single interval
Non-overlapping intervals
An interval totally consumed within another interval
Duplicate intervals
## Linked list
Corner Cases
Single node
Two nodes
Linked list has cycle. Clarify with the interviewer whether there can be a cycle in the list. Usually the answer is no.
## Math
Corner Cases
Division by 0
Integer overflow and underflow
///////////
## Matrix
Corner Cases
Empty matrix. Check that none of the arrays are 0 length.
1 x 1 matrix.
Matrix with only one row or column.
## Tree
Corner Cases
Empty tree
Single node
Two nodes
Very skewed tree (like a linked list)

## Top 10 Algorithmic Coding Questions
1. DFS
2. BFS
3. Matching Parenthesis problem
4. Using Hash Tables
5. Variables/Pointers manipulation( manipulate the iterating pointers in array or string )
6. reverse linked list (duplicates , removing duplicates)
7. sorting fundamentals (quicksort, mergesort,bubblesort techniques ,
   runtime of a sort,time space complexity)
8. Recursion
9. custom data structures (object oriented programming)

10.Binary search
