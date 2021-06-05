Count and Say
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.

For example, the saying and conversion for digit string "3322251":


Given a positive integer n, return the nth term of the count-and-say sequence.

 

Example 1:

Input: n = 1
Output: "1"
Explanation: This is the base case.
Example 2:

Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 

Constraints:

1 <= n <= 30
  //////////////////////////////////////1//////////////////////////////////////////////
  I found nobody answered this question in Java. Actually I got some trouble even this question is not so hard.

Maybe many other people had some trouble too. So I put my answer here.

public class Solution {
    public String countAndSay(int n) {
	    	StringBuilder curr=new StringBuilder("1");
	    	StringBuilder prev;
	    	int count;
	    	char say;
	        for (int i=1;i<n;i++){
	        	prev=curr;
	 	        curr=new StringBuilder();       
	 	        count=1;
	 	        say=prev.charAt(0);
	 	        
	 	        for (int j=1,len=prev.length();j<len;j++){
	 	        	if (prev.charAt(j)!=say){
	 	        		curr.append(count).append(say);
	 	        		count=1;
	 	        		say=prev.charAt(j);
	 	        	}
	 	        	else count++;
	 	        }
	 	        curr.append(count).append(say);
	        }	       	        
	        return curr.toString();
        
    }
}
StringBuilder.append() is the default way to append one string to another. While I have tried String.cancate(),which is not working properly.
////////////////////////////////////////2////////////////////
   public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++){
            s = countIdx(s);
        }
        return s;
    }
    
    public String countIdx(String s){
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == c){
                count++;
            }
            else
            {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}
//////////////////////////////////////////////3////////////////////////////////////3//////////////////////3///////////////////////
Any comment is welcomed.
  
  Thoughts Before Coding
    - we will implement a recursive approach
        - For each of the number 'n'
            - We will first want to find the count and say (prev) for 'n - 1'
        - Then for each of the characters 'c' inside the 'prev'
            - We will want to keep track of the consecutive frequency of
              'c' inside 'prev'
            - Then if we are at the end of the string or the next character
              does not equal to 'c'
                - We will need to append 'count' and 'c' to our resulting
                  string for our current count and say for 'n'

Answer
    - Implement a recursive approach
        - What parameters do we need?
            - n, the current number we are processing
        - What is the base case?
            - If 'n' is equal to 1
                - Return "1"
        - In each of the recursive call
            - Recursively find the 'prev' string for 'n - 1'
                - n => n - 1
            - Create a StringBuilder 'cur' to keep track of the
              count and say for 'n'
            - Create a variable 'count' to keep track of the frequency
              of the current character
            - Iterate through the indices of 'prev', denoted as 'i'
                - Increment 'count'
                - If 'i' is at the last index OR the character at 'i + 1' does
                  not equal to the current character at 'i'
                    - Append 'count' to 'cur'
                    - Append the current character to 'cur'
                    - Reset 'count' to 0
            - Return a string representation of 'cur'

What is the Time and Space Complexity?
    - Time Complexity = O(n * k), where n is the input value and k is
      the average length of each string
        - O(n * k), there are up to 'n' recursive calls, and we iterate
          through 'k' indices each
    - Space Complexity = O(n) + O(k) = O(n + k), where n is the input value and k is
        the average length of each string
            - O(n), recursive call stack memory
            - O(k), the generated strings in each recursive call
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        StringBuilder cur = new StringBuilder();
        String prev = countAndSay(n - 1);
        int count = 0;

        for (int i = 0; i < prev.length(); i++) {
            count++;

            if (i == prev.length() - 1 || prev.charAt(i) != prev.charAt(i + 1)) {
                cur.append(count).append(prev.charAt(i));
                count = 0;
            }
        }

        return cur.toString();
    }
}
