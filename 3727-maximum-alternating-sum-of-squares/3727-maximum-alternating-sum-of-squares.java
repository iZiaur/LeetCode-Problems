class Solution {
    public long maxAlternatingSum(int[] nums) {
        ArrayList<Long> arr=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            arr.add((long)(nums[i]*nums[i]));
        }
        Collections.sort(arr);
        long sum=0;
        int k=arr.size()/2;
        for(int i=0;i<k;i++) sum-=arr.get(i);
        for(int i=k;i<arr.size();i++) sum+=arr.get(i);

        return sum;
    }
}