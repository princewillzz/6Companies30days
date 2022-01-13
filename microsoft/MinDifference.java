// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    int total = 0;
	    for(int ele: arr) total+=ele;
	    Integer memo[][] = new Integer[n+1][total+1];
	    return helper(0, arr, 0, memo);
	} 
	
	int helper(int total, int ar[], int index, Integer memo[][]) {
	    if(index >= ar.length) {
	        return Math.abs(total);
	    }
	    if(memo[index][Math.abs(total)] != null) return memo[index][Math.abs(total)];
	    int minDiff = Math.min(helper(total+ar[index], ar, index+1, memo), helper(total-ar[index], ar, index+1, memo));
	    
	    memo[index][Math.abs(total)] = minDiff;
	    
	    return minDiff;
	}
}
