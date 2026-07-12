class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max=0;

        int leftsum=0;
        int rightsum=0;
        int rightindex=cardPoints.length-1;

        for(int i=0;i<k;i++){
            leftsum+=cardPoints[i];
            max=leftsum;
        }

        for(int i=k-1;i>=0;i--){
            leftsum=leftsum-cardPoints[i];
            rightsum=rightsum+cardPoints[rightindex];
            rightindex--;
            max=Math.max(max,leftsum+rightsum);
        }
        return max;
    }
}