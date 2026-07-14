class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue(Comparator.reverseOrder());

        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }

        k=k-1;
        while(k>0){
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}