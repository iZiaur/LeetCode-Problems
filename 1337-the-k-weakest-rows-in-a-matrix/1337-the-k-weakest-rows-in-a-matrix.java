class Solution {

    static class Soldiers implements Comparable <Soldiers>{
        int soldiers;
        int idx;

        public Soldiers(int soldiers,int idx){
            this.soldiers=soldiers;
            this.idx=idx;
        }

        public int compareTo(Soldiers s1){
            if(s1.soldiers==this.soldiers){
                return this.idx-s1.idx;
            }else{
                return this.soldiers-s1.soldiers;
            }
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Soldiers> pq=new PriorityQueue<>();
        for(int i=0;i<mat.length;i++){
            int count=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            pq.add(new Soldiers(count,i));
        }

       int arr[]=new int[k];
       int i=0;
       while(k>0){
        Soldiers s1=pq.poll();
        arr[i]=s1.idx;
        k--;
        i++;
       }
       return arr;
    }
}