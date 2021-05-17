
# Leetcode Solutions
The repository full of solutions to questions hosted on [Leetcode](https://www.leetcode.com/) along with data structures in Python,So that one can simply understand how all data structure works and build up.

It is **NOT** advisable to directly copy and paste the solution and make them work for you, but I would recommend you to first try out finding right, efficient and optimized solution by yourself and in case after a lot of tries you are unable to do so then you can anyday take help from this repository.

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
