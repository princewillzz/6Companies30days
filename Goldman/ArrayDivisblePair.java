package Goldman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] nums, int k) {
        int rem[] = new int[k];
        
        for(int i = 0; i < nums.length; i++) rem[nums[i] % k]++;
        
        if(rem[0] % 2 != 0) return false;
        
        int start = 1, end = k-1;
        while(start < end) {
            if(rem[start] != rem[end]) return false;
            start++;end--;
        }
        
        return true;
    }
}