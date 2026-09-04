class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            System.out.println(max);

            int min=Integer.MAX_VALUE;
            for(int j=i;j<nums.length;j++){
                min=Math.min(min,nums[j]);
            }
            System.out.println(min);

            int diff=max-min;
            System.out.println(diff);
            if(diff<=k){
                return i;
            }
        
        }
        return -1;
    }
}