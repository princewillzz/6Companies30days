package Goldman;

// { Driver Code Starts
//Initial Template for Java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.decodedString(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static String decodedString(String s){
        if(s == "") return "";
        String sol = new String();
        int repeat = 1;
        for(int i =0;i<s.length();++i)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                String temp = "";
                int k = i;
                while(Character.isDigit(s.charAt(k)))
                {
                    temp+=s.charAt(k);
                    k++;
                }
                repeat = Integer.parseInt(temp);
                i = k-1;
            }
            else if(s.charAt(i) =='[')
            {
                Stack<Character> st = new Stack<>();
                st.push('[');
                int k = i+1;
                while(!st.isEmpty())
                {
                    if(s.charAt(k) == ']')
                    {
                        st.pop();
                        k++;
                    }
                    else if(s.charAt(k) =='[')
                    {
                        st.push('[');
                        k++;
                    }
                    else k++;
                }
                String inside_bracket = decodedString(s.substring(i+1,k-1));
                i = k-1;
                for(int j =0;j<repeat;++j)
                {
                    sol+=inside_bracket;
                }
            }
            
            else
            {
                sol+=s.charAt(i);
            }
        }
        return sol;
    }
}
