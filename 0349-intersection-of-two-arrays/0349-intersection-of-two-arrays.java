class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList <Integer> sol=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();

        for(int i=0;i<nums1.length;i++){
            list1.add(nums1[i]);
        }

        for(int i=0;i<nums2.length;i++){
            if(list1.contains(nums2[i])){

                if(!sol.contains(nums2[i])){
                    sol.add(nums2[i]);
                }
            }
        }

        int ans[]=new int[sol.size()];

        for(int i=0;i<sol.size();i++){
            ans[i]=sol.get(i);
        }

        return ans;
    }
}