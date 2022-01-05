package Goldman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int CountWays(String str)
    {
        // code here
        long mod = (long)1e9+7;
        char s[] = str.toCharArray();
        if(s[0] == '0') return 0;
        int n = s.length;
        
        long dp[] = new long[n+1];
        for(int i = 1; i < n; i++) {
            if(s[i] == '0' && s[i-1] > '2') {
                return 0;
            }
        }
        
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            if(s[i-1] > '0') {
                dp[i] = dp[i-1];
            }
            if(s[i-2] == '1' || (s[i-2] == '2' && s[i-1] < '7')) {
                dp[i] += dp[i-2];
            }
            dp[i] %= mod;
            
        }
        
        return (int)dp[n];
    }
}