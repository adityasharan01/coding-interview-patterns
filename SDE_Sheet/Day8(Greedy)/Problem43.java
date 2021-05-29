Minimum Platforms 
Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms,

 

Example 1:

Input: n = 6 
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation: 
Minimum 3 platforms are required to 
safely arrive and depart all trains.
Example 2:

Input: n = 3
arr[] = {0900, 1100, 1235}
dep[] = {1000, 1200, 1240}
Output: 1
Explanation: Only 1 platform is required to 
safely manage the arrival and departure 
of all trains. 
  
  
Approach: The idea is to take every interval one by one and find the number of intervals that overlap with it. Keep track of the maximum number of intervals that overlap with an interval. Finally, return the maximum value.

Algorithm:
Run two nested loops the outer loop from start to end and inner loop from i+1 to end.
For every iteration of outer loop find the count of intervals that intersect with the current interval.
Update the answer with maximum count of overlap in each iteration of outer loop.
Print the answer.
  // Returns minimum number of platforms reqquired
int findPlatform(int arr[], int dep[], int n)
{

    // plat_needed indicates number of platforms
    // needed at a time
    int plat_needed = 1, result = 1;
    int i = 1, j = 0;

    // run a nested  loop to find overlap
    for (int i = 0; i < n; i++) {
        // minimum platform
        plat_needed = 1;

        for (int j = i + 1; j < n; j++) {
            // check for overlap
            if ((arr[i] >= arr[j] && arr[i] <= dep[j]) || (arr[j] >= arr[i] && arr[j] <= dep[i]))
                plat_needed++;
        }

        // update result
        result = max(result, plat_needed);
    }

    return result;
}

//Efficient Solution:

/*Approach: The idea is to consider all events in sorted order. 
  Once the events are in sorted order, trace the number of trains at any time 
  keeping track of trains that have arrived, but not departed.*/
/*Algorithm:
Sort the arrival and departure time of trains.
Create two pointers i=0, and j=0 and a variable to store ans and current count plat
Run a loop while i<n and j<n and compare the ith element of arrival array and jth element of departure array.
if the arrival time is less than or equal to departure then one more platform is needed so increase the count, i.e. plat++ and increment i
Else if the arrival time greater than departure then one less platform is needed so decrease the count, i.e. plat++ and increment j. */

 static int findPlatform(int arr[], int dep[], int n)
    {
        // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        // plat_needed indicates number of platforms
        // needed at a time
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        // Similar to merge in merge sort to process
        // all events in sorted order
        while (i < n && j < n) {

            // If next event in sorted order is arrival,
            // increment count of platforms needed
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            }

            // Else decrement count of platforms needed
            else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }

            // Update result if needed
            if (plat_needed > result)
                result = plat_needed;
        }

        return result;
    }

/*
MAP BASED APPROACH: In this post, we are inserting all 
the arrival and departure times in a multimap. 
  The first value of the element in multimap tells the arrival/departure time and second value tells whether 
  it's arrival or departure represented by 'a' or 'd' respectively.
If its arrival then do increment by 1 otherwise decrease the value by 1. 
  If we are taking the input from STDIN then we can directly insert the times in the multimap and no need to store the times in the array.

Update the ans, i.e ans = max(ans, plat).*/

int findPlatform(int arr[], int dep[], int n)
{
    // Insert all the times (arr. and dep.)
    // in the multimap.
    multimap<int, char> order;
    for (int i = 0; i < n; i++) {

        // If its arrival then second value
        // of pair is 'a' else 'd'
        order.insert(make_pair(arr[i], 'a'));
        order.insert(make_pair(dep[i], 'd'));
    }

    int result = 0;
    int plat_needed = 0;

    multimap<int, char>::iterator it = order.begin();

    // Start iterating the multimap.
    for (; it != order.end(); it++) {

        // If its 'a' then add 1 to plat_needed
        // else minus 1 from plat_needed.
        if ((*it).second == 'a')
            plat_needed++;
        else
            plat_needed--;

        if (plat_needed > result)
            result = plat_needed;
    }
    return result;
}
