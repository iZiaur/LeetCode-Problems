class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        int count = 0;

        for (int i = 100; i <= 998; i += 2) {
            int d1 = i / 100;
            int d2 = (i / 10) % 10;
            int d3 = i % 10;

            int[] cur = new int[10];
            cur[d1]++;
            cur[d2]++;
            cur[d3]++;

            boolean valid = true;
            for (int d = 0; d < 10; d++) {
                if (cur[d] > freq[d]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                count++;
            }
        }

        return count;
    }
}