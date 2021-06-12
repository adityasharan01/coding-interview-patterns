Kruskal’s Minimum Spanning Tree Algorithm

Kruskal’s algorithm is a greedy algorithm in Graph theory that takes a graph as input and
finds the subset of the edges of that graph which form a minimum spanning tree. 
A minimum spanning tree (of a graph) is a tree with weight less than or equal to 
the weight of every other spanning tree i.e. 
it has the minimum sum of weights among all the trees that can be formed from the graph.

Algorithm:

Sort all the edges in an ascending order
Pick the edge with the least weight and add it to the spanning tree. If adding the edge creates a cycle, then discard this edge.
Keep adding edges until all vertices are included
(illustration)

We need to keep checking if an edge creates a cycle or not. The most common way to do it using an algorithm called union find.
This algorithm divides the nodes into different groups and allows us to check if two nodes belong to the same group or not.
This helps decide whether the edge in question creates a cycle or not.
 
The time complexity of Kruskal’s Algorithm is O(Elog(E)).
  
import java.util.*;

class Graph
{
    class Edge implements Comparable < Edge >
    {
        int src, dest, weight;

        public int compareTo (Edge compareEdge)
        {
            return this.weight - compareEdge.weight;
        }
    };


    class subset
    {
        int represent, rank;
    };

    int nodes, edges;
    Edge edge[];


    Graph (int v, int e)
    {
        nodes = v;
        edges = e;
        
        edge = new Edge[edges];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge ();
    }

    int find (subset set[], int i)
    {
        if (set[i].represent != i)
            set[i].represent = find (set, set[i].represent);
        return set[i].represent;
    }

    void Union (subset set[], int u, int v)
    {
        int u_find = find (set, u);
        int v_find = find (set, v);

        if (set[u_find].rank < set[v_find].rank)
            set[u_find].represent = v_find;
        else if (set[u_find].rank > set[v_find].rank)
            set[v_find].represent = u_find;
        else
        {
            set[v_find].represent = u_find;
            set[u_find].rank++;
        }
    }


    void KruskalMST ()
    {
        Edge result[] = new Edge[nodes];
        int e = 0;
        int i = 0;
        for (i = 0; i < nodes; ++i)
        result[i] = new Edge ();


        Arrays.sort (edge);
        subset set[] = new subset[nodes];
        for (i = 0; i < nodes; ++i)
        set[i] = new subset ();

        for (int v = 0; v < nodes; ++v)
        {
            set[v].represent = v;
            set[v].rank = 0;
        }
        i = 0;
    
        while (e < nodes - 1)
        {
            Edge n_edge = new Edge ();
            n_edge = edge[i++];
            int x = find (set, n_edge.src);
            int y = find (set, n_edge.dest);
            if (x != y)
            {
                result[e++] = n_edge;
                Union (set, x, y);
            }
        }
        
        for (i = 0; i < e; ++i)
            System.out.println (result[i].src + " - " + result[i].dest + ": " + result[i].weight);
    }

    public static void main (String[]args)
    {
        int nodes = 6;
        int edges = 9;
        Graph G = new Graph (nodes, edges);

        G.edge[0].src = 0;
        G.edge[0].dest = 1;
        G.edge[0].weight = 7;

        G.edge[1].src = 0;
        G.edge[1].dest = 5;
        G.edge[1].weight = 1;

        G.edge[2].src = 1;
        G.edge[2].dest = 2;
        G.edge[2].weight = 9;

        G.edge[3].src = 1;
        G.edge[3].dest = 5;
        G.edge[3].weight = 6;

        G.edge[4].src = 2;
        G.edge[4].dest = 5;
        G.edge[4].weight = 4;

        G.edge[5].src = 2;
        G.edge[5].dest = 4;
        G.edge[5].weight = 2;

        G.edge[6].src = 2;
        G.edge[6].dest = 3;
        G.edge[6].weight = 5;

        G.edge[7].src = 3;
        G.edge[7].dest = 4;
        G.edge[7].weight = 1;
        
        G.edge[8].src = 4;
        G.edge[8].dest = 5;
        G.edge[8].weight = 3;
        
    G.KruskalMST ();
  }
}
