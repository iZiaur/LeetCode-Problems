class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        boolean hasnonzero=false;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
            if(nums[i]!=0){
                hasnonzero=true;
            }
        }

        if(xor!=0){
            return nums.length;
        }
        if(hasnonzero){
            
            return nums.length-1;
        }
        return 0;
    }
}