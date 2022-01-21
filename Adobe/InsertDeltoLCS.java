// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class GFG {
        public static void main(String args[]) throws IOException {
            BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(read.readLine());
            while (t-- > 0) {
                String S[] = read.readLine().split(" ");
                
                int N = Integer.parseInt(S[0]);
                int M = Integer.parseInt(S[1]);
                
                int[] A = new int[N];
                int[] B = new int[M];
                
                String S1[] = read.readLine().split(" ");
                String S2[] = read.readLine().split(" ");
                
                for(int i=0; i<N; i++)
                    A[i] = Integer.parseInt(S1[i]);
                    
                for(int i=0; i<M; i++)
                    B[i] = Integer.parseInt(S2[i]);
    
                Solution ob = new Solution();
                System.out.println(ob.minInsAndDel(A,B,N,M));
            }
        }
    }// } Driver Code Ends
    
    
    //User function Template for Java
    
    class Solution {
        static int minInsAndDel(int[] A, int[] B, int N, int M) {
            int memo[][] = new int[N+ 1][M+ 1];
    
            for (int i = 0; i < memo.length; i++) {
                for (int j = 0; j < memo[i].length; j++) {
                    if (i == 0 || j == 0)
                        memo[i][j] = 0;
                    else {
                        if (A[i-1] == B[j-1])
                            memo[i][j] = 1 + memo[i - 1][j - 1];
                        else
                            memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                    }
                }
            }
            int lcs = memo[N][M];
            int deletion = N - lcs;
            int insertion = M - lcs;
            return insertion + deletion;
        }
    };