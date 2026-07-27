class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int a=nums[nums.length-1];
        int b=nums[nums.length-2];

        int max=(a-1)*(b-1);
        return max;
    }
}