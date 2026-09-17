class Solution {
    public boolean dfsutil(int curr,ArrayList<ArrayList<Integer>> adj,boolean[] visited,boolean [] stack,Stack<Integer>st){
        visited[curr]=true;
        stack[curr]=true;
        ArrayList<Integer>temp=adj.get(curr);
        for(int i=0;i<temp.size();i++){

            if(stack[temp.get(i)]) return true;
            if(!visited[temp.get(i)]){
               if( dfsutil(temp.get(i),adj,visited,stack,st) ) return true;
            }
        }
        stack[curr]=false;
        st.push(curr);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
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
        Stack<Integer>st=new Stack<>();
        int[] ans=new int[numCourses];
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                if(dfsutil(i,adj,visited,stack,st)) return new int[]{};
            }
        }
        
        for(int i=0;i<ans.length;i++){
            ans[i]=st.pop();
        }

        return ans;
    }
}