Topological Sorting using the DFS Based Algorithm.
  
  

import java.util.*; 

class Graph { 

	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{ 
		adj.get(u).add(v); 
	} 

    static void DFS(ArrayList<ArrayList<Integer>> adj, int u,Stack<Integer> st, boolean visited[]) 
    { 	
        visited[u]=true;
        
        for(int v:adj.get(u)){
            if(visited[v]==false)
                DFS(adj,v,st,visited);
        }
        st.push(new Integer(u));
    }
    
    
    static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int V) 
    { 
        boolean[] visited=new boolean[V]; 
    	for(int i = 0;i<V; i++) 
    		visited[i] = false;
    	Stack<Integer> st = new Stack<Integer>(); 
        
        for(int u=0;u<V;u++){
            if(visited[u]==false){
                DFS(adj,u,st,visited);
            }
        }
        
        while (st.empty() == false) 
            System.out.print(st.pop() + " "); 
       
    }

	public static void main(String[] args) 
	{  
		int V = 5; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
		
		for (int i = 0; i < V; i++) 
			adj.add(new ArrayList<Integer>()); 

			addEdge(adj,0, 1); 
            addEdge(adj,1, 3); 
            addEdge(adj,2, 3); 
            addEdge(adj,3, 4); 
            addEdge(adj,2, 4); 
		
		System.out.println("Following is a Topological Sort of"); 
        topologicalSort(adj,V);
	} 
} 
