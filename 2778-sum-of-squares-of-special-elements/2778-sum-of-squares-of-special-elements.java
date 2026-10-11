class Solution {
    public int sumOfSquares(int[] nums) {
        int prod=0;
        int n=nums.length;

        for(int i=0;i<n;i++){

            if(n%(i+1)==0){
                System.out.println(i+1);
                prod+=nums[i]*nums[i];
            }
        }

        return prod;
    }
}