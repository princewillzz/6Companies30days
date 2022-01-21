// { Driver Code Starts
    import java.util.PriorityQueue;
import java.util.Scanner;
    
    public class DriverClass
    {
        public static void main(String args[]) 
        {
           Scanner sc = new Scanner(System.in);
           int t = sc.nextInt();
           int range[];
           while(t-- >0)
           {
             int n = sc.nextInt();
             int k = sc.nextInt();
             int arr[][] = new int[k][n];
               for(int i = 0; i < k; i++)
               {
                for(int j = 0; j < n; j++)
                       arr[i][j] = sc.nextInt();
               }
               range = new Solution().findSmallestRange(arr, n, k);
               System.out.println(range[0] + " " + range[1]);
           }
        }
    }
    // } Driver Code Ends
    
    
    class Solution
    {
        static int[] findSmallestRange(int[][] arr,int n,int k)
        {
            
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] res = {0,1000000};
        int max = Integer.MIN_VALUE;
        
        for(int i=0 ;i<k;i++){
            int val = arr[i][0];
            int[] temp = {val , 0 , i};
            max = Math.max(max , val);
            pq.add(temp);
        }
        
        while(true){
            int[] min = pq.poll();
            if(res[1] - res[0] > max - min[0]){
                res[1] = max;
                res[0] = min[0];
            }
            min[1]++;
            if(min[1] == n)
                break;
            if(arr[min[2]][min[1]] > max){
                max = arr[min[2]][min[1]];
            }
            int temp[]  = {arr[min[2]][min[1]] , min[1] , min[2]};
            pq.add(temp);
        }
        
        return res;
        }
        
        
    }