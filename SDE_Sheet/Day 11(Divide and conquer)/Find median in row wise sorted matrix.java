Find median in row wise sorted matrix
Given a matrix of integers A of size N x M in which each row is sorted.

Find an return the overall median of the matrix A.

Note: No extra memory is allowed.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.



Input Format

The first and only argument given is the integer matrix A.
Output Format

Return the overall median of the matrix A.
Constraints

1 <= N, M <= 10^5
1 <= N*M  <= 10^6
1 <= A[i] <= 10^9
N*M is odd
For Example

Input 1:
    A = [   [1, 3, 5],
            [2, 6, 9],
            [3, 6, 9]   ]
Output 1:
    5
Explanation 1:
    A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
    Median is 5. So, we return 5.

Input 2:
    A = [   [5, 17, 100]    ]
Output 2:
    17 ``` Matrix=
    
 Let’s take the example of a linear array first: -
let A : [1, 2, 3, 3, 5, 6, 6, 9, 9], size of A = 9
so the median element will be at 5th position (1-based indexing).

Let “favourable” be a property of x, (n is the size of array and n is odd) :
-> count of numbers smaller than or equal to x (in array) is greater or equal to 1 + (n/2)

Observation: Median is the smallest favourable number in our array.
or in other words: median = M , s.st M is favourable and M-1 is not favourable.
It is something like FFFFTTTTT, and we need the first T.
// T means favourable propery is true for that number
To solve this subproblem we can use binary search.

Now coming back to our matrix.
Our matrix after flattening will have nm elements, so a number will be favourable 
if the count of lower and equal elements in the matrix is greater than or equal to (nm/2) + 1.
 // here range of A[i] is 1 to 1e9 , so I have not calculated the minima or maxima or matrix
    int start = 1;
    int end = 1e9;
    int n = A.size();
    int m = A[0].size();
    int reqSmallerCount = (n*m)/2+1;
    // favourable property of a number x : 
            // count of number in matrix less than or equal to x is >= reqSmallerCount
    // F : the number if not favourable 
    // T : number if favourable
    // FFFFFFFFTTTTTTTTT
    // ans will store the first element which have T (left to right)
    int ans = -1;
    while(end>=start){
        int mid = start + (end-start)/2;
        int count = 0;
        for(int i=0;i<n;++i){
            count+=upper_bound(A[i].begin(),A[i].end(),mid) - A[i].begin();
        }
        if(count>=reqSmallerCount){
            // any number greater than mid will also have favourable property
            // so check for elements smaller than current number
            // and store the current element as possible answer
            // if any number smaller than mid is favourable, then ans will be updated
            ans = mid;
            end = mid-1;
        }
        else{
            start = mid+1;
        }
    }
    return ans;

for each number, we can find this count in O(nlog(m), using upper_bound in each array row.

//////////////////////////
 int m = arr.length, n = arr[0].length;
    int min = 0, max = 0;
    
    for(int i=0; i<m; i++){
        
        min = Math.min(min, arr[i][0]);
        max = Math.max(max, arr[i][n-1]);
    }
    
    int median = (1 + m * n) / 2;
    
    while(min < max){
        
        int mid = min + (max - min)/2;
        
        int count = 0, get = 0;
        
        for(int i=0; i<m; i++){
            
            get = Arrays.binarySearch(arr[i], mid);
            
            if(get < 0){
                get = Math.abs(get) - 1;
            }
            else{
                while(get < n && arr[i][get] == mid)
                    get++;
            }
            
            count = count + get;
        }
        
        if(count < median)
            min = mid + 1;
        else 
            max = mid;
    }
    
    return min;
}
