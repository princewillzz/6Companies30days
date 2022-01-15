// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    class GFG
    {
        public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
            while(t-- > 0)
            {
                int r = sc.nextInt();
                int c = sc.nextInt();
                
                int matrix[][] = new int[r][c];
                
                for(int i = 0; i < r; i++)
                {
                    for(int j = 0; j < c; j++)
                     matrix[i][j] = sc.nextInt();
                }
                Solution ob = new Solution();
                ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
                for (Integer val: ans) 
                    System.out.print(val+" "); 
                System.out.println();
            }
        }
    }// } Driver Code Ends
    
    
    class Solution
    {
        //Function to return a list of integers denoting spiral traversal of matrix.
        static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
        {
            ArrayList<Integer> ans = new ArrayList<>();
            
            boolean visited[][] = new boolean[r][c];
            
            char dir = 'R';
            int count = r*c;
            
            int x = 0, y = 0;
            
            while(count>0) {
                visited[x][y] = true;
                ans.add(matrix[x][y]);
                
                if(dir == 'R') {
                    y++;
                    if(y >= c || visited[x][y]) {
                        y--;
                        x++;
                        dir = 'D';
                    }
                } else if(dir == 'L') {
                    y--;
                    if(y < 0 || visited[x][y]) {
                        y++;
                        x--;
                        dir = 'U';
                    }
                } else if(dir == 'D') {
                    x++;
                    if(x >= r || visited[x][y]) {
                        x--;
                        y--;
                        dir = 'L';
                    }
                } else if(dir == 'U') {
                    x--;
                    if(x < 0 || visited[x][y]) {
                        x++;
                        y++;
                        dir = 'R';
                    }
                }
                count--;
            }
            
            return ans;
        }
    }
    