class Solution {
    class Pair{
        int node;
        double prob;
        Pair(int node, double prob){
            this.node = node;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Pair>[] g = new ArrayList[n];
        for(int i=0; i<n; i++){
            g[i] = new ArrayList<>();
        }
        for(int i = 0; i<edges.length; i++){
            g[edges[i][0]].add(new Pair(edges[i][1], succProb[i]));
            g[edges[i][1]].add(new Pair(edges[i][0], succProb[i]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if(a.prob < b.prob) return 1;
                else if(a.prob > b.prob) return -1;
                return 0;
            }
        });

        pq.offer(new Pair(start, 1));

        Set<Integer> visited = new HashSet<>();

        double ans = Integer.MIN_VALUE;

        while(!pq.isEmpty()){
            Pair temp = pq.poll();
            if(temp.node == end){
                ans = Math.max(ans, temp.prob);
            }
            visited.add(temp.node);
            for(Pair neigh : g[temp.node]){
                if(!visited.contains(neigh.node)){
                    pq.offer(new Pair(neigh.node, neigh.prob * temp.prob));
                }
            }

        }

        return ans==Integer.MIN_VALUE?0: ans;
    }
}
