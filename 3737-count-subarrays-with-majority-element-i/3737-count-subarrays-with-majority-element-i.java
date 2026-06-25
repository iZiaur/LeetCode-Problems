class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int count=0;

        for(int i=0;i<nums.length;i++){
            int temp=0;
            for(int j=i;j<nums.length;j++){
                
                if(nums[j]==target){
                    temp++;
                }
                if(temp>((j-i+1)/2)){
                    count++;
                }
                

                
            }
            
        }
       
        return count;
    }
}