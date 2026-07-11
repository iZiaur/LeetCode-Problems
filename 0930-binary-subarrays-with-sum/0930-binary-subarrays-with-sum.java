class Solution {

    public  int count(int nums[] ,int k){
        if(k<0){
            return 0;
        }
       
       int count=0;
        int sum=0;
        int r=0;
        int l=0;
        
        while(r<nums.length){
            sum+=nums[r];
            while(sum>k){
                sum=sum-nums[l];
                l++;
                
            }
            count+=r-l+1;
            r++;
        }
        
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return count(nums,goal)-count(nums,goal-1);
    }
}