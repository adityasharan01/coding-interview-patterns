Given a list of strings shows, a list of integers durations, and an integer k, where shows[i] and durations[i] represent the name and duration watched by the ith person, return the total duration watched of the k most watched shows.

Constraints

0 ≤ k ≤ n ≤ 100,000 where n is the length of shows and durations
Example 1
Input
shows = ["Top Gun", "Aviator", "Top Gun", "Roma", "Logan"]
durations = [5, 3, 5, 13, 4]
k = 2
Output
23
Explanation
The top 2 most watched movies are "Roma" and "Top Gun" for total durations of 13 and 10 = 5+ 5.
  
  import java.util.*;

class Solution {
    public int solve(String[] shows, int[] durations, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < shows.length; ++i) {
            map.put(shows[i], map.getOrDefault(shows[i], 0) + durations[i]);
        }

        List<Integer> list = new ArrayList<>();
        for (String s : map.keySet()) {
            list.add(map.get(s));
        }
        Collections.sort(list, Collections.reverseOrder());

        int ans = 0;
        for (int i = 0; i < k; ++i) {
            ans += list.get(i);
        }
        return ans;
    }
}
