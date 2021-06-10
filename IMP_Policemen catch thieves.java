Given an array of size n that has the following specifications: 

Each element in the array contains either a policeman or a thief.
Each policeman can catch only one thief.
A policeman cannot catch a thief who is more than K units away from the policeman.
We need to find the maximum number of thieves that can be caught.
Examples: 
 

Input : arr[] = {'P', 'T', 'T', 'P', 'T'},
            k = 1.
Output : 2.
Here maximum 2 thieves can be caught, first
policeman catches first thief and second police-
man can catch either second or third thief.

Input : arr[] = {'T', 'T', 'P', 'P', 'T', 'P'}, 
            k = 2.
Output : 3.

Input : arr[] = {'P', 'T', 'P', 'T', 'T', 'P'},
            k = 3.
Output : 3.
  
A brute force approach would be to check all feasible sets of combinations of police and thief and return the maximum size set among them. Its time complexity is exponential and it can be optimized if we observe an important property. 
An efficient solution is to use a greedy algorithm. But which greedy property 
to use can be tricky. We can try using: “For each policeman from the left catch the nearest possible thief.” This works for example three given above but fails for example two as it outputs 2 which is incorrect. 
We may also try: “For each policeman from the left catch the farthest possible thief”. This works for example two given above but fails for example three as it outputs 2 which is incorrect. A symmetric argument can be applied to show that traversing for these from the right side of the array also fails. We can observe that thinking irrespective of the 
policeman and focusing on just the allotment works: 
1. Get the lowest index of policeman p and thief t. Make an allotment 
if |p-t| <= k and increment to the next p and t found. 
2. Otherwise increment min(p, t) to the next p or t found. 
3. Repeat above two steps until next p and t are found. 
4. Return the number of allotments made.
Below is the implementation of the above algorithm. It uses vectors to 
store the indices of police and thief in the array and processes them. 
  
 // Java program to find maximum number of
// thieves caught
import java.util.*;
import java.io.*;

class GFG
{
	// Returns maximum number of thieves
	// that can be caught.
	static int policeThief(char arr[], int n, int k)
	{
		int res = 0;
		ArrayList<Integer> thi = new ArrayList<Integer>();
		ArrayList<Integer> pol = new ArrayList<Integer>();

		// store indices in the ArrayList
		for (int i = 0; i < n; i++) {
			if (arr[i] == 'P')
			pol.add(i);
			else if (arr[i] == 'T')
			thi.add(i);
		}

		// track lowest current indices of
		// thief: thi[l], police: pol[r]
		int l = 0, r = 0;
		while (l < thi.size() && r < pol.size()) {

			// can be caught
			if (Math.abs(thi.get(l) - pol.get(r)) <= k) {
			res++;
			l++;
			r++;
			}
			
			// increment the minimum index
			else if (thi.get(l) < pol.get(r))
				l++;
			else
				r++;
		}
		return res;
	}

	// Driver program
	public static void main(String args[])
	{
		int k, n;
		char arr1[] =new char[] { 'P', 'T', 'T',
								'P', 'T' };
		k = 2;
		n = arr1.length;
		System.out.println("Maximum thieves caught: "
							+policeThief(arr1, n, k));
							
		char arr2[] =new char[] { 'T', 'T', 'P', 'P',
								'T', 'P' };
		k = 2;
		n = arr2.length;
		System.out.println("Maximum thieves caught: "
							+policeThief(arr2, n, k));
							
		char arr3[] = new char[]{ 'P', 'T', 'P', 'T',
								'T', 'P' };
		k = 3;
		n = arr3.length;
		System.out.println("Maximum thieves caught: "
							+policeThief(arr3, n, k));
	}
}Approach:
In this approach, first we find the leftmost policeman and thief. If we can’t find any policeman or thief then there will be no allotments at all. After that if current policeman can catch the current thief then make an allotment and find the next policeman and thief else there will be two cases as follows:
case 1: thief is left of policeman then find next thief
case 2: thief is right of policeman then find next policeman
Repeat the above process until we can find next policeman and thief.
We can optimize the space by maintaining two variables (for thief and policeman) to store their current indices instead of using two arrays.

Algorithm:
1. Initialize the current lowest indices of policeman in pol and thief in thi variable as -1.
2 Find the lowest index of policeman and thief.
3 If lowest index of either policeman or thief remain -1 then return 0.
4 If |pol – thi| <=k then make an allotment and find the next policeman and thief.
5 Else increment the min(pol , thi) to the next policeman or thief found.
6 Repeat the above two steps until we can find the next policeman and thief.
7 Return the number of allotments made.
Below is the implementation of the above algorithm.
// C++ program to find maximum number of thieves
// caught
#include <bits/stdc++.h>

using namespace std;

// Returns maximum number of thieves that can
// be caught.
int policeThief(char arr[], int n, int k)
{
	// Initialize the current lowest indices of
	// policeman in pol and thief in thi variable as -1
	int pol = -1, thi = -1, res = 0;

	// Find the lowest index of policemen
	for (int i = 0; i < n; i++) {
		if (arr[i] == 'P') {
			pol = i;
			break;
		}
	}

	// Find the lowest index of thief
	for (int i = 0; i < n; i++) {
		if (arr[i] == 'T') {
			thi = i;
			break;
		}
	}

	// If lowest index of either policemen or thief remain
	// -1 then return 0
	if (thi == -1 || pol == -1)
		return 0;

	while (pol < n && thi < n) {

		// can be caught
		if (abs(pol - thi) <= k) {

			pol = pol + 1;
			while (pol < n && arr[pol] != 'P') {
				pol = pol + 1;
			}

			thi = thi + 1;
			while (thi < n && arr[thi] != 'T') {
				thi = thi + 1;
			}

			res++;
		}

		// increment the current min(pol , thi) to
		// the next policeman or thief found
		else if (thi < pol) {
			thi = thi + 1;
			while (thi < n && arr[thi] != 'T') {
				thi = thi + 1;
			}
		}
		else {
			pol = pol + 1;
			while (pol < n && arr[pol] != 'P') {
				pol = pol + 1;
			}
		}
	}

	return res;
}

// Driver Code Starts.

int main()
{
	int k, n;

	char arr1[] = { 'P', 'T', 'T', 'P', 'T' };
	k = 2;
	n = sizeof(arr1) / sizeof(arr1[0]);
	cout << "Maximum thieves caught: "
		<< policeThief(arr1, n, k) << endl;

	char arr2[] = { 'T', 'T', 'P', 'P', 'T', 'P' };
	k = 2;
	n = sizeof(arr2) / sizeof(arr2[0]);
	cout << "Maximum thieves caught: "
		<< policeThief(arr2, n, k) << endl;

	char arr3[] = { 'P', 'T', 'P', 'T', 'T', 'P' };
	k = 3;
	n = sizeof(arr3) / sizeof(arr3[0]);
	cout << "Maximum thieves caught: "
		<< policeThief(arr3, n, k) << endl;

	return 0;
}

// Driver Code Ends
Output
Maximum thieves caught: 2
Maximum thieves caught: 3
Maximum thieves caught: 3
Time Complexity: O(N)
 Auxiliary Space: O(1)

