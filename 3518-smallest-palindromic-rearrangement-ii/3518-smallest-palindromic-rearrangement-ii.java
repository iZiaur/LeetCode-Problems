class Solution {
    private static final int MAX_K = 1_000_001;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] halfCount = new int[26];
        char midChar = '\0';
        int oddCount = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('a' + i);
            }
            halfCount[i] = freq[i] / 2;
        }

        if (oddCount > 1) {
            return "";
        }

        long totalPermutations = countArrangements(halfCount);
        if (k > totalPermutations) {
            return "";
        }

        int halfLen = 0;
        for (int count : halfCount) {
            halfLen += count;
        }

        StringBuilder leftHalf = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (halfCount[c] == 0) {
                    continue;
                }

                halfCount[c]--;
                long currentCount = countArrangements(halfCount);

                if (k <= currentCount) {
                    leftHalf.append((char) ('a' + c));
                    break;
                } else {
                    k -= currentCount;
                    halfCount[c]++;
                }
            }
        }

        String leftStr = leftHalf.toString();
        String rightStr = new StringBuilder(leftStr).reverse().toString();

        if (midChar != '\0') {
            return leftStr + midChar + rightStr;
        } else {
            return leftStr + rightStr;
        }
    }

    private long countArrangements(int[] count) {
        int total = 0;
        for (int c : count) {
            total += c;
        }

        long res = 1;
        for (int c : count) {
            if (c == 0) continue;
            res *= nCk(total, c);
            if (res >= MAX_K) {
                return MAX_K;
            }
            total -= c;
        }
        return res;
    }

    private long nCk(int n, int k) {
        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;

        k = Math.min(k, n - k);
        long res = 1;

        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
            if (res >= MAX_K) {
                return MAX_K;
            }
        }
        return res;
    }
}