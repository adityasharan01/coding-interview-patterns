There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
  
  BFS Solution: (Topological sorting)

The basic idea is to use Topological algorithm: put NODE with 0 indgree into the queue, then make indegree of NODE's successor dereasing 1. Keep the above steps with BFS.

Finally, if each node' indgree equals 0, then it is validated DAG (Directed Acyclic Graph), which means the course schedule can be finished.

public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses == 0 || prerequisites.length == 0) return true;

    // Convert graph presentation from edges to indegree of adjacent list.
    int indegree[] = new int[numCourses];
    for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
        indegree[prerequisites[i][0]]++;    

    Queue<Integer> queue = new LinkedList<Integer>();
    for (int i = 0; i < numCourses; i++) 
        if (indegree[i] == 0)
            queue.add(i);

    // How many courses don't need prerequisites.
    int canFinishCount = queue.size();  
    while (!queue.isEmpty()) {
        int prerequisite = queue.remove(); // Already finished this prerequisite course.
        for (int i = 0; i < prerequisites.length; i++)  {
            if (prerequisites[i][1] == prerequisite) { 
                indegree[prerequisites[i][0]]--;
                if (indegree[prerequisites[i][0]] == 0) {
                    canFinishCount++;
                    queue.add(prerequisites[i][0]);
                }
            }
        }
    }

    return (canFinishCount == numCourses);    
}
DFS Solution:

The basic idea is using DFS to check if the current node was already included in the traveling path. In this case, we need to convert graph presentation from edge list to adjacency list first, and then check if there's cycle existing in any subset. Because tree is a connected graph, we can start from any node.

The graph is possibly not connected, so need to check every node.

To do memorization and pruning, a HashMap is used to save the previous results for the specific node.

HashMap<Integer, Boolean>memo = new HashMap<Integer, Boolean>();//Memorization HashMap for DFS pruning 
public boolean canFinish(int n, int[][] edges) {		 
    if (edges.length != 0) { 
        HashMap<Integer, HashSet<Integer>> neighbors = new HashMap<Integer, HashSet<Integer>>(); // Neighbors of each node
        HashSet<Integer>curPath = new HashSet<Integer>(); // Nodes on the current path
        for (int i = 0; i < edges.length; i++) {// Convert graph presentation from edge list to adjacency list 
            if (!neighbors.containsKey(edges[i][1])) 
                neighbors.put(edges[i][1], new HashSet<Integer>());            
            neighbors.get(edges[i][1]).add(edges[i][0]);
        }
        
        for (int a[] : edges) // The graph is possibly not connected, so need to check every node.
	        if (hasCycle(neighbors, a[0], -1, curPath))// Use DFS method to check if there's cycle in any curPath
	            return false;
    } 
    return true;
}     

boolean hasCycle(HashMap<Integer, HashSet<Integer>> neighbors, int kid, int parent, HashSet<Integer>curPath) {
	if (memo.containsKey(kid)) return memo.get(kid);
    if (curPath.contains(kid)) return true;// The current node is already in the set of the current path	    
    if (!neighbors.containsKey(kid)) return false;	   
    
    curPath.add(kid);
    for (Integer neighbor : neighbors.get(kid)) {
    	boolean hasCycle = hasCycle(neighbors, neighbor, kid, curPath);// DFS
    	memo.put(kid, hasCycle);	        	
        if (hasCycle) return true;
    }
    curPath.remove(kid);	    
    return false;
}
