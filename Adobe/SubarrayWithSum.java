// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
    
            int t = sc.nextInt();
    
            for (int i = 0; i < t; i++) {
                int n = sc.nextInt();
                int s = sc.nextInt();
    
                int[] m = new int[n];
                for (int j = 0; j < n; j++) {
                    m[j] = sc.nextInt();
                }
                
                Solution obj = new Solution();
                ArrayList<Integer> res = obj.subarraySum(m, n, s);
                for(int ii = 0;ii<res.size();ii++)
                    System.out.print(res.get(ii) + " ");
                System.out.println();
            }
        }
    
    }// } Driver Code Ends
    
    
    class Solution
    {
        //Function to find a continuous sub-array which adds up to a given number.
        static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
        {
            ArrayList<Integer> ans = new ArrayList<Integer>();
            if(arr.length < 1) {
                ans.add(-1);
                return ans;
            }
            
            
            int start = 1, end = 1, sum = 0;
            
            for(int i = 0; i < n; i++) {
                sum += arr[i];
                while(sum > s) {
                    // System.out.println(start + " " + end + " " + i+ " = " + sum);
                    sum -= arr[start-1];
                    start++;
                    
                }
                if(sum == s) {
                    end = i+1;
                    break;
                }
            }
            // System.out.println(sum);
            if(sum != s) {
                ans.add(-1);
                return ans;
            }
            
            
            
            ans.add(start);
            ans.add(end);
            return ans;
        }
    }