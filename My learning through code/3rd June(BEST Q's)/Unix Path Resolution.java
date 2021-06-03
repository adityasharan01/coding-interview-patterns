Unix Path Resolution
Given a Unix path, represented as a list of strings, return its resolved version.

In Unix, ".." means to go to the previous directory and "." means to stay on the current directory. By resolving, we mean to evaluate the two symbols so that we get the final directory we're currently in.

Constraints

n ≤ 100,000 where n is the length of path
Example 1
Input
path = ["usr", "..", "usr", ".", "local", "bin", "docker"]
Output
["usr", "local", "bin", "docker"]
Explanation
The input represents "/usr/../usr/./local/bin" which resolves to "/usr/local/bin/docker"

Example 2
Input
path = ["bin", "..", ".."]
Output
[]
Explanation
The input represents "/bin/../.." which resolves to "/"

Intuition
The general observation is that whenever we have some random name, say usr, bin etc.. we simply can add it to our path
The only exceptions are when we see '.' and '..'
'.' case is simple. Just ignore it. Suppose we are on \usr\bin and we see '.' essentially means we will be on the same folder and hence dont need to do anything
'..' case is when we need to go back to the previous directory. So for anyone who is not exposed to this kind of problems you might assume that simply holding a previous variable is enough.. If we are at \usr\bin and we see a '..' and our previous entry is \usr\ simply replace current string with previous entry right??
This is not right. What if we see .. some 2 times? 3 times?.. This means we have to keep track of all previous paths. What is the natural data structure that helps us to go backwards?
\underline{Stack} 
Stack
​
 
Implementation
stack can hold all the entries we have currently seen in path and whenever we see '..' we can use the pop operation of stack to simply go one step backwards.
Essentially in python the list itself can function as a stack.
Example #1
['usr','bin','.','..','..']
We have usr now. stack=['usr']
We have bin now. stack=['usr', 'bin']. Notice how we are keeping track of the items we have seen naturally in stack
We see '.'. Ignore. as it wont change our path
We see '..' . Go one step backwards,using stack.pop(). stack=['usr']
We see '..' . Go one more step backwards,using stack.pop(). stack=[]
now our stack essentially contains our new resolved path. simply return it

import java.util.*;

class Solution {
    public String[] solve(String[] path) {
        Stack<String> st=new Stack<>();
        for(int i=0;i<path.length;i++){
            if(path[i].equals("."))
                continue;
            else if(path[i].equals(".."))
            {
                if(st.isEmpty()){
                    continue;
                }
                st.pop();
            }
            else{
                st.push(path[i]);
            }
        }
        String[] res=new String[st.size()];
        int i=st.size()-1;
        while(!st.isEmpty())
        {
            res[i--]=st.pop();
        }
        return res;
    }
}
