package Goldman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class OverlappingRectangles {

    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int p[] = new int[2];
            int q[] = new int[2];
            int r[] = new int[2];
            int s[] = new int[2];
            p[0] = Integer.parseInt(S[0]);
            p[1] = Integer.parseInt(S[1]);
            q[0] = Integer.parseInt(S[2]);
            q[1] = Integer.parseInt(S[3]);
            r[0] = Integer.parseInt(S[4]);
            r[1] = Integer.parseInt(S[5]);
            s[0] = Integer.parseInt(S[6]);
            s[1] = Integer.parseInt(S[7]);
            Solution ob = new Solution();
            int ans = ob.doOverlap(p, q, r, s);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int doOverlap(int l1[], int r1[], int l2[], int r2[]) {
        
        if(l1[0] > r2[0] || l2[0] > r1[0]) return 0;
        
        if(r1[1] > l2[1] || r2[1] > l1[1]) return 0;
     
        return 1;
    }
};
