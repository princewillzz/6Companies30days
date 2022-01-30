class Solution {
    int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0)
            return ans;


        int row = matrix.length, col = matrix[0].length;

        boolean[][] paci = new boolean[row][col];
        boolean[][] antla = new boolean[row][col];

        for(int i = 0; i < col; i++){
            dfs(matrix, 0, i, Integer.MIN_VALUE, paci);
            dfs(matrix, row-1, i, Integer.MIN_VALUE, antla);
        }
        for(int i = 0; i < row; i++){
            dfs(matrix, i, 0, Integer.MIN_VALUE, paci);
            dfs(matrix, i, col-1, Integer.MIN_VALUE, antla);
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++) {
                if(paci[i][j] && antla[i][j]) {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
    }

    public void dfs(int[][] matrix, int i, int j, int prev, boolean[][] dp){
        if(i < 0 || i >= dp.length || j < 0 || j >= dp[0].length) return;
        if(matrix[i][j] < prev || dp[i][j]) return;

        dp[i][j] = true;

        for(int[] d : dir){
            dfs(matrix, i+d[0], j+d[1], matrix[i][j], dp);
        }

    }
}
