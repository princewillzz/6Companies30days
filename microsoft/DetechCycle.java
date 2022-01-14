// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    void makeGraph(ArrayList<HashSet<Integer>> graph, int[][] pre) {
        for(int i =0 ; i < pre.length; i++) {
            graph.get(pre[i][1]).add(pre[i][0]);
        }
    }
    
    public boolean isPossible(int N, int[][] prerequisites)
    {
        ArrayList<HashSet<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < N; i++) graph.add(new HashSet<>());
        
        makeGraph(graph, prerequisites);
        boolean visited[] = new boolean[N];
        boolean onPath[] = new boolean[N];
        
        for(int i = 0; i < N; i++) {
            if(!visited[i] && dfsCycle(i, graph, visited, onPath)) {
                return false;
            }
        }
        
        return true;
    }
    
    boolean dfsCycle(int node, ArrayList<HashSet<Integer>> graph, boolean visited[], boolean onPath[]) {
        if(visited[node]) return false;
        
        visited[node] = true;
        onPath[node] = true;
        
        for(int neighbour: graph.get(node)) {
            if(onPath[neighbour] || dfsCycle(neighbour, graph, visited, onPath)) {
                return true;
            }
        }
        
        onPath[node] = false;
        return false;
    }
    
}