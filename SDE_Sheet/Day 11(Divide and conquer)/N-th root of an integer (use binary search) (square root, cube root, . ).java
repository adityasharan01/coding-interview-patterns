N-th root of an integer (use binary search) (square root, cube root, ..)
  Calculating n-th real root using binary search
  Given two number x and n, find n-th root of x. 

Examples: 

Input : 5 2
Output : 2.2360679768025875

Input :  x = 5, n = 3
Output : 1.70997594668
  
  In order to calculate nth root of a number, we can use the following procedure.  



If x lies in the range [0, 1) then we set the lower limit low = x and upper limit high = 1, because for this range of numbers the nth root is always greater than the given number and can never exceed 1.
eg- $\sqrt{0.09} = 0.3$.
Otherwise, we take low = 1 and high = x.
Declare a variable named epsilon and initialize it for accuracy you need. 
Say epsilon=0.01, then we can guarantee that our guess for nth root of the given number will be 
correct up to 2 decimal places.
Declare a variable guess and initialize it to guess=(low+high)/2.
Run a loop such that: 
if the absolute error of our guess is more than epsilon then do: 
if guessn > x, then high=guess
else low=guess
Making a new better guess i.e., guess=(low+high)/2.
If the absolute error of our guess is less than epsilon then exit the loop.
                        
     
                        
   // Java Program to find n-th real root of x
class GFG
{
    static void findNthRoot(double x, int n)
    {
 
        // Initialize boundary values
        double low, high;
        if (x >= 0 && x <= 1)
        {
            low = x;
            high = 1;
        }
        else
        {
            low = 1;
            high = x;
        }
 
        // used for taking approximations
        // of the answer
        double epsilon = 0.00000001;
 
        // Do binary search
        double guess = (low + high) / 2;
        while (Math.abs((Math.pow(guess, n)) - x)
               >= epsilon)
        {
            if (Math.pow(guess, n) > x)
            {
                high = guess;
            }
            else
            {
                low = guess;
            }
            guess = (low + high) / 2;
        }
 
        System.out.println(guess);
    }
 
    // Driver code
    public static void main(String[] args)
    {
        double x = 5;
        int n = 2;
        findNthRoot(x, n);
    }
}
 
