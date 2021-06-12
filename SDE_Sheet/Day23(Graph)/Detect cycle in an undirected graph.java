Detect cycle in an undirected graph

Given an undirected graph, how to check if there is a cycle in the graph? 
Example, 

Input: n = 4, e = 4 
Output: Yes 
Explanation: 
0 1, 1 2, 2 3, 0 2 
Diagram: 
 



The diagram clearly shows a cycle 0 to 2 to 1 to 0
Input:n = 4, e = 3 
0 1, 1 2, 2 3 
Output:No 
Explanation: 
Diagram: 





The diagram clearly shows no cycle 
class DetectCycle
{
    
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(DFS(adj,i,visited,-1))
                return true;
            }
        }
       return false;
    }
    static boolean DFS(ArrayList<ArrayList<Integer>> adj,int src,boolean visited[],int parent){
        visited[src]=true;
        for(int v:adj.get(src)){
            if(!visited[v]){
                if(DFS(adj,v,visited,src))
                return true;
            }
            else if(v!=parent)
            return true;
        }
        return false;
    }
}
© 2021 GitHub, Inc.
