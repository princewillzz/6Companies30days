// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().lengthOfLongestAP(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int lengthOfLongestAP(int[] A, int n) {
        if(n <= 2) return n;
        
        ArrayList<HashMap<Integer, Integer>> memo = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            memo.add(new HashMap<Integer, Integer>());
        }
        
        int ans = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int diff = A[i] - A[j];
                if(!memo.get(j).containsKey(diff)) {
                    memo.get(i).put(diff, 2);
                } else {
                    memo.get(i).put(diff, memo.get(j).get(diff)+1);
                }
                ans = Math.max(ans, memo.get(i).get(diff));
            }
            
            
        }
        
        return ans;
    }
}
