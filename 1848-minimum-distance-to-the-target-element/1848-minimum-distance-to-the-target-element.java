class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                list.add(i);
            }
        }
        int min=Integer.MAX_VALUE;

        for(int i=0;i<list.size();i++){
            min=Math.min(Math.abs(list.get(i)-start),min);
        }
        return min;
    }
}