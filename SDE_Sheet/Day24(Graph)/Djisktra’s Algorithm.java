Given a source vertex s from a set of vertices V in a weighted graph where all its edge weights w(u,v) are non-negative,
find the shortest path weights d(s,v) from source s for all vertices v present in the graph.
//Prepfortech.in
  
For example,

Vertex	Minimum Cost	Route
A —> B	4	A —> E —> B
A —> C	6	A —> E —> B —> C
A —> D	5	A —> E —> D
A —> E	3	A —> E

 
We know that the Breadth–first search (BFS) can be used to find the shortest path in an unweighted graph or even in a weighted graph having the same cost of all its edges. But if edges in the graph are weighted with different costs, then BFS generalizes to uniform-cost search. Instead of expanding nodes to their depth from the root, uniform-cost search expands the nodes in order of their cost from the root. A variant of this algorithm is known as Dijkstra’s algorithm.

 
Dijkstra’s Algorithm is an algorithm for finding the shortest paths between nodes in a graph. For a given source node in the graph, the algorithm finds the shortest path between that node and every other node. It can also be used for finding the shortest paths from a single node to a single destination node by stopping the algorithm once the fastest route to the destination node has been determined.

Dijkstra’s Algorithm is based on the principle of relaxation, in which more accurate values gradually replace an approximation to the correct distance until the shortest distance is reached. The approximate distance to each vertex is always an overestimate of the true distance and is replaced by the minimum of its old value with the length of a newly found path. It uses a priority queue to greedily select the closest vertex that has not yet been processed and performs this relaxation process on all of its outgoing edges.

 
Following is pseudocode for Dijkstra’s Algorithm as per Wikipedia.function Dijkstra(Graph, source)

    dist[source] = 0    // Initialization
    create vertex set Q

    for each vertex v in Graph
    {
        if v != source
        {
            dist[v] = INFINITY        // Unknown distance from source to v
            prev[v] = UNDEFINED       // Predecessor of v
        }
        Q.add_with_priority(v, dist[v])
    }
    while Q is not empty
    {
        u = Q.extract_min()           // Remove minimum
        for each neighbor v of u that is still in Q
        {
            alt = dist[u] + length(u, v)
            if alt < dist[v]
            {
                dist[v] = alt
                prev[v] = u
                Q.decrease_priority(v, alt)
            }
        }
    }
    return dist[], prev[]

For instance, consider the following graph. We will start with vertex A, So vertex A has a distance 0, and the remaining vertices have an undefined (infinite) distance from the source. Let S be the set of vertices whose shortest path distances from the source are already calculated.


Initially, S contains the source vertex. S = {A}.

We start from source vertex A and start relaxing A’s neighbors. Since vertex B can be reached from a direct edge from vertex A, update its distance to 10 (weight of edge A–B). Similarly, we can reach vertex E through a direct edge from A, so we update its distance from INFINITY to 3.

After processing all outgoing edges of A, we next consider a vertex having minimum distance. B has a distance of 10, E has distance 3, and all remaining vertices have distance INFINITY. So, we choose E and push it into set S. Now our set becomes S = {A, E}. Next, we relax with E's neighbors. E has 2 neighbors B and C. We have already found one route to vertex B through vertex A having cost 10. But if we visit a vertex B through vertex E, we are getting an even cheaper route, i.e., (cost of edge A–E + cost of edge E–B) = 3 + 1 = 4 < 10 (cost of edge A–B).


We repeat the process till we have processed all the vertices, i.e., Set S becomes full.






The algorithm can be implemented as follows in C++, Java, and Python:

C++JavaPython
import java.util.*;
 
// A class to store a graph edge
class Edge
{
    int source, dest, weight;
 
    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}
 
// A class to store a heap node
class Node {
    int vertex, weight;
 
    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
 
// A class to represent a graph object
class Graph
{
    // A list of lists to represent an adjacency list
    List<List<Edge>> adjList = null;
 
    // Constructor
    Graph(List<Edge> edges, int N)
    {
        adjList = new ArrayList<>();
 
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // add edges to the undirected graph
        for (Edge edge: edges) {
            adjList.get(edge.source).add(edge);
        }
    }
}
 
class Main
{
    private static void getRoute(int[] prev, int i, List<Integer> route)
    {
        if (i >= 0) {
            getRoute(prev, prev[i], route);
            route.add(i);
        }
    }
 
    // Run Dijkstra’s algorithm on a given graph
    public static void shortestPath(Graph graph, int source, int N)
    {
        // create a min-heap and push source node having distance 0
        PriorityQueue<Node> minHeap;
        minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.add(new Node(source, 0));
 
        // set initial distance from the source to `v` as INFINITY
        List<Integer> dist = new ArrayList<>(Collections.nCopies(N,Integer.MAX_VALUE));
 
        // distance from the source to itself is zero
        dist.set(source, 0);
 
        // boolean array to track vertices for which minimum
        // cost is already found
        boolean[] done = new boolean[N];
        done[source] = true;
 
        // stores predecessor of a vertex (to a print path)
        int[] prev = new int[N];
        prev[source] = -1;
 
        List<Integer> route = new ArrayList<>();
 
        // run till min-heap is empty
        while (!minHeap.isEmpty())
        {
            // Remove and return the best vertex
            Node node = minHeap.poll();
 
            // get the vertex number
            int u = node.vertex;
 
            // do for each neighbor `v` of `u`
            for (Edge edge: graph.adjList.get(u))
            {
                int v = edge.dest;
                int weight = edge.weight;
 
                // Relaxation step
                if (!done[v] && (dist.get(u) + weight) < dist.get(v))
                {
                    dist.set(v, dist.get(u) + weight);
                    prev[v] = u;
                    minHeap.add(new Node(v, dist.get(v)));
                }
            }
 
            // mark vertex `u` as done so it will not get picked up again
            done[u] = true;
        }
 
        for (int i = 1; i < N; ++i)
        {
            if (i != source && dist.get(i) != Integer.MAX_VALUE) {
                getRoute(prev, i, route);
                System.out.printf("Path (%d —> %d): Minimum cost = %d, Route = %s\n",
                                source, i, dist.get(i), route);
                route.clear();
            }
        }
    }
 
    public static void main(String[] args)
    {
        // initialize edges as per the above diagram
        // `(u, v, w)` triplet represent undirected edge from
        // vertex `u` to vertex `v` having weight `w`
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 10), new Edge(0, 4, 3),
                new Edge(1, 2, 2), new Edge(1, 4, 4),
                new Edge(2, 3, 9), new Edge(3, 2, 7),
                new Edge(4, 1, 1), new Edge(4, 2, 8),
                new Edge(4, 3, 2)
        );
 
        // total number of nodes in the graph
        final int N = 5;
 
        // construct graph
        Graph graph = new Graph(edges, N);
 
        int source = 0;
        shortestPath(graph, source, N);
    }
}
 

Dijkstra’s algorithm runs inO(E.log(V)) time like Prim’s algorithm. Here, E is the total number of edges, and V is the graph’s number of vertices.
