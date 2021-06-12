Given a source vertex s from a set of vertices V in a weighted graph where its edge weights w(u, v) can be negative, 
find the shortest path weights d(s, v) from source s for all vertices v present in the graph. 
  If the graph contains a negative-weight cycle, report it.
  //Prepfortech and GFG
  
import java.util.*; 
import java.lang.*; 
import java.io.*; 

class Graph { 
	
	class Edge { 
		int src, dest, weight; 
		Edge() 
		{ 
			src = dest = weight = 0; 
		} 
	}; 

	int V, E; 
	Edge edge[]; 

	Graph(int v, int e) 
	{ 
		V = v; 
		E = e; 
		edge = new Edge[e]; 
		for (int i = 0; i < e; ++i) 
			edge[i] = new Edge(); 
	} 

	void BellmanFord(Graph graph, int src) 
	{ 
		int V = graph.V, E = graph.E; 
		int dist[] = new int[V]; 

	
		for (int i = 0; i < V; ++i) 
			dist[i] = Integer.MAX_VALUE; 
		dist[src] = 0; 

		for (int i = 1; i < V; ++i) { 
			for (int j = 0; j < E; ++j) { 
				int u = graph.edge[j].src; 
				int v = graph.edge[j].dest; 
				int weight = graph.edge[j].weight; 
				if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) 
					dist[v] = dist[u] + weight; 
			} 
		} 

		for (int j = 0; j < E; ++j) { 
			int u = graph.edge[j].src; 
			int v = graph.edge[j].dest; 
			int weight = graph.edge[j].weight; 
			if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) { 
				System.out.println("Graph contains negative weight cycle"); 
				return; 
			} 
		} 
		printArr(dist, V); 
	} 

	void printArr(int dist[], int V) 
	{ 
		System.out.println("Vertex Distance from Source"); 
		for (int i = 0; i < V; ++i) 
			System.out.println(i + "\t\t" + dist[i]); 
	} 

	public static void main(String[] args) 
	{ 
		int V = 4;
		int E = 5; 

		Graph graph = new Graph(V, E); 

		// add edge 0-1 (or A-B) 
    	graph.edge[0].src = 0; 
    	graph.edge[0].dest = 1; 
    	graph.edge[0].weight = 1; 
    
    	// add edge 0-2 (or A-C) 
    	graph.edge[1].src = 0; 
    	graph.edge[1].dest = 2; 
    	graph.edge[1].weight = 4; 
    
    	// add edge 1-2 (or B-C) 
    	graph.edge[2].src = 1; 
    	graph.edge[2].dest = 2; 
    	graph.edge[2].weight = -3; 
    
    	// add edge 1-3 (or B-D) 
    	graph.edge[3].src = 1; 
    	graph.edge[3].dest = 3; 
    	graph.edge[3].weight = 2; 
    
    	// add edge 2-3 (or C-D) 
    	graph.edge[4].src = 2; 
    	graph.edge[4].dest = 3; 
    	graph.edge[4].weight = 3; 

		graph.BellmanFord(graph, 0); 
	} 
} 
