package graph;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Graph {
	
   public static void printDFSHelper(int adj_mat[][],int sv, boolean visited[]) {
	   System.out.println(sv);
	   visited[sv] = true;
	   int v = adj_mat.length;
	   for(int i =0; i<v; i++) {
		   if(adj_mat[sv][i] == 1 && visited[i] == false)
			   printDFSHelper(adj_mat, i, visited);
	   }
   }	
	
   public static void printDFS(int adj_mat[][]) {
	   int v = adj_mat.length;
	   boolean visited[] = new boolean[v];
	   for(int i =0; i<v; i++) {
		   if(visited[i] == false)
			   printDFSHelper(adj_mat, i, visited);
	   }
	   
   }
	
   
   

   public static void printBFSHelper(int adj_mat[][],int sv, boolean visited[]) {
	  Queue<Integer> q = new LinkedList<>();
	  q.add(sv);
	  visited[sv] = true;
	  int v = adj_mat.length;
	  while(!q.isEmpty()) {
		  int front = q.poll();
		  System.out.println(front);
		  for(int i =0; i <v; i++) {
			  if(adj_mat[front][i] == 1 && visited[i] == false) {
				  q.add(i);
				  visited[i] = true;
			  }
		  }
	  }
   }	
	
   
   public static void printBFS(int adj_mat[][]) {
	   int v = adj_mat.length;
	   boolean visited[] = new boolean[v];
	   for(int i =0; i<v; i++) {
		   if(visited[i] == false)
			   printBFSHelper(adj_mat, i, visited);
	   }
	   
   }
	
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   System.out.println("print no of vertex");
	   int v = sc.nextInt();
	   System.out.println("print no of edges");
	   int e = sc.nextInt();
	   int adj_mat[][] = new int[v][v];
	   for(int i =0; i <e; i++) {
		   int sv = sc.nextInt();
		   int ev = sc.nextInt();
		   adj_mat[sv][ev] = 1;
		   adj_mat[ev][sv] = 1;
	   }  
	   //DFS
	   System.out.println("print DFS");
	   printDFS(adj_mat);
	   
	   //BFS

	   System.out.println("print BFS");
	   printBFS(adj_mat);
	   
   }
}
