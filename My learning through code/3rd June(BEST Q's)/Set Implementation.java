Set
Implement a set data structure with the following methods:

CustomSet() constructs a new instance of a set
add(int val) adds val to the set
exists(int val) returns whether val exists in the set
remove(int val) removes the val in the set
This should be implemented without using built-in set.

Constraints

n ≤ 100,000 where n is the number of calls to add, exists and remove
Example 1
Input
methods = ["constructor", "add", "exists", "remove", "exists"]
arguments = [[], [1], [1], [1], [1]]`
Output
[null, null, true, null, false]
Explanation
c = CustomSet()
c.add(1)
c.exists(1) == True
c.remove(1)
c.exists(1) == False


import java.util.*;

class CustomSet {
    ArrayList<Integer>[] myarr;
    int size;
    public CustomSet() {
        size = 300;
        myarr = new ArrayList[size];
    }
    public int key(int val) {
        return ((val % size));
    }
    public void add(int val) {
        if (!exists(val)) {
            myarr[key(val)].add(val);
        }
    }
    public boolean exists(int val) {
        int m = key(val);
        if (myarr[m] == null)
            myarr[m] = new ArrayList<Integer>();
        return myarr[m].contains(val);
    }

    public void remove(int val) {
        if (exists(val))
            myarr[key(val)].remove(Integer.valueOf(val));
    }
}
