class Solution {
    class Pair{
        int x;
        int y;
      

        public Pair(int x,int y){
            this.x=x;
            this.y=y;
           
        }
    }
   
    public int[][] updateMatrix(int[][] mat) {
        int [][] ans=new int[mat.length][mat[0].length];
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j));
                }else{
                    ans[i][j]=-1;
                    //because i need to visit these 1s they indicate distance has not been competed yet
                }
            }
        }

        int drow[]={-1,1,0,0};
        int dcol[]={0,0,-1,1};
        while(!q.isEmpty()){
            Pair p=q.remove();
            int x=p.x;
            int y=p.y;
            for(int i=0;i<4;i++){
                int nrow=x+drow[i];
                int ncol=y+dcol[i];
                if(nrow>=0 && nrow<ans.length && ncol>=0 && ncol<ans[0].length && ans[nrow][ncol]==-1){
                    ans[nrow][ncol]=ans[x][y]+1;
                    q.add(new Pair(nrow,ncol));
                }

            }
        }


        return ans;
    }
}