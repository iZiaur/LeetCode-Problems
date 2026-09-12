import java.util.*;

class Solution {
    private record Interval(int left, int right, int weight, int originalIndex) {}
    
    private record State(long weight, List<Integer> selected) {}

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        List<Interval> list = new ArrayList<>(n);
        
        for (int i = 0; i < n; i++) {
            List<Integer> interval = intervals.get(i);
            list.add(new Interval(interval.get(0), interval.get(1), interval.get(2), i));
        }
        
        list.sort(Comparator.comparingInt(Interval::left));
        
        State[][] memo = new State[n][5];
        State bestState = dp(list, memo, 0, 4);
        
        int[] result = new int[bestState.selected().size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = bestState.selected().get(i);
        }
        return result;
    }

    private State dp(List<Interval> intervals, State[][] memo, int i, int quota) {
        if (i == intervals.size() || quota == 0) {
            return new State(0L, Collections.emptyList());
        }
        if (memo[i][quota] != null) {
            return memo[i][quota];
        }

        State skip = dp(intervals, memo, i + 1, quota);

        Interval curr = intervals.get(i);
        int nextIdx = findNext(intervals, i + 1, curr.right());
        State nextRes = dp(intervals, memo, nextIdx, quota - 1);

        List<Integer> newSelected = new ArrayList<>(nextRes.selected());
        newSelected.add(curr.originalIndex());
        Collections.sort(newSelected);

        State pick = new State(curr.weight() + nextRes.weight(), newSelected);

        State result;
        if (pick.weight() > skip.weight()) {
            result = pick;
        } else if (pick.weight() < skip.weight()) {
            result = skip;
        } else {
            result = compareLists(pick.selected(), skip.selected()) < 0 ? pick : skip;
        }

        return memo[i][quota] = result;
    }

    private int findNext(List<Interval> intervals, int start, int rightBoundary) {
        int low = start, high = intervals.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (intervals.get(mid).left() > rightBoundary) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int compareLists(List<Integer> a, List<Integer> b) {
        int minSize = Math.min(a.size(), b.size());
        for (int i = 0; i < minSize; i++) {
            int cmp = Integer.compare(a.get(i), b.get(i));
            if (cmp != 0) return cmp;
        }
        return Integer.compare(a.size(), b.size());
    }
}