class Solution {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        Stack<Integer> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        int k = 0;

        for (int num : nums) {
            if (num == -1) {
                k++;

                if (k > st.size()) {
                    ans.add(-1);
                } else {
                    ans.add(st.get(st.size() - k));
                }
            } else {
                st.push(num);
                k = 0;
            }
        }

        return ans;
    }
}