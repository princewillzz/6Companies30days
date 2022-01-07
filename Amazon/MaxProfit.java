
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
            System.out.println(ob.maximumProfit(A, K));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {


    int maximumProfit(int prices[], int k) {

        int profits[][] = new int[k+1][prices.length+1];

        for (int t = 1; t <= k; t++) {
            int didBuyAtMaximumProfit = Integer.MIN_VALUE;
            for (int d = 1; d <= profits.length; d++) {
                
                didBuyAtMaximumProfit = Math.max(didBuyAtMaximumProfit, profits[t-1][d] - prices[d-1]);

                int doSell = didBuyAtMaximumProfit + prices[d-1];
                int dontSell = profits[t][d-1];

                profits[t][d] = Math.max(doSell, dontSell);

            }
        }

        return profits[k][prices.length];

    }


}
