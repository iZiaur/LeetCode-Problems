class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max[]=new int[nums.length];
        int dummyel=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            dummyel=Math.max(nums[i],dummyel);
            max[i]=dummyel;
        }

        int min[]=new int[nums.length];
        int dum=Integer.MAX_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            dum=Math.min(dum,nums[i]);
            min[i]=dum;
        }

        for(int i=0;i<nums.length;i++){
            int diff=max[i]-min[i];
            if(diff<=k){
                return i;
            }
        }

        return -1;
    }
}