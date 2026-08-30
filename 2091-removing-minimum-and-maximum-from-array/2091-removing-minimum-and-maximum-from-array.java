class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        if(nums.length==2){
            return 2;
        }

        int minindex=0;
        int maxindex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[maxindex]){
                maxindex=i;
            }
            if(nums[i]<nums[minindex]){
                minindex=i;
            }
        }

        int leftclosest=Math.min(minindex,maxindex);
        int rightclosest=Math.max(minindex,maxindex);

        int leftdeletions=rightclosest+1;
        int rightdeletions=nums.length-leftclosest;
        int option=(leftclosest+1)+(nums.length-rightclosest);
        return Math.min(leftdeletions,Math.min(rightdeletions,option));
    }
}