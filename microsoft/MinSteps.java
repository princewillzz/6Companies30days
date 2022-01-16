// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int D = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minSteps(D));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minSteps(int D){
        int sum = 0, steps = 0;
        
        while(sum < D) {
            sum+=steps;
            steps++;
        }
        
        while((sum-D)%2 != 0) {
            sum+=steps;
            steps++;
        }
        
        return steps-1;
    
    }
    
}