// { Driver Code Starts
//Initial Template for Java
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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int x = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    static int numOfWays(int n, int x)
    {
        int dp[] = new int[n+1];
        Arrays.fill(dp, 0);
        
        dp[0] = dp[1] = 1;
        
        int maxLimit = (int) Math.pow(n, 1.0/x);
        
        for( int i = 2; i <= maxLimit; i++) {
            int curr = (int) Math.pow(i, x);
            
            for(int j = n; j >= curr; j--){
                dp[j] += dp[j-curr];
            }
        }
        
        return dp[n];
    }
}