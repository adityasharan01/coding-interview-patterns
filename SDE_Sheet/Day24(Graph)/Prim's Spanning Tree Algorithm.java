Prim's algorithm to find minimum cost spanning tree (as Kruskal's algorithm) uses the greedy approach. Prim's algorithm shares a similarity with the shortest path first algorithms.

Prim's algorithm, in contrast with Kruskal's algorithm, treats the nodes as a single tree and keeps on adding new nodes to the spanning tree from the given graph.

To contrast with Kruskal's algorithm and to understand Prim's algorithm better, we shall use the same example −
import java.util.*; 
import java.lang.*; 
import java.io.*; 

class Gfg { 
	
    static final int V=4;
	public static int primMST(int graph[][]) 
    { 
    
    	int[] key=new int[V];int res=0; 
    	Arrays.fill(key,Integer.MAX_VALUE);
    	boolean[] mSet=new boolean[V]; key[0]=0;
    
    	for (int count = 0; count < V ; count++) 
    	{ 
    		int u = -1; 
    
    		for(int i=0;i<V;i++)
    		    if(!mSet[i]&&(u==-1||key[i]<key[u]))
    		        u=i;
    		mSet[u] = true; 
    		res+=key[u];
    
    		
    		for (int v = 0; v < V; v++) 
    
    			if (graph[u][v]!=0 && mSet[v] == false) 
    				key[v] = Math.min(key[v],graph[u][v]); 
    	} 
        return res;
    } 

	public static void main(String[] args) 
	{  
		int graph[][] = new int[][] { { 0, 5, 8, 0}, 
    						{ 5, 0, 10, 15 }, 
    						{ 8, 10, 0, 20 }, 
    						{ 0, 15, 20, 0 },};  

		System.out.print(primMST(graph)); 
	} 
} 
