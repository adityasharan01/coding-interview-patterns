
Easy

You are given a two-dimensional list of strings contacts. Each element contacts[i] represents the list of emails for contact i. Contact i is considered a duplicate if there's a j < i such that contact j shares a common email with i. Return the number of unique people in contacts.

Constraints

0 ≤ n ≤ 100,000 where n is the total number of strings in contacts
Example 1
Input
contacts = [
    ["elon@tesla.com", "elon@paypal.com"],
    ["elon@tesla.com", "elon@spacex.com"],
    ["tim@apple.com"]
]
Output
2
Explanation
Contact 0 and 1 are the same person since they share a common email "elon@tesla.com". Then, contact 2 is another person.

Example 2
Input
contacts = [
    ["bill@microsoft.com"],
    ["jack@twitter.com"],
    ["jeff@amazon.com"]
]
Output
3
Explanation
All 3 contacts represent 3 unique people.

Example 3
Input
contacts = [
    ["lawrence@gmail.com"],
    ["lawrence@gmail.com", "larry@gmail.com"],
    ["larry@gmail.com"]
]
Output
1
Explanation
Only contact i = 0 is considered unique. The other two contacts are duplicates.
  
  import java.util.*;

class Solution {
    public int solve(String[][] contacts) {
        HashSet<String> hs=new HashSet<>();
        int result=0;
        for(int i=0;i<contacts.length;i++){
            int flag=1;
            for(int j=0;j<contacts[i].length;j++){
                if(hs.contains(contacts[i][j]))
                {
                    flag=0;
                }
                hs.add(contacts[i][j]);
            }
            result+=flag;
        }
        return result;

        }
    }
