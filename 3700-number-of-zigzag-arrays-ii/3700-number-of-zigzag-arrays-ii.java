class Solution {
    private static final int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {
        int K = r - l + 1;
        int size = 2 * K;
        
        long[][] M = new long[size][size];
        
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < i; j++) {
                M[2 * i][2 * j + 1] = 1;
            }
            for (int j = i + 1; j < K; j++) {
                M[2 * i + 1][2 * j] = 1;
            }
        }
        
        long[][] mPow = power(M, n - 1, size);
        
        long totalValidArrays = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                totalValidArrays = (totalValidArrays + mPow[i][j]) % MOD;
            }
        }
        
        return (int) totalValidArrays;
    }
    
    private long[][] multiply(long[][] A, long[][] B, int size) {
        long[][] C = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (A[i][k] == 0) continue; 
                
                for (int j = 0; j < size; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }
    
    private long[][] power(long[][] A, int p, int size) {
        long[][] res = new long[size][size];
        for (int i = 0; i < size; i++) {
            res[i][i] = 1;
        }
        
        long[][] base = A;
        while (p > 0) {
            if (p % 2 == 1) {
                res = multiply(res, base, size);
            }
            base = multiply(base, base, size);
            p /= 2;
        }
        return res;
    }
}