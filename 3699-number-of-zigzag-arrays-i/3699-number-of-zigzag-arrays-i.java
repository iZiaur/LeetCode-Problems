class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int MOD = 1_000_000_007;
        
        // m is the total number of valid values we can pick from
        int m = r - l + 1;
        
        // dpUp[v] = number of valid arrays ending with value v 
        // where the last transition was strictly INCREASING (UP)
        int[] dpUp = new int[m];
        
        // dpDown[v] = number of valid arrays ending with value v
        // where the last transition was strictly DECREASING (DOWN)
        int[] dpDown = new int[m];
        
        // Base Case: Arrays of length 2
        // We use 0-indexed values to represent the range [l, r]
        for (int v = 0; v < m; v++) {
            dpUp[v] = v;             // Count of previous elements < v
            dpDown[v] = m - 1 - v;   // Count of previous elements > v
        }
        
        // DP Transitions for lengths from 3 up to n
        for (int i = 3; i <= n; i++) {
            int[] newDpUp = new int[m];
            int[] newDpDown = new int[m];
            
            // For a new step to go UP, the previous step MUST have gone DOWN.
            // newDpUp[v] = Sum of dpDown[u] for all u < v
            long prefixSum = 0;
            for (int v = 0; v < m; v++) {
                newDpUp[v] = (int) prefixSum;
                prefixSum = (prefixSum + dpDown[v]) % MOD;
            }
            
            // For a new step to go DOWN, the previous step MUST have gone UP.
            // newDpDown[v] = Sum of dpUp[u] for all u > v
            long suffixSum = 0;
            for (int v = m - 1; v >= 0; v--) {
                newDpDown[v] = (int) suffixSum;
                suffixSum = (suffixSum + dpUp[v]) % MOD;
            }
            
            // Roll the arrays over for the next iteration (Space Optimization)
            dpUp = newDpUp;
            dpDown = newDpDown;
        }
        
        // Sum up all valid arrays of length n
        long totalValidArrays = 0;
        for (int v = 0; v < m; v++) {
            totalValidArrays = (totalValidArrays + dpUp[v]) % MOD;
            totalValidArrays = (totalValidArrays + dpDown[v]) % MOD;
        }
        
        return (int) totalValidArrays;
    }
}