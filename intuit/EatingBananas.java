class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high=0;
        for(int i=0;i<piles.length;i++){
            high = Math.max(piles[i],high);
        }
        while(low <= high)
        {
            int mid = low + (high - low)/2;

            if(ispossible(piles,mid,h)){
                high = mid-1;
            }
            else low = mid+1;
        }
        return low;
    }
    private boolean ispossible(int[] piles,int k,int hours)
    {
        int ans = 0;
        for(int i=0;i<piles.length;i++)
        {
            ans += (piles[i]/k);
            if(piles[i]%k != 0) ans++;
        }
        return ans <= hours;
    }
}
