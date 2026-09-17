import java.util.*;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        List<int[]> intervals = new ArrayList<>();
        int left = 0;
        int sum = 0;
        
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            
            if (sum == target) {
                intervals.add(new int[]{left, right, right - left + 1});
                sum -= arr[left];
                left++;
            }
        }
        
        int size = intervals.size();
        if (size < 2) return -1;
        
        int[] minLenLeft = new int[size];
        minLenLeft[0] = intervals.get(0)[2];
        for (int i = 1; i < size; i++) {
            minLenLeft[i] = Math.min(minLenLeft[i - 1], intervals.get(i)[2]);
        }
        
        int minSum = Integer.MAX_VALUE;
        
        for (int j = 1; j < size; j++) {
            int[] current = intervals.get(j);
            
            int low = 0, high = j - 1, bestIdx = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (intervals.get(mid)[1] < current[0]) {
                    bestIdx = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            if (bestIdx != -1) {
                minSum = Math.min(minSum, current[2] + minLenLeft[bestIdx]);
            }
        }
        
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}