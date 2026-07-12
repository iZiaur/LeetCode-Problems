class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeMap <Integer,Integer> map= new TreeMap<>();

        for(int i=0;i<arr.length;i++){
            map.put(arr[i],0);

        }
        int idx=1;
        for(int key:map.keySet()){
            map.put(key,idx++);
        }

        int sol[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            sol[i]=map.get(arr[i]);
        }
        return sol;
    }
}