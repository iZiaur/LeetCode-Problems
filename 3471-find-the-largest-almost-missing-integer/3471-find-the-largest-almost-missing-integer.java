class Solution {
    public int largestInteger(int[] nums, int k) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            ArrayList <Integer> temp=new ArrayList<>();
            for(int j=i;j<i+k && j<nums.length;j++){
                temp.add(nums[j]);
                System.out.print(nums[j]+" ");
            }
            
            if(temp.size()==k){
                arr.add(temp);
            }
            
        }

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.size();i++){
            ArrayList<Integer> temp=arr.get(i);
            HashSet<Integer> set = new HashSet<>(temp);
            for(int num:set){
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }

        int ans=-1;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                ans=Math.max(ans,entry.getKey());
            }
        }

        return ans;
    }
}