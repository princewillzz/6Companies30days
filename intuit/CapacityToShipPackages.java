
  
class Solution {
    private boolean poss(int[] weights,int mid,int days){
        int sum=0;
        int cnt=1;
        for(int it:weights){
            if(it>mid){
                return false;
            }
            if(sum+it> mid){
                sum=it;
                cnt++;
            }
            else{
                sum+=it;
            }
        }
        if(cnt<=days) return true;
        else return false;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int low=1;
        int high=0;
        for(int it:weights) high+=it;

        int ans=high;

        while(low<=high){
            int mid=(low+high)>>1;
            if (poss(weights,mid,days)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return ans;

    }
}