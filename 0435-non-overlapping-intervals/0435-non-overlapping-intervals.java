class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //sorting the intervals on the basis of their end times first

        Arrays.sort(intervals,Comparator.comparingInt(o->o[1]));

        int max=1;
        int last_time=intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=last_time){
                max++;
                last_time=intervals[i][1];
            }
        }
        return intervals.length-max;
    }
}