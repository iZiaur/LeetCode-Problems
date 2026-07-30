class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();

        int i=0;
        int n=intervals.length;

        while(i<n && intervals[i][1]<newInterval[0]){
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            arr.add(temp);
            i++;
        }
        int min=newInterval[0];
        int max=newInterval[1];
        while(i<n && intervals[i][0]<=newInterval[1]){
            // System.out.println("The minimum interval is "+intervals[i][0]);
            min=Math.min(intervals[i][0],min);
            // System.out.println("The maximum interval is "+intervals[i][1]);
            max=Math.max(intervals[i][1],max);
            i++;
        }
        ArrayList<Integer> tempu=new ArrayList<>();
        tempu.add(min);
        tempu.add(max);
        arr.add(tempu);

        while(i<n){
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            arr.add(temp);
            i++;
        }



        // for(int j=0;j<arr.size();j++){
        //     ArrayList<Integer> temp=arr.get(j);
        //     System.out.println(temp.get(0)+" "+temp.get(1));
        // }

        int sol[][]=new int[arr.size()][2];

        for(int j=0;j<arr.size();j++){
            ArrayList<Integer> temp=arr.get(j);

            sol[j][0]=temp.get(0);
            sol[j][1]=temp.get(1);
        }


        return sol;
    }
}