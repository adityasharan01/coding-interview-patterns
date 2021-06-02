Find square of a number without using multiplication or division operators.

//Method 1:
//Idea is based on the fact square root of any number n can be calculated by adding odd numbers exactly n  times.
1 ^2 =1
  2^2= (1+3)=4
  3^2=(1+3+5)=9
  4^2=(1+3+5+7)=16
  
class Main
{
    public static int findSquare(int num)
    {
        int odd = 1;
        int sq = 0;
 
        // convert the number to positive if it is negative
        num = Math.abs(num);
 
        while (num-- > 0)
        {
            sq = sq + odd;
            odd = odd + 2;
        }
 
        return sq;
    }
 
    public static void main(String[] args)
    {
        System.out.println(findSquare(8));
        System.out.println(findSquare(-4));
    }
}

//Method 2: Repeatedly adding a given number to the result
The idea is to repeatedly add a given number to result n times.
  
  class Main
{
    public static int findSquare(int num)
    {
        // convert the number to positive if it is negative
        num = Math.abs(num);
 
        // stores square of the number
        int sq = num;
 
        // repeatedly add `num` to the result
        for (int i = 1; i < num; i++) {
            sq = sq + num;
        }
 
        return sq;
    }
 
    public static void main(String[] args) {
        System.out.print(findSquare(8) + " " + findSquare(-4));
    }
}



  
For n = 5, 52 = (5 + 5 + 5 + 5 + 5) = 25
