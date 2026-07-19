class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,Comparator.comparingInt(o->o[1]));

        int max=1;
        int lowerbound=pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>lowerbound){
                max++;
                lowerbound=pairs[i][1];
            }
        }
        return max;
    }
}