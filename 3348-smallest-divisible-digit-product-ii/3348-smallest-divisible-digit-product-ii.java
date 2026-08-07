class Solution {
    public String smallestNumber(String num, long t) {
        long tempT = t;
        int c2 = 0, c3 = 0, c5 = 0, c7 = 0;
        
        while (tempT % 2 == 0) { c2++; tempT /= 2; }
        while (tempT % 3 == 0) { c3++; tempT /= 3; }
        while (tempT % 5 == 0) { c5++; tempT /= 5; }
        while (tempT % 7 == 0) { c7++; tempT /= 7; }
        
        if (tempT > 1) {
            return "-1";
        }

        int n = num.length();
        int[] numDigits = new int[n];
        for (int i = 0; i < n; i++) {
            numDigits[i] = num.charAt(i) - '0';
        }

        int firstZero = -1;
        for (int i = 0; i < n; i++) {
            if (numDigits[i] == 0) {
                firstZero = i;
                break;
            }
        }

        int[][] req2 = new int[n + 1][4];
        req2[0] = new int[]{c2, c3, c5, c7};

        int limit = (firstZero == -1) ? n : firstZero;
        for (int i = 0; i < limit; i++) {
            int d = numDigits[i];
            int r2 = req2[i][0], r3 = req2[i][1], r5 = req2[i][2], r7 = req2[i][3];
            
            if (d == 2) r2 = Math.max(0, r2 - 1);
            else if (d == 3) r3 = Math.max(0, r3 - 1);
            else if (d == 4) r2 = Math.max(0, r2 - 2);
            else if (d == 5) r5 = Math.max(0, r5 - 1);
            else if (d == 6) { r2 = Math.max(0, r2 - 1); r3 = Math.max(0, r3 - 1); }
            else if (d == 7) r7 = Math.max(0, r7 - 1);
            else if (d == 8) r2 = Math.max(0, r2 - 3);
            else if (d == 9) r3 = Math.max(0, r3 - 2);
            
            req2[i + 1] = new int[]{r2, r3, r5, r7};
        }

        for (int i = limit; i >= 0; i--) {
            int startDigit = (i == n) ? numDigits[n - 1] : (i < limit ? numDigits[i] + 1 : 1);

            for (int d = startDigit; d <= 9; d++) {
                if (i == n && d > numDigits[n - 1]) break;
                
                int r2 = req2[i][0], r3 = req2[i][1], r5 = req2[i][2], r7 = req2[i][3];
                
                if (i < n) {
                    if (d == 2) r2 = Math.max(0, r2 - 1);
                    else if (d == 3) r3 = Math.max(0, r3 - 1);
                    else if (d == 4) r2 = Math.max(0, r2 - 2);
                    else if (d == 5) r5 = Math.max(0, r5 - 1);
                    else if (d == 6) { r2 = Math.max(0, r2 - 1); r3 = Math.max(0, r3 - 1); }
                    else if (d == 7) r7 = Math.max(0, r7 - 1);
                    else if (d == 8) r2 = Math.max(0, r2 - 3);
                    else if (d == 9) r3 = Math.max(0, r3 - 2);
                }

                int remLen = n - (i < n ? i + 1 : n);
                String suffix = getMinSuffix(r2, r3, r5, r7, remLen);
                
                if (suffix != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < i; j++) sb.append(numDigits[j]);
                    if (i < n) sb.append(d);
                    sb.append(suffix);
                    return sb.toString();
                }
            }
        }

        int minLenForT = getMinDigitsNeeded(c2, c3, c5, c7);
        int targetLen = Math.max(n + 1, minLenForT);
        
        return getMinSuffix(c2, c3, c5, c7, targetLen);
    }

    private int getMinDigitsNeeded(int c2, int c3, int c5, int c7) {
        int count = c7 + c5;
        count += c3 / 2;
        int rem3 = c3 % 2;
        count += c2 / 3;
        int rem2 = c2 % 3;

        if (rem3 == 1 && rem2 == 1) {
            count += 1;
        } else if (rem3 == 1 && rem2 == 2) {
            count += 2;
        } else if (rem3 == 1) {
            count += 1;
        } else if (rem2 == 2) {
            count += 1;
        } else if (rem2 == 1) {
            count += 1;
        }
        return count;
    }

    private String getMinSuffix(int c2, int c3, int c5, int c7, int len) {
        int d9 = c3 / 2;
        int rem3 = c3 % 2;
        int d8 = c2 / 3;
        int rem2 = c2 % 3;

        int d7 = c7;
        int d6 = 0, d5 = c5, d4 = 0, d3 = 0, d2 = 0;

        if (rem3 == 1 && rem2 == 1) {
            d6 = 1;
        } else if (rem3 == 1 && rem2 == 2) {
            d6 = 1; d2 = 1;
        } else if (rem3 == 1 && rem2 == 0) {
            d3 = 1;
        } else if (rem3 == 0 && rem2 == 2) {
            d4 = 1;
        } else if (rem3 == 0 && rem2 == 1) {
            d2 = 1;
        }

        int totalDigits = d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9;
        if (totalDigits > len) return null;

        int d1 = len - totalDigits;
        StringBuilder sb = new StringBuilder();
        sb.append("1".repeat(d1));
        sb.append("2".repeat(d2));
        sb.append("3".repeat(d3));
        sb.append("4".repeat(d4));
        sb.append("5".repeat(d5));
        sb.append("6".repeat(d6));
        sb.append("7".repeat(d7));
        sb.append("8".repeat(d8));
        sb.append("9".repeat(d9));

        return sb.toString();
    }
}