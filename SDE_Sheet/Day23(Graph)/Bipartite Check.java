Given a graph, determine if it is bipartite using DFS. A bipartite graph (or bigraph) is a graph whose vertices can be divided into two disjoint sets U and V such that every edge connects a vertex in U to one in V.

The following is a bipartite graph as we can divide it into two sets, U and V, with every edge having one endpoint in set U and the other in set V.
  It is possible to test whether a graph is bipartite or not using a Depth–first search (DFS) algorithm. There are two ways to check for bipartite graphs –

A graph is bipartite if and only if it is 2–colorable.
A graph is bipartite if and only if it does not contain an odd cycle.
In the previous post, we have checked if the graph contains an odd cycle or not using BFS. Now using DFS, we will check if the graph is 2–colorable or not.

The main idea is to assign each vertex a color that differs from its parent’s color in the depth–first search tree. If there exists an edge connecting the current vertex to a previously colored vertex with the same color, then we can say that the graph is not bipartite.

This approach is demonstrated below in Java:
import java.util.*;
 
// A class to store a graph edge
class Edge
{
    int source, dest;
 
    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
}
 
// A class to represent a graph object
class Graph
{
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;
 
    // Constructor
    Graph(List<Edge> edges, int N)
    {
        adjList = new ArrayList<>();
 
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // add edges to the undirected graph
        for (Edge edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
 
class Main
{
    // Perform DFS on the graph starting from vertex `v`
    public static boolean DFS(Graph graph, int v, boolean[] discovered,
                            boolean[] color)
    {
        // do for every edge `v —> u`
        for (int u: graph.adjList.get(v))
        {
            // if vertex `u` is explored for the first time
            if (discovered[u] == false)
            {
                // mark the current node as discovered
                discovered[u] = true;
                // current node has the opposite color of that its parent
                color[u] = !color[v];
 
                // if DFS on any subtree rooted at `v` returns false
                if (DFS(graph, u, discovered, color) == false)
                    return false;
            }
            // if the vertex has already been discovered and
            // the color of vertex `u` and `v` are the same, then
            // the graph is not bipartite
            else if (color[v] == color[u]) {
                return false;
            }
        }
 
        return true;
    }
 
    public static void main(String[] args) {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(2, 3), new Edge(2, 8),
                new Edge(3, 4), new Edge(4, 6), new Edge(5, 7),
                new Edge(5, 9), new Edge(8, 9), new Edge(2, 4)
                // if we remove `2 —> 4` edge, the graph becomes bipartite
        );
 
        // total number of nodes in the graph
        final int N = 10;
 
        // build a graph from the given edges
        Graph graph = new Graph(edges, N);
 
        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[N];
 
        // keep track of the color assigned (0 or 1) to each vertex in DFS
        boolean[] color = new boolean[N];
 
        // mark the source vertex as discovered and
        // set its color to 0
        discovered[0] = true;
        color[0] = false;
 
        // start DFS traversal from any node as the graph
        // is connected and undirected
        if (DFS(graph, 1, discovered, color)) {
            System.out.println("The graph is bipartite");
        }
        else {
            System.out.println("The graph is not bipartite");
        }
    }
}
in the graph, respectively. Please note that O(E) may vary between O(1) and O(V2), depending on how dense the graph is.
