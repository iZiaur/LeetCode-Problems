class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            arr.add(nums[i]);
        }
        for(int i=1;i<110;i++){
            if(!arr.contains(k)){
                return k;
            }
            if(!arr.contains(i*k)){
                // System.out.println(i*k);
                return i*k;
            }
        }
        return 0;
    }
}