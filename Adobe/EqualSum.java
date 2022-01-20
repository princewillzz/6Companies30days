// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int ele: arr) sum += ele;
        
        return sum % 2 == 0 && solve1(sum/2, 0, arr, new Boolean[sum+1][N+1])? 1: 0;
        // return solve(0, 0, 0, arr, new HashMap<String, Boolean>())? 1: 0;
    }
    
    static boolean solve1(int t, int i, int ar[], Boolean memo[][]) {
        
        
        if(t < 0) return false;
        if(i >= ar.length) {
            if(t == 0) return true;
            return false;
        }
        
        if(memo[t][i] != null) return memo[t][i];
        
        boolean ans = solve1(t-ar[i],i+1, ar, memo) || solve1(t, i+1, ar, memo);
        
        memo[t][i] = ans;
        
        return ans;
        
    }
    
    static boolean solve(int t1, int t2, int i, int ar[], HashMap<String, Boolean> memo) {
        
        if(i >= ar.length) {
            if(t1 == t2 ) return true;    
            else return false;
        }
        
        if(memo.containsKey(t1+""+t2+""+i)) return memo.get(t1+""+t2+""+i);
        
        boolean ans = solve(t1+ar[i], t2, i+1, ar, memo) || solve(t1, t2+ar[i], i+1, ar, memo);
        
        memo.put(t1+""+t2+""+i, ans);
        
        return ans;
        
    }
}