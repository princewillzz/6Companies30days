class Solution {
    public int splitArray(int[] nums, int m) {
        int low = 0, high = 0;
        for(int num: nums){
            if(num > low){
                low = num;
            }
            high += num;
        }

        while (low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(nums, m, mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isPossible(int[] nums, int m, int val){

        int n = 0, curr = 0;
        for(int num: nums){
            curr += num;
            if(curr > val){
                ++n;
                curr = num;
            }
        }
        if(curr > 0){
            ++n;
        }
        return n <= m;
    }
}