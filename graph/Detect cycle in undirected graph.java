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