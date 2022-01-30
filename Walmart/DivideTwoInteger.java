class Solution {
    public int divide(int dividend, int divisor) {
        boolean neg=false;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            neg=true;
        }
        long divid = Math.abs((long) dividend);
        long divis = Math.abs((long) divisor);
        long ans = 0;
        while(divid >= divis){
            long tmp = divis, cnt = 1;
            while(tmp <= divid){
                tmp <<= 1;
                cnt <<= 1;
            }
            ans += cnt >> 1;
            divid -= tmp >> 1;
        }
        if(neg){
            return (int)~ans+1;
        }
        else
            return  ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) ans;
    }
}