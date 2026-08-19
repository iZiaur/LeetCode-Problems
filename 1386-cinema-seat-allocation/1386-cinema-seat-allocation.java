class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowSeatsMap = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (col >= 2 && col <= 9) {
                rowSeatsMap.put(row, rowSeatsMap.getOrDefault(row, 0) | (1 << col));
            }
        }

        int maxFamilies = (n - rowSeatsMap.size()) * 2;

        int leftMask = 60;    
        int rightMask = 960;  
        int middleMask = 240; 

        for (int mask : rowSeatsMap.values()) {
            boolean canFitLeft = (mask & leftMask) == 0;
            boolean canFitRight = (mask & rightMask) == 0;

            if (canFitLeft && canFitRight) {
                maxFamilies += 2;
            } else if (canFitLeft || canFitRight || (mask & middleMask) == 0) {
                maxFamilies += 1;
            }
        }

        return maxFamilies;
    }
}