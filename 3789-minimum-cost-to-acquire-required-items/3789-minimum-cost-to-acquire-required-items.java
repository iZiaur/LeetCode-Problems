class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long overallcost=0;

        long check1=(long)cost1*need1+(long)cost2*need2;
        
        long check2=(long)costBoth*Math.max(need1,need2);
        long common=Math.min(need1,need2);

        long check3=(long)common*costBoth+(need1-common)*cost1+(need2-common)*cost2;

        return Math.min(check1,Math.min(check2,check3));
    }
}