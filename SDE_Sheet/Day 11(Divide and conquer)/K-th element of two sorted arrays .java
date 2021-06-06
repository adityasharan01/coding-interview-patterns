K-th element of two sorted arrays 

Given two sorted arrays arr1 and arr2 of size M and N respectively and an element K. The task is to find the element that would be at the k’th position of the final sorted array.
 

Example 1:

Input:
arr1[] = {2, 3, 6, 7, 9}
arr2[] = {1, 4, 8, 10}
k = 5
Output:
6
Explanation:
The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.
Example 2:
Input:
arr1[] = {100, 112, 256, 349, 770}
arr2[] = {72, 86, 113, 119, 265, 445, 892}
k = 7
Output:
256
Explanation:
Final sorted array is - 72, 86, 100, 112,
113, 119, 256, 265, 349, 445, 770, 892
7th element of this array is 256.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function kthElement() which takes the arrays arr1[], arr2[], its size N and M respectively and an integer K as inputs and returns the element at the Kth position.


Expected Time Complexity: O(Log(N) + Log(M))
Expected Auxiliary Space: O(Log (N))


Constraints:
1 <= N, M <= 106
1 <= arr1i, arr2i <= 106
1 <= K <= N+M
///////////////////////////////////////////////////////////////////////////
This question is similar with find the kth smallest number in two sorted array.
How these k elements distributed among two arrays? Let's say the first x elements come from A and k-x elements come from B. Intuitively, if we find x, we could find the kth element.
So 0 <= x <= len(A) and 0<= k - x <= len(B) --> max{0, k - len(B)} <= x <= min{len(A), k}
Set two pointers and initialize as: l =max{0, k - len(B)} , r = min{len(A), k}. While l and r don't overlap each other, we take the mid = l + (r-l)/2.

A[mid] < B[k - mid - 1], A[mid] is among first k-1 elements, so update l = mid + 1.
    mid - 1, mid
A [... 2, 5... ]
B [...7,  9...]
A[mid - 1] > B[k - mid], A[mid - 1] cannot be among k elements, so update r = mid - 1.
    mid - 1, mid
A [... 2, 5... ]
B [...1, 1...]
otherwise, A[mid] >= B[k - mid - 1] and A[mid - 1] <= B[k - mid], return max{A[mid - 1], B[k - mid - 1]}.
    mid - 1, mid
A [... 2, 5... ]
B [...1, 7...]
When the loop breaks, where x = l = r, we return max{A[mid - 1], B[k - mid - 1]}.
Time: O(log (m + n)) | Space: O(1)
  
  ///////////////////////////////////////////////////////
  Basic Approach 
Since we are given two sorted arrays, we can use the merging technique to get the final merged array. From this, we simply go to the k'th index. 

// Java Program to find kth element 
// from two sorted arrays

class Main
{
    static int kth(int arr1[], int arr2[], int m, int n, int k)
    {
        int[] sorted1 = new int[m + n];
        int i = 0, j = 0, d = 0;
        while (i < m && j < n)
        {
            if (arr1[i] < arr2[j])
                sorted1[d++] = arr1[i++];
            else
                sorted1[d++] = arr2[j++];
        }
        while (i < m)
            sorted1[d++] = arr1[i++];
        while (j < n)
            sorted1[d++] = arr2[j++];
        return sorted1[k - 1];
    }
    
    // Driver Code
    public static void main (String[] args) 
    {
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
        int k = 5;
        System.out.print(kth(arr1, arr2, 5, 4, k));
    }
}
////////////////////////////////////////////////////////////////////
Space Optimized Version of above approach: We can avoid the use of extra array.
  import java.io.*;

class GFG {
    public static int find(int A[], int B[], int m, int n,
                           int k_req)
    {
        int k = 0, i = 0, j = 0;

        // Keep taking smaller of the current
        // elements of two sorted arrays and
        // keep incrementing k
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                k++;
                if (k == k_req)
                    return A[i];
                i++;
            }
            else {
                k++;
                if (k == k_req)
                    return B[j];
                j++;
            }
        }

        // If array B[] is completely traversed
        while (i < m) {
            k++;
            if (k == k_req)
                return A[i];
            i++;
        }

        // If array A[] is completely traversed
        while (j < n) {
            k++;
            if (k == k_req)
                return B[j];
            j++;
        }
        return -1;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] A = { 2, 3, 6, 7, 9 };
        int[] B = { 1, 4, 8, 10 };
        int k = 5;

        System.out.println(find(A, B, 5, 4, k));
    }
}
//////////////////////////////
Divide And Conquer Approach 1 
While the previous method works, can we make our algorithm more efficient? The answer is yes. By using a divide and conquer approach, similar to the one used in binary search, we can attempt to find the k'th element in a more efficient way.
Compare the middle elements of arrays arr1 and arr2, let us call these indices mid1 and mid2 respectively. Let us assume arr1[mid1]  k, then clearly the elements after mid2 cannot be the required element. Set the last element of arr2 to be arr2[mid2].
In this way, define a new subproblem with half the size of one of the arrays.
  
// Program to find k-th element from two sorted arrays
#include <iostream>
using namespace std;

int kth(int *arr1, int *arr2, int *end1, int *end2, int k)
{
    if (arr1 == end1)
        return arr2[k];
    if (arr2 == end2)
        return arr1[k];
    int mid1 = (end1 - arr1) / 2;
    int mid2 = (end2 - arr2) / 2;
    if (mid1 + mid2 < k)
    {
        if (arr1[mid1] > arr2[mid2])
            return kth(arr1, arr2 + mid2 + 1, end1, end2,
                k - mid2 - 1);
        else
            return kth(arr1 + mid1 + 1, arr2, end1, end2,
                k - mid1 - 1);
    }
    else
    {
        if (arr1[mid1] > arr2[mid2])
            return kth(arr1, arr2, arr1 + mid1, end2, k);
        else
            return kth(arr1, arr2, end1, arr2 + mid2, k);
    }
}

int main()
{
    int arr1[5] = {2, 3, 6, 7, 9};
    int arr2[4] = {1, 4, 8, 10};

    int k = 5;
    cout << kth(arr1, arr2, arr1 + 5, arr2 + 4,  k - 1);
    return 0;
} 
////////////////////////////////////////////
Divide And Conquer Approach 2 
While the above implementation is very efficient, we can still get away with making it more efficient. Instead of dividing the array into segments of n / 2 and m / 2 then recursing, we can divide them both by k / 2 and recurse. The below implementation displays this. 


Explanation:

Instead of comparing the middle element of the arrays,

we compare the k / 2nd element.

Let arr1 and arr2 be the arrays.

Now, if arr1[k / 2]  arr1[1]



New subproblem:

Array 1 - 6 7 9

Array 2 - 1 4 8 10

k = 5 - 2 = 3



floor(k / 2) = 1

arr1[1] = 6

arr2[1] = 1

arr1[1] > arr2[1]



New subproblem:

Array 1 - 6 7 9

Array 2 - 4 8 10

k = 3 - 1 = 2



floor(k / 2) = 1

arr1[1] = 6

arr2[1] = 4

arr1[1] > arr2[1]



New subproblem:

Array 1 - 6 7 9

Array 2 - 8 10

k = 2 - 1 = 1



Now, we directly compare first elements,

since k = 1. 

arr1[1] < arr2[1]

Hence, arr1[1] = 6 is the answer.
  
// Java Program to find kth element from two sorted arrays
class GFG 
{

    static int kth(int arr1[], int arr2[], int m,
                   int n, int k, int st1, int st2) 
    {
        // In case we have reached end of array 1
        if (st1 == m) 
        {
            return arr2[st2 + k - 1];
        }

        // In case we have reached end of array 2
        if (st2 == n) 
        {
            return arr1[st1 + k - 1];
        }

        // k should never reach 0 or exceed sizes
        // of arrays
        if (k == 0 || k > (m - st1) + (n - st2)) 
        {
            return -1;
        }

        // Compare first elements of arrays and return
        if (k == 1) 
        {
            return (arr1[st1] < arr2[st2])
                    ? arr1[st1] : arr2[st2];
        }
        int curr = k / 2;

        // Size of array 1 is less than k / 2
        if (curr - 1 >= m - st1)
        {
            
            // Last element of array 1 is not kth
            // We can directly return the (k - m)th
            // element in array 2
            if (arr1[m - 1] < arr2[st2 + curr - 1]) 
            {
                return arr2[st2 + (k - (m - st1) - 1)];
            } 
            else 
            {
                return kth(arr1, arr2, m, n, k - curr,
                        st1, st2 + curr);
            }
        }

        // Size of array 2 is less than k / 2
        if (curr - 1 >= n - st2)
        {
            if (arr2[n - 1] < arr1[st1 + curr - 1]) 
            {
                return arr1[st1 + (k - (n - st2) - 1)];
            }
            else 
            {
                return kth(arr1, arr2, m, n, k - curr,
                        st1 + curr, st2);
            }
        } 
        else
        
        // Normal comparison, move starting index
        // of one array k / 2 to the right
        if (arr1[curr + st1 - 1] < arr2[curr + st2 - 1])
        {
            return kth(arr1, arr2, m, n, k - curr,
                    st1 + curr, st2);
        } 
        else 
        {
            return kth(arr1, arr2, m, n, k - curr,
                    st1, st2 + curr);
        }
    }

    // Driver code
    public static void main(String[] args) 
    {
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
        int k = 5;
        int st1 = 0, st2 = 0;
        System.out.println(kth(arr1, arr2, 5, 4, k, st1, st2));
    }
} 

////////////////////////////////////////////
Another Approach: (Using Min Heap)


Push the elements of both arrays to a priority queue (min-heap).
Pop-out k-1 elements from the front.
Element at the front of the priority queue is the required answer.
  // Java Program to find kth element 
// from two sorted arrays
import java.util.*;

class GFG {
  
    // Function to find K-th min
    static int kth(int a[], int b[], 
                   int n, int m, int k)
    {
        
        // Declaring a min heap
        PriorityQueue<Integer> pq = 
                        new PriorityQueue<>();

        // Pushing elements for 
        // array a to min-heap
        for (int i = 0; i < n; i++) {
            pq.offer(a[i]);
        }

        // Pushing elements for 
        // array b to min-heap
        for (int i = 0; i < m; i++) {
            pq.offer(b[i]);
        }

        // Poping-out K-1 elements
        while (k-- > 1) {
            pq.remove();
        }
        return pq.peek();
    }
  
    // Driver Code
    public static void main(String[] args)
    {
        int arr1[] = { 2, 3, 6, 7, 9 };
        int arr2[] = { 1, 4, 8, 10 };
        int k = 5;
        System.out.print(kth(arr1, arr2, 5, 4, k));
    }
}
