import java.util.*;

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] pref = new int[n + 1];

        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (nums[i] == target ? 1 : -1);
        }

        boolean found = false;
        for (int x : nums) {
            if (x == target) {
                found = true;
                break;
            }
        }

        if (!found) return 0;

        int[] comp = pref.clone();
        Arrays.sort(comp);

        int m = 1;
        for (int i = 1; i < comp.length; i++) {
            if (comp[i] != comp[i - 1]) {
                comp[m++] = comp[i];
            }
        }

        Fenwick bit = new Fenwick(m + 2);
        long ans = 0;

        for (int x : pref) {
            int idx = lowerBound(comp, m, x) + 1;
            ans += bit.query(idx - 1);
            bit.update(idx, 1);
        }

        return ans;
    }

    private int lowerBound(int[] arr, int size, int target) {
        int l = 0, r = size;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    class Fenwick {
        long[] bit;

        Fenwick(int n) {
            bit = new long[n];
        }

        void update(int idx, long val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        long query(int idx) {
            long res = 0;
            while (idx > 0) {
                res += bit[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }
}