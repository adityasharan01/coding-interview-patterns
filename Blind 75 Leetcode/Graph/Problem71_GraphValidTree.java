Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
  
  import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
// A class to store a graph edge
class Edge
{
    int source, dest;
 
    public Edge(int source, int dest)
    {
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
    // Perform DFS on the graph and returns true if any back-edge
    // is found in the graph
    public static boolean DFS(Graph graph, int v, boolean[] discovered, int parent)
    {
        // mark the current node as discovered
        discovered[v] = true;
 
        // do for every edge `v —> w`
        for (int w: graph.adjList.get(v))
        {
            // if `w` is not discovered
            if (!discovered[w])
            {
                if (!DFS(graph, w, discovered, v)) {
                    return false;
                }
            }
 
            // if `w` is discovered, and `w` is not a parent
            else if (w != parent)
            {
                // we found a back-edge (cycle)
                return false;
            }
        }
 
        // no back-edges were found in the graph
        return true;
    }
 
    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(1, 2), new Edge(2, 3),
                new Edge(3, 4), new Edge(4, 5), new Edge(5, 0)
                // edge `5 —> 0` introduces a cycle in the graph
        );
 
        // total number of nodes in the graph
        final int N = 6;
 
        // construct graph
        Graph graph = new Graph(edges, N);
 
        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[N];
 
        // Perform DFS traversal from the first vertex
        boolean isTree = DFS(graph, 0, discovered, -1);
 
        for (int i = 0; isTree && i < N; i++)
        {
            // any undiscovered vertex means the graph is disconnected
            if (!discovered[i]) {
                isTree = false;
            }
        }
 
        if (isTree) {
            System.out.println("The graph is a tree");
        }
        else {
            System.out.println("The graph is not a tree");
        }
    }
}


