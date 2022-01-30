
  
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp  = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = piles[i];
        for (int gap = 1; gap < n; gap++)
            for (int i = 0; i < n - gap; i++)
                dp[i][i + gap] = Math.max(piles[i] - dp[i + 1][i + gap], piles[i + gap] - dp[i][i + gap - 1]);
        return dp[0][n - 1] > 0;
    }
}