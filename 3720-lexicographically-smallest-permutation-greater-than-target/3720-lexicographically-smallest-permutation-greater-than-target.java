import java.util.Arrays;

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int len = s.length();
        int[] counts = new int[26];
        for (int idx = 0; idx < len; idx++) {
            counts[s.charAt(idx) - 'a']++;
        }

        for (int pos = len - 1; pos >= 0; pos--) {
            int[] tempCounts = Arrays.copyOf(counts, 26);
            boolean validPrefix = true;

            for (int idx = 0; idx < pos; idx++) {
                int ch = target.charAt(idx) - 'a';
                if (tempCounts[ch] == 0) {
                    validPrefix = false;
                    break;
                }
                tempCounts[ch]--;
            }

            if (!validPrefix) continue;

            int targetChar = target.charAt(pos) - 'a';
            int selected = -1;
            for (int ch = targetChar + 1; ch < 26; ch++) {
                if (tempCounts[ch] > 0) {
                    selected = ch;
                    break;
                }
            }

            if (selected != -1) {
                char[] result = new char[len];
                for (int idx = 0; idx < pos; idx++) {
                    result[idx] = target.charAt(idx);
                }

                result[pos] = (char) ('a' + selected);
                tempCounts[selected]--;

                int writeIdx = pos + 1;
                for (int ch = 0; ch < 26; ch++) {
                    while (tempCounts[ch] > 0) {
                        result[writeIdx++] = (char) ('a' + ch);
                        tempCounts[ch]--;
                    }
                }

                return new String(result);
            }
        }

        return "";
    }
}