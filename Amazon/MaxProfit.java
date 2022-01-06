package Amazon;

// { Driver Code Starts
// Initial Template for Java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int K, int N, int A[]) {
        int profits[][] = new int[K+1][N+1];
        
        for(int t = 1; t <= K; t++) {
            int didBuyPrevMax = Integer.MIN_VALUE;
            for(int d = 1; d <= N; d++) {
                
                didBuyPrevMax = Math.max(didBuyPrevMax, profits[t-1][d] - A[d-1]);
                
                int dontSell = profits[t][d-1];
                int doSell = didBuyPrevMax + A[d-1];
                
                profits[t][d] = Math.max(dontSell, doSell);
            }
        }
        
        return profits[K][N];
    }
}
