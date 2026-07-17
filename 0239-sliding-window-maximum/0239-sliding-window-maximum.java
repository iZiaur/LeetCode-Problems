class Solution {
    static class Maxi implements Comparable <Maxi>{
        int el;
        int idx;

        public Maxi(int el,int idx){
            this.el=el;
            this.idx=idx;

        }

        public int compareTo(Maxi m1){
            return m1.el-this.el;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Maxi> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(new Maxi(nums[i],i));
        }

        int arr[]=new int[nums.length-k+1];
        Maxi m1=pq.peek();
        arr[0]=m1.el;

        for(int i=k;i<nums.length;i++){
            
            while(!pq.isEmpty() && pq.peek().idx<=i-k){
                pq.poll();
            }
            pq.add(new Maxi(nums[i],i));
            arr[i-k+1]=pq.peek().el;
        }

        return arr;
    }
}