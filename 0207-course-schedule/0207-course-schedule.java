class Solution {
    // cycle detection-directed graph
    public boolean dfscycle(int start,boolean[] visited, ArrayList<ArrayList<Integer>> adj,boolean[] stack){
        visited[start]=true;
        stack[start]=true;
        ArrayList<Integer>temp=adj.get(start);
        for(int i=0;i<temp.size();i++){
            int n=temp.get(i);

            if(stack[n]) return true;

            if(!visited[n] && dfscycle(n,visited,adj,stack)) return true;
        }
        stack[start]=false;

        return false;

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    // if(prerequisites.length==1) return true;
    for(int i=0;i<numCourses;i++){
        adj.add(new ArrayList<>());
    }

    for(int [] edge:prerequisites){
        int u=edge[1];
        int v=edge[0];
        adj.get(u).add(v);
    }

    boolean[] visited=new boolean[numCourses];
    boolean[] stack=new boolean[numCourses];
    for(int i=0;i<numCourses;i++){
        if(!visited[i]){
            if(dfscycle(i,visited,adj,stack)){
                return false;
            }
        }
    }

    return true;

    }
}