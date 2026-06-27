class Solution {

    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(
                (long) num,
                map.getOrDefault((long) num, 0) + 1
            );
        }

        int max = 1;

        
        if (map.containsKey(1L)) {

            int count = map.get(1L);

            if (count % 2 == 0) {
                count--;
            }

            max = Math.max(max, count);
        }

        for (long start : map.keySet()) {

            if (start == 1)
                continue;

            long curr = start;

            int len = 0;

            while (map.getOrDefault(curr, 0) >= 2) {

                long next = curr * curr;

               
                if (!map.containsKey(next)) {
                    len++;
                    break;
                }

                len += 2;
                curr = next;

                if (curr > (long) 1e18)
                    break;
            }

           
            if (map.getOrDefault(curr, 0) == 1) {
                len++;
            }

            max = Math.max(max, len);
        }

        return max;
    }
}