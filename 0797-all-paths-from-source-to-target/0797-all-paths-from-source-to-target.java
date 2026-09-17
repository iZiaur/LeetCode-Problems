class Solution {
    public void dfsutil(int src,int des,int[][] graph,List<Integer>path,List<List<Integer>> ans){
        // List<Integer> temp=new ArrayList<>();
        if(src==des){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<graph[src].length;i++){
            path.add(graph[src][i]);
            dfsutil(graph[src][i],des,graph,path,ans);
            path.remove(path.size()-1);
        }
        // ans.add(temp);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int src=0;
        int des=graph.length-1;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>path=new ArrayList<>();
        if(src==des) return ans;
        path.add(src);
        dfsutil(src,des,graph,path,ans);
        return ans;
    }
}