class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();

        int start=intervals[0][0];
        int end=intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                end=Math.max(end,intervals[i][1]);
            }else{
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(start);
                temp.add(end);
                list.add(temp);
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
         ArrayList<Integer> tempu=new ArrayList<>();
                tempu.add(start);
                tempu.add(end);
                list.add(tempu);



        int sol[][]=new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ArrayList<Integer> temp=list.get(i);
            sol[i][0]=temp.get(0);
            sol[i][1]=temp.get(1);
        }

        return sol;
    }
}