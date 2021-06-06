Median of 2 sorted arrays   
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).
Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
  ////////////////////////////////////////////
  /**
* Find the median by traversing.
*
* Time complexity: O(m+n). Although the running time is similar, it is worse than the required O(log (m+n)).
* Space complexity: O(1).
*
* @param nums1 the first sorted arrays
* @param nums2 the second sorted arrays
* @return the median of the two sorted arrays
*/

public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int index1 = 0;
    int index2 = 0;
    int med1 = 0;
    int med2 = 0;
    for (int i=0; i<=(nums1.length+nums2.length)/2; i++) {
        med1 = med2;
        if (index1 == nums1.length) {
            med2 = nums2[index2];
            index2++;
        } else if (index2 == nums2.length) {
            med2 = nums1[index1];
            index1++;
        } else if (nums1[index1] < nums2[index2] ) {
            med2 = nums1[index1];
            index1++;
        }  else {
            med2 = nums2[index2];
            index2++;
        }
    }

    // the median is the average of two numbers
    if ((nums1.length+nums2.length)%2 == 0) {
        return (float)(med1+med2)/2;
    }

    return med2;
}
  //////////////////////////////////////////////////////
Explanation

The key point of this problem is to ignore half part of A and B each step recursively by comparing the median of remaining A and B:

if (aMid < bMid) Keep [aRight + bLeft]    
else Keep [bRight + aLeft]
As the following: time=O(log(m + n))

public double findMedianSortedArrays(int[] A, int[] B) {
	    int m = A.length, n = B.length;
	    int l = (m + n + 1) / 2;
	    int r = (m + n + 2) / 2;
	    return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
	}

public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
	if (aStart > A.length - 1) return B[bStart + k - 1];            
	if (bStart > B.length - 1) return A[aStart + k - 1];                
	if (k == 1) return Math.min(A[aStart], B[bStart]);
	
	int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
	if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1]; 
	if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];        
	
	if (aMid < bMid) 
	    return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft 
	else 
	    return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
}
