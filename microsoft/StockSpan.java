// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class gfg
    {
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
            while(t-- > 0)
            {
                int n =sc.nextInt();
                int a[] = new int[n];
                
                int i = 0;
                for(i = 0; i < n; i++)
                  a[i] = sc.nextInt();
                  
                int[] s = new Solution().calculateSpan(a, n);
                
                for(i = 0; i < n; i++)
                {
                    System.out.print(s[i] + " ");
                }
                
                System.out.println();
            }
        }
        
        
        
    }// } Driver Code Ends
    
    
    
    
    class Solution
    {
        //Function to calculate the span of stockâ€™s price for all n days.
        public static int[] calculateSpan(int price[], int n)
        {
            Stack<Integer> stack = new Stack<>();
            
            int span[] = new int[n];
            for(int d = 0; d < n; d++) {
                
                int day = -1;
                
                while(!stack.isEmpty() && price[stack.peek()] <= price[d]) {
                    stack.pop();
                }
                
                if(!stack.isEmpty()) {
                    day = stack.peek();
                }
                stack.push(d);
                
                span[d] = d-day;
            }
            
            return span;
        }
        
    }