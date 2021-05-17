Merge Without Extra Space
Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order without using any extra space. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.
 

Example 1:

Input: 
n = 4, arr1[] = [1 3 5 7] 
m = 5, arr2[] = [0 2 6 8 9]
Output: 
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]
Explanation:
After merging the two 
non-decreasing arrays, we get, 
0 1 2 3 5 6 7 8 9.
Example 2:

Input: 
n = 2, arr1[] = [10, 12] 
m = 3, arr2[] = [5 18 20]
Output: 
arr1[] = [5 10]
arr2[] = [12 18 20]
Explanation:
After merging two sorted arrays 
we get 5 10 12 18 20.


Your Task:
You don't need to read input or print anything. You only need to complete the function merge() that takes arr1, arr2, n and m as input parameters and modifies them in-place so that they look like the sorted merged array when concatenated.
 

Expected Time Complexity:  O((n+m) log(n+m))
Expected Auxilliary Space: O(1)



//Approach 1:
lass Solution{
    public:
        //Function to merge the arrays.
        public static void merge(int arr1[], int arr2[], int n, int m) 
    {
        // code here 
        int b[]=new int[m+n];
        int i=0,j=0,k=0;
        
        while(i<n && j<m)
        {
            if(arr1[i]<arr2[j])
            {
            b[k]=arr1[i];
            i++;
            }
            else
            {
            b[k]=arr2[j];
            j++;
            }
            k++;
        }
        while(i<n)
        b[k++]=arr1[i++];
        while(j<m)
        b[k++]=arr2[j++];
        int l,m1;
        for(l=0;l<n;l++)
        arr1[l]=b[l];
        for(m1=0;m1<m;m1++)
        arr2[m1]=b[l++];
    }
};

//Approach 2:
class MergeSort
{
    // Function to merge the two sorted arrays
    // arr1[], arr2[]: two input arrays
    // n, m: size of arr1[] and arr2[] respectively
    public static void merge(int arr1[], int arr2[], int n, int m) 
    {
       // add your code here 
       int a[]=new int[m+n];
       for(int i=0;i<m;i++) a[i]=arr2[i];
       for(int i=0;i<n;i++) a[m+i]=arr1[i];
       Arrays.sort(a);
       for(int i=0;i<n;i++) arr1[i]=a[i];
       for(int i=0;i<m;i++) arr2[i]=a[i+n];
    }
}
