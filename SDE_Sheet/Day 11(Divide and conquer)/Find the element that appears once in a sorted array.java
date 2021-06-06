Given a sorted array in which all elements appear twice (one after one) and one element appears only once. Find that element in O(log n) complexity.

Example: 

Input:   arr[] = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8}
Output:  4

Input:   arr[] = {1, 1, 3, 3, 4, 4, 5, 5, 7, 7, 8}
Output:  8
  
  A Simple Solution is to traverse the array from left to right. Since the array is sorted, we can easily figure out the required element.

Below is the implementation of the above approach.
  // Java program to find the element that
// appears only once
import java.io.*;

class GFG {
	// A Linear Search based function to find
	// the element that appears only once
	static void search(int arr[], int n)
	{
		int ans = -1;
		for (int i = 0; i < n; i += 2) {
			if (arr[i] != arr[i + 1]) {
				ans = arr[i];
				break;
			}
		}
	
		if (arr[n - 2] != arr[n - 1])
			ans = arr[n-1];
	
		// ans = -1 if no such element is present.
		System.out.println("The required element is "
						+ ans);
	}
	public static void main(String[] args)
	{
		int arr[] = { 1, 1, 2, 4, 4, 5, 5, 6, 6 };
		int len = arr.length;

		search(arr, len);
	}
}

/////////////////////////////////////////////////////////////
Another Simple Solution is to use the properties of XOR (a ^ a = 0 & a ^ 0 = a). The idea is to find the XOR of the complete array. The XOR of the array is the required answer.

Below is the implementation of the above approach.
  // Java program to find the element that
// appears only once
import java.io.*;

class GFG {
	// A XOR based function to find
	// the element that appears only once
	static void search(int arr[], int n)
	{
		int XOR = 0;
		for (int i = 0; i < n; i++) {
			XOR = XOR ^ arr[i];
		}
		System.out.println("The required element is "
						+ XOR);
	}
	// Driver Code
	public static void main(String[] args)
	{
		int arr[] = { 1, 1, 2, 4, 4, 5, 5, 6, 6 };
		int len = arr.length;

		search(arr, len);
	}
}
Output
The required element is 2
Time Complexity: O(n)
Space Complexity: O(1) 
//////////////////////////////////////////////////////
An Efficient Solution can find the required element in O(Log n) time. The idea is to use Binary Search. Below is an observation on the input array. 
All elements before the required have the first occurrence at even index (0, 2, ..) and the next occurrence at odd index (1, 3, …). And all elements after the required elements have the first occurrence at an odd index and the next occurrence at an even index. 
1) Find the middle index, say ‘mid’.
2) If ‘mid’ is even, then compare arr[mid] and arr[mid + 1]. If both are the same, then the required element after ‘mid’ and else before mid.
3) If ‘mid’ is odd, then compare arr[mid] and arr[mid – 1]. If both are the same, then the required element after ‘mid’ and else before mid.

Below is the implementation based on the above idea: 
// Java program to find the element that appears only once

public class Main {
	// A Binary Search based method to find the element
	// that appears only once
	public static void search(int[] arr, int low, int high)
	{
		if (low > high)
			return;
		if (low == high) {
			System.out.println("The required element is "
							+ arr[low]);
			return;
		}

		// Find the middle point
		int mid = (low + high) / 2;

		// If mid is even and element next to mid is
		// same as mid, then output element lies on
		// right side, else on left side
		if (mid % 2 == 0) {
			if (arr[mid] == arr[mid + 1])
				search(arr, mid + 2, high);
			else
				search(arr, low, mid);
		}
		// If mid is odd
		else if (mid % 2 == 1) {
			if (arr[mid] == arr[mid - 1])
				search(arr, mid + 1, high);
			else
				search(arr, low, mid - 1);
		}
	}

	// Driver Code
	public static void main(String[] args)
	{
		int[] arr = { 1, 1, 2, 4, 4, 5, 5, 6, 6 };
		search(arr, 0, arr.length - 1);
	}
}
Output
The required element is 2
Time Complexity: O(Log n)
