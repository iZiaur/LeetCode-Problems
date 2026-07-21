class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int greedpointer=g.length-1;
        int contentpointer=s.length-1;
        int count=0;
        while(greedpointer>=0 && contentpointer>=0){
            if(s[contentpointer]>=g[greedpointer]){
                count++;
                greedpointer--;
                contentpointer--;
            }else{
                greedpointer--;
            }
        }

        return count;
    }
}