class Solution {
    int mod = 1000000007;
    class Pair implements Comparable<Pair>{
        int speed;
        int efficiency;
        public Pair(int speed , int efficiency){
            this.speed=speed;
            this.efficiency = efficiency;
        }
        public int compareTo(Pair other){
            return other.efficiency-this.efficiency;
        }
    }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Pair arr[] = new Pair[n];
        for(int i=0;i<n;i++){
            arr[i] = new Pair(speed[i],efficiency[i]);
        }
        Arrays.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue();
        long total = 0;
        long ans = Long.MIN_VALUE;

        for(Pair p : arr){
            if(pq.size()<k){
                pq.add(p.speed);
                total+=p.speed;
            }else{
                total-=pq.remove();
                pq.add(p.speed);
                total+=p.speed;
            }
            ans = Math.max(ans,total*p.efficiency);
        }

        return  (int)(ans%mod);
    }
}