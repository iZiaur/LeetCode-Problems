class Solution {
    public boolean isBipartite(int[][] graph) {
        int [] colors=new int[graph.length];
        Arrays.fill(colors,-1);
       
        for(int i=0;i<colors.length;i++){
            if(colors[i]==-1){
                Queue<Integer> q=new LinkedList<>();
                colors[i]=0;
                q.add(i);
                while(!q.isEmpty()){
                    Integer curr=q.poll();
                    for(int j=0;j<graph[curr].length;j++){
                        if(colors[graph[curr][j]]==-1){
                            int nextcolor=colors[curr]==0?1:0;
                            colors[graph[curr][j]]=nextcolor;
                            q.add(graph[curr][j]);
                        }else if(colors[curr]==colors[graph[curr][j]]){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}