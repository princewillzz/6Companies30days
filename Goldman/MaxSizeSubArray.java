package Goldman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSizeSubArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inp[] = br.readLine().split(" ");
        int target = Integer.parseInt(br.readLine());

        int nums[] = new int[inp.length];
        for (int j = 0; j < nums.length; j++) {
            nums[j] = Integer.parseInt(inp[j]);
        }
        System.out.println(new Solution().minSubArrayLen(target, nums));
    }
}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        
        int sum = 0, n = nums.length;
        int start = 0, current = start;
        while(current < n) {
            sum += nums[current];
            
            while(sum >= target) {
                ans = Math.min(ans, current - start + 1);
                sum -= nums[start];
                start++;
            } 
            current++;
        }
        
        return ans == Integer.MAX_VALUE? 0: ans;
    }
}