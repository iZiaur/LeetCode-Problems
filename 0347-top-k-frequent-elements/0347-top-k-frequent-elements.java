class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);

        }

        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int value:map.values()){
            pq.add(value);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int sol[]=new int[k];
        int idx=0;
       
        int threshold = pq.peek(); 
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            
            if(entry.getValue() >= threshold){
                sol[idx]=entry.getKey();
                idx++;
                
               
                if (idx == k) {
                    break; 
                }
            }
        
    }
    return sol;
}
}