class Solution {
    private int time=0;
    public void dfsutil(int curr,int par,ArrayList<ArrayList<Integer>> adj,int dt[],int low[],int time,List<List<Integer>>ans,boolean[] visited){

        visited[curr]=true;
        dt[curr]=low[curr]=++time;

        ArrayList<Integer>demp=adj.get(curr);

        for(int i=0;i<demp.size();i++){
            int neighbour=demp.get(i);

            if(neighbour==par){
                continue;
            }
            else if(!visited[neighbour]){
                dfsutil(neighbour,curr,adj,dt,low,time,ans,visited);
                low[curr]=Math.min(low[curr],low[neighbour]);
                if(dt[curr]<low[neighbour]){
                    ans.add(Arrays.asList(curr,neighbour));
                    // temp.add(curr);
                    // temp.add(neighbour);
                }
            }else{
                low[curr]=Math.min(low[curr],dt[neighbour]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> con:connections){
            int u=con.get(0);
            int v=con.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean visited[]=new boolean[n];
        int dt[]=new int[n];
        int low[]=new int[n];
        
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(!visited[i]){
                
                dfsutil(i,-1,adj,dt,low,time,ans,visited);
                
                
            }
        }

        return ans;
    }
}