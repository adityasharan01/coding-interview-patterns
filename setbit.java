Recursion
if(n==0)
  return0
 return n&1 +(n>>1);

//Iteration 
count=0;
while(n>0)
{
  n&=(n-1);
  count++;
}
reutrn count;
