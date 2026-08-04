class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> sol=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }

        for(int i=min;i<=max;i++){
            if(!list.contains(i)){
                sol.add(i);
            }
        }

        return sol;

    }
}