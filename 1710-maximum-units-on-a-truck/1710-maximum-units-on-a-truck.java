class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt((int[] a) -> a[1]).reversed());

        int totalsize=truckSize;
        int totalunits=0;

        for(int i=0;i<boxTypes.length;i++){
            if(totalsize==0){ break;}
            int boxesToTake = Math.min(boxTypes[i][0], totalsize);
            totalsize=totalsize-boxesToTake;
            totalunits+=boxesToTake*boxTypes[i][1];
        
        }

        return totalunits;
    }
}