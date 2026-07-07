class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       Deque <Integer> dq=new ArrayDeque<>();
       ArrayList<Integer> res=new ArrayList<>();
       for(int i=0;i<k;i++){
        while(dq.size()>0 && nums[dq.getLast()]<=nums[i]){
            dq.removeLast();
        }
        dq.addLast(i);
       }

       for(int i=k;i<nums.length;i++){
        res.add(nums[dq.getFirst()]);

        while(dq.size()>0 && dq.getFirst()<i-k+1){
            dq.removeFirst();
        }
        while(dq.size()>0 && nums[dq.getLast()]<=nums[i]){
            dq.removeLast();
        }
         dq.addLast(i);
       }
       res.add(nums[dq.getFirst()]);

       for(int i=0;i<res.size();i++){
        System.out.print(res.get(i)+" ");
       }

        int ans[]=new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return ans;

         
         }
       }