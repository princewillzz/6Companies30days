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
                String[] S = br.readLine().trim().split(" ");
                int n = Integer.parseInt(S[0]);
                int m = Integer.parseInt(S[1]);
                char [][] board = new char[n][m];
                for(int i = 0; i < n; i++){
                    String[] s = br.readLine().trim().split(" ");
                    for(int j = 0; j < m; j++){
                        board[i][j] = s[j].charAt(0);
                    }
                }
                String word = br.readLine().trim();
                Solution obj = new Solution();
                boolean ans = obj.isWordExist(board, word);
                if(ans)
                    System.out.println("1");
                else
                    System.out.println("0");
           }
        }
    }// } Driver Code Ends
    
    
    class Solution
    {
        public boolean isWordExist(char[][] board, String word)
        {
            // Code here
            for(int i=0; i<board.length; i++)
                for(int j=0; j<board[0].length; j++)
                    if(board[i][j]==word.charAt(0) && helper(board,word,0,i,j))
                        return true;
    
            return false;
        }
    
        private boolean helper(char[][] b, String word, int poss, int r, int c){
    
            if(word.length() <= poss)
                return true;
    
            if(r<0 ||c<0 || r>=b.length || c>=b[0].length || b[r][c]=='1' || b[r][c]!=word.charAt(poss))
                return false;
    
            char tmp = b[r][c];
            b[r][c] = '1';
    
            if(helper(b,word,poss+1,r+1,c) ||
                    helper(b,word,poss+1,r-1,c) ||
                    helper(b,word,poss+1,r,c+1) ||
                    helper(b,word,poss+1,r,c-1))
                return true;
    
            b[r][c] = tmp;
    
            return false;
        }
    }
    