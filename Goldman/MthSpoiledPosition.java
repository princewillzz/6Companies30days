package Goldman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MthSpoiledPosition {
    
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int K = Integer.parseInt(S[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.findPosition(N,M,K));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int findPosition(int N , int M , int K) {
        
        return (K+M-2)%N + 1;
    }
};