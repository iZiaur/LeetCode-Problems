class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc=1;
        int max=1;
       for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]>nums[i]){
                max++;
            }else{
                max=1;
            }
            inc=Math.max(max,inc);
       }

        int dec=1;
        int maxdec=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                maxdec++;
            }else{
                maxdec=1;
            }
            dec=Math.max(maxdec,dec);
        }
        System.out.println(dec);
        return Math.max(inc,dec);
}
}