Validate Delivery Orders
You are given a list of strings orders. Each element in orders starts with either "P" meaning pickup or "D" meaning delivery followed by the order id. For example, "P12" means pick up order 12.

Return whether orders is valid given the following rules:

A delivery cannot happen for an order before pickup
Every pickup must be delivered
An order that's already been picked up and delivered cannot be picked up or delivered again
Constraints

0 ≤ n ≤ 100,000 where n is the length of orders
Example 1
Input
orders = ["P1", "P2", "D2", "D1"]
Output
true
Explanation
We first pick up orders 1 and 2 then we drop 2 and 1.
  
  import java.util.*;

class Solution {
    public boolean solve(String[] orders) {
        HashMap<String,String> hm=new HashMap<>();
        for(int i=0;i<orders.length;i++){
            String t1=orders[i].substring(0,1);
            String t2=orders[i].substring(1);
            if(hm.containsKey(t2)){
                if(hm.get(t2).equals("D")&& t1.equals("P")){
                    return false;
                }
                if(hm.get(t2).equals("P")&& t1.equals("P")){
                    return false;
                }
                if(hm.get(t2).equals("D")&& t1.equals("D")){
                    return false;
                }
                hm.put(t2,"D");
            }
            else{
                if(t1.equals("D")){
                    return false;
                }
                hm.put(t2,t1);
            }
        }
        for(String key:hm.keySet())
        {
            if(hm.get(key).equals("D"))
                continue;
            else{
            return false;
            }
        }
        return true;

    }
}
