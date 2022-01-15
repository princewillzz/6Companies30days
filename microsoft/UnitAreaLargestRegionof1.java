// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    class GFG
    {
        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while(T-->0)
            {
                String[] s = br.readLine().trim().split(" ");
                int n = Integer.parseInt(s[0]);
                int m = Integer.parseInt(s[1]);
                int[][] grid = new int[n][m];
                for(int i = 0; i < n; i++){
                    String[] S = br.readLine().trim().split(" ");
                    for(int j = 0; j < m; j++){
                        grid[i][j] = Integer.parseInt(S[j]);
                    }
                }
                Solution obj = new Solution();
                int ans = obj.findMaxArea(grid);
                System.out.println(ans);
            }
        }
    }// } Driver Code Ends
    
    
    class Solution
    {
        //Function to find unit area of the largest region of 1s.
        public int findMaxArea(int[][] grid)
        {
            int r = grid.length, c = grid[0].length;
            boolean visited[][] = new boolean[r][c];
            
            int max = 0;
            
            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    if(!visited[i][j]) {
                        max = Math.max(max, exp(grid, i, j, r, c, visited));
                    }
                }
            }
            
            return max;
        }
        
        int exp(int grid[][], int i, int j, int r, int c, boolean visited[][]) {
            
            if(i < 0 || j < 0) return 0;
            if (i >= r || j >= c) return 0;
                    
            if(visited[i][j] || grid[i][j] == 0) return 0;
            
            visited[i][j] = true;
            
            int max = 0;
            
            for(int x = i-1; x <= i+1; x++) {
                for(int y = j-1; y <= j+1; y++) {
                    
                    max += exp(grid, x, y, r, c, visited);
                    
                }
            }
            
            return max+1;
        }
    }