Two Sum - 
Given an unsorted integer array,Find a pair with given sum in it.



Method 1 :- Naive Approach

class Main
{
    // Naive method to find a pair in an array with a given sum
    public static void findPair(int[] A, int sum)
    {
        // consider each element except the last
        for (int i = 0; i < A.length - 1; i++)
        {
            // start from the i'th element until the last element
            for (int j = i + 1; j < A.length; j++)
            {
                // if the desired sum is found, print it
                if (A[i] + A[j] == sum)
                {
                    System.out.println("Pair found at index " + i + " and " + j);
                    return;
                }
            }
        }
 
        // we reach here if the pair is not found
        System.out.println("Pair not found");
    }
 
    public static void main (String[] args)
    {
        int[] A = { 8, 7, 2, 5, 3, 1 };
        int sum = 10;
 
        findPair(A, sum);
    }
}

Method 2 Solution Using Sorting
import java.util.Arrays;
 
class Main
{
    // Function to find a pair in an array with a given sum using sorting
    public static void findPair(int[] A, int sum)
    {
        // sort the array in ascending order
        Arrays.sort(A);
 
        // maintain two indices pointing to endpoints of the array
        int low = 0;
        int high = A.length - 1;
 
        // reduce the search space `A[low…high]` at each iteration of the loop
 
        // loop till the search space is exhausted
        while (low < high)
        {
            // sum found
            if (A[low] + A[high] == sum)
            {
                System.out.println("Pair found");
                return;
            }
 
            // increment `low` index if the total is less than the desired sum;
            // decrement `high` index if the total is more than the desired sum
            if (A[low] + A[high] < sum) {
                low++;
            }
            else {
                high--;
            }
        }
 
        // we reach here if the pair is not found
        System.out.println("Pair not found");
    }
 
    public static void main (String[] args)
    {
        int[] A = { 8, 7, 2, 5, 3, 1 };
        int sum = 10;
 
        findPair(A, sum);
    }
}
