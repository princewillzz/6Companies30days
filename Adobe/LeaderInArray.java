// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class Array {
        
        public static void main (String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
            
            while(t-->0){
                
                //input size of array
                int n = Integer.parseInt(br.readLine().trim());
                int arr[] = new int[n];
                String inputLine[] = br.readLine().trim().split(" ");
                
                //inserting elements in the array
                for(int i=0; i<n; i++){
                    arr[i] = Integer.parseInt(inputLine[i]);
                }
                
                Solution obj = new Solution();
                
                StringBuffer str = new StringBuffer();
                ArrayList<Integer> res = new ArrayList<Integer>();
              
                //calling leaders() function
                res = obj.leaders(arr, n);
                
                //appending result to a String
                for(int i=0; i<res.size(); i++){
                    str.append(res.get(i)+" ");
                }
                
                //printing the String
                System.out.println(str);
            }
            
        }
    }
    // } Driver Code Ends
    
    
    class Solution{
        //Function to find the leaders in the array.
        static ArrayList<Integer> leaders(int ar[], int n){
            Stack<Integer> stack = new Stack<>();
            
            ArrayList<Integer> ans = new ArrayList<>();
            
            for(int i = n-1; i >= 0; i--) {
                
                if(stack.isEmpty()) {
                    ans.add(ar[i]);
                    stack.push(ar[i]);
                } else {
                    
                    while(!stack.isEmpty() && ar[i] >= stack.peek()) {
                        stack.pop();
                    }
                    
                    if(stack.isEmpty()) ans.add(ar[i]);
                    
                    stack.push(ar[i]);
                    
                }
                 
            }
            
            Collections.reverse(ans);
            return ans;
        }
    }
    