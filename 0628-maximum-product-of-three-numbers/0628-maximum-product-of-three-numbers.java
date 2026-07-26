class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int max1=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int max2=nums[nums.length-1]*nums[0]*nums[1];
        int finals=Math.max(max1,max2);

        return finals;
    }
}