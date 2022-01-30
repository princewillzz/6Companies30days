class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int cnt = 0;

        for(int i = 0; i < n ;i++){
            if(!vis[i]){
                dfs(isConnected,i,vis);
                cnt++;
            }
        }
        return cnt;
    }


    private void dfs(int[][] isConnected,int i,boolean[] visited){
        for(int j = 0 ; j < isConnected[i].length ; j++){
            if(!visited[j] && isConnected[i][j] != 0){
                visited[j] = true;
                dfs(isConnected,j,visited);
            }
        }
    }

}