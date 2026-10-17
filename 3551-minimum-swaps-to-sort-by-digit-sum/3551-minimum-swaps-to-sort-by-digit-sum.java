import java.util.*;

class Solution {
    class Pair {
        int digit;
        int sum;
        int originalIndex;

        public Pair(int digit, int sum, int originalIndex) {
            this.digit = digit;
            this.sum = sum;
            this.originalIndex = originalIndex;
        }
    }

    public int minSwaps(int[] nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.sum != b.sum) {
                return a.sum - b.sum;
            }
            return a.digit - b.digit;
        });

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int sum = 0;
            while (temp > 0) {
                sum += temp % 10;
                temp = temp / 10;
            }
            pq.offer(new Pair(nums[i], sum, i));
        }

        int n = nums.length;
        Pair[] sortedPairs = new Pair[n];
        int idx = 0;
        while (!pq.isEmpty()) {
            sortedPairs[idx++] = pq.poll();
        }

        boolean[] visited = new boolean[n];
        int totalSwaps = 0;

        for (int i = 0; i < n; i++) {
            // If already visited or already in the correct position
            if (visited[i] || sortedPairs[i].originalIndex == i) {
                continue;
            }

            // Find the size of the cycle
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = sortedPairs[j].originalIndex;
                cycleSize++;
            }

            if (cycleSize > 1) {
                totalSwaps += (cycleSize - 1);
            }
        }

        return totalSwaps;
    }
}