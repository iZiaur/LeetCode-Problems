class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] last = new long[26];
        long totalSum = 0;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            long newCount = (totalSum + 1) % MOD;
            totalSum = (totalSum - last[idx] + newCount + MOD) % MOD;
            last[idx] = newCount;
        }

        return (int) totalSum;
    }
}