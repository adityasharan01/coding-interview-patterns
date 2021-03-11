A simple solution would be to perform a counting sort. We count the total number of 0’s, 1’s, and 2’s and then put them in the array in their correct order. The time complexity of this solution is O(n), where n is the size of the input. However, this requires two traversals of the array.

 
We can rearrange the array in a single traversal using an alternative linear-time partition routine that separates the values into three groups:
the value less than pivot,
the value equal to pivot ,
the value more than pivot
To solve this particular problem, consider 1 as a pivot. The following linear-time partition routine in C++, Java, and Python is similar to 3–way partitioning for the Dutch national flag problem.


import java.util.Arrays;
 
class Main
{
    // Linear time partition routine to sort an array containing 0, 1, and 2.
    // It is similar to 3–way partitioning for the Dutch national flag problem.
    public static void threeWayPartition(int[] A, int end)
    {
        int start = 0, mid = 0;
        int pivot = 1;
 
        while (mid <= end)
        {
            if (A[mid] < pivot)         // current element is 0
            {
                swap(A, start, mid);
                ++start;
                ++mid;
            }
            else if (A[mid] > pivot)    // current element is 2
            {
                swap(A, mid, end);
                --end;
            }
            else {                      // current element is 1
                ++mid;
            }
        }
    }
 
    // Utility function to swap elements `A[i]` and `A[j]` in the array
    private static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
 
    public static void main (String[] args)
    {
        int[] A = { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 };
 
        threeWayPartition(A, A.length - 1);
        System.out.println(Arrays.toString(A));
    }
}
