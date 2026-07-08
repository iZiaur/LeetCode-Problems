import java.util.Arrays;

class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        long MOD = 1_000_000_007L;

        int[] prefSum = new int[m + 1];
        for (int i = 0; i < m; i++) {
            prefSum[i + 1] = prefSum[i] + (s.charAt(i) - '0');
        }

        StringBuilder sb = new StringBuilder();
        int[] origToTrimmed = new int[m];
        Arrays.fill(origToTrimmed, -1);

        for (int i = 0; i < m; i++) {
            char ch = s.charAt(i);
            if (ch != '0') {
                origToTrimmed[i] = sb.length();
                sb.append(ch);
            }
        }

        String trimmed = sb.toString();
        int n = trimmed.length();

        int[] nxt = new int[m];
        int lastNxt = n;
        for (int i = m - 1; i >= 0; i--) {
            if (origToTrimmed[i] != -1) {
                lastNxt = origToTrimmed[i];
            }
            nxt[i] = lastNxt;
        }

        int[] prev = new int[m];
        int lastPrev = -1;
        for (int i = 0; i < m; i++) {
            if (origToTrimmed[i] != -1) {
                lastPrev = origToTrimmed[i];
            }
            prev[i] = lastPrev;
        }

        long[] prefVal = new long[n + 1];
        long[] power10 = new long[n + 1];
        power10[0] = 1;

        for (int i = 0; i < n; i++) {
            prefVal[i + 1] = (prefVal[i] * 10 + (trimmed.charAt(i) - '0')) % MOD;
            power10[i + 1] = (power10[i] * 10) % MOD;
        }

        int[] answer = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int l = queries[q][0];
            int r = queries[q][1];

            int lPrime = nxt[l];
            int rPrime = prev[r];

            if (lPrime > rPrime || lPrime == n) {
                answer[q] = 0;
                continue;
            }

            long x = (prefVal[rPrime + 1] - (prefVal[lPrime] * power10[rPrime - lPrime + 1]) % MOD + MOD) % MOD;
            long sum = prefSum[r + 1] - prefSum[l];

            answer[q] = (int) ((x * sum) % MOD);
        }

        return answer;
    }
}