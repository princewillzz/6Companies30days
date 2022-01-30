class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] tzero = new int[n];
        for (int i = 0; i < n; ++i)
        {
            int cnt = 0;
            for (int j = n - 1; j >= 0; --j)
            {
                if (grid[i][j] != 0)
                    break;
                cnt++;
            }
            tzero[i] = cnt;
        }
        int need = n - 1;
        int ans = 0;
        while (need > 0)
        {
            boolean flag = false;
            for (int i = n - 1 - need ; i < n; ++i)
            {
                if (tzero[i] >= need)
                {

                    int temp = tzero[i];
                    for (int k = i; k > n - need - 1; --k)
                        tzero[k] = tzero[k - 1];
                    tzero[n - need - 1] = temp;
                    flag = true;

                    ans += i - (n - need - 1);

                    break;
                }
            }
            if (!flag)  return -1;
            need--;
        }
        return ans;
    }
}