// { Driver Code Starts
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
                String A = br.readLine().trim();
                Solution ob = new Solution();
                String ans = ob.FirstNonRepeating(A);
                System.out.println(ans);
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution
    {
        public String FirstNonRepeating(String s)
        {
            StringBuilder ans = new StringBuilder();
            
            int nonRepIndex = 0;
            int count[] = new int[256];
            
            for(int i = 0; i < s.length(); i++) {
                
                count[(int)s.charAt(i)]++;
                
                while(nonRepIndex <= i && count[(int)s.charAt(nonRepIndex)] > 1) {
                    nonRepIndex++;
                }
                
                if(nonRepIndex > i) {
                    ans.append('#');
                } else {
                    ans.append(s.charAt(nonRepIndex));
                }
                
            }
            
            
            return ans.toString();
        }
    }