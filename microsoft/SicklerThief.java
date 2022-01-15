// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    
    class GFG
     {
        public static void main (String[] args)
         {
          
          //taking input using Scanner class
          Scanner sc = new Scanner(System.in);
          
          //taking count of testcases
          int t = sc.nextInt();
          while(t-- > 0){
              
              //taking count of houses
              int n = sc.nextInt();
              int arr[] = new int[n];
              
              //inserting money present in 
              //each house in the array
              for(int i = 0; i<n; ++i)
                   arr[i] = sc.nextInt();
                
                //calling method FindMaxSum() of class solve
                System.out.println(new Solution().FindMaxSum(arr, n));
         }
       }
    }// } Driver Code Ends
    
    
    class Solution
    {
        //Function to find the maximum money the thief can get.
        public int FindMaxSum(int arr[], int n)
        {
            return helper(arr, n, 0, new Integer[n+1]);
        }
        
        int helper(int ar[], int n, int i, Integer memo[]) {
            
            if(i >= n) return 0;
            
            if(memo[i] != null) return memo[i];
            
            int sel = helper(ar, n, i+2, memo) + ar[i];
            int nsel = helper(ar, n, i+1, memo);
            
            memo[i] = Math.max(sel, nsel);
            return Math.max(sel, nsel);
        }
    }