
  
class Solution {
    class Pair{
        int x;
        int y;

        Pair(int x ,int y ){
            this.x=x;
            this.y=y;
        }
    }
    private int [][] dirs={{-1,0},{0,1},{1,0},{0,-1}};
    public int maxDistance(int[][] grid) {
        ArrayDeque<Pair> q=new ArrayDeque<>();

        for(int i=0;i<grid.length;i++ ){
            for(int j =0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j));

                }
            }
        }

        if(q.size()==grid.length*grid[0].length){
            return -1;
        }


        int level=-1;
        while(q.size()!=0){
            int size=q.size();
            level++;
            while(size-->0){
                Pair temp=q.removeFirst();

                for(int i =0;i<dirs.length;i++){
                    int newrow=temp.x+dirs[i][0];
                    int newcol=temp.y+dirs[i][1];

                    if(newrow>=0 && newcol>=0 && newrow<grid.length && newcol<grid[0].length && grid[newrow][newcol]==0){
                        grid[newrow][newcol]=1;
                        q.add(new Pair(newrow,newcol));
                    }
                }
            }
        }
        return level;
    }
}
