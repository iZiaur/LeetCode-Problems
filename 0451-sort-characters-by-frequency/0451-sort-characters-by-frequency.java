class Solution {

    class Pair{
        char ch;
        int freq;
        public Pair(char ch, int freq){
            this.ch=ch;
            this.freq=freq;
        }
    }
    public String frequencySort(String s) {
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.freq-a.freq);
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for(Map.Entry<Character,Integer>entry:map.entrySet()){
            char ch=entry.getKey();
            int freq=entry.getValue();
            System.out.println(ch+" "+freq);
            pq.add(new Pair(ch,freq));

        }

        StringBuilder str=new StringBuilder();
        while(!pq.isEmpty()){
            Pair p1=pq.poll();
            char ch=p1.ch;
            int freq=p1.freq;
            for(int i=0;i<freq;i++){
                str.append(ch);
            }
        }

        return str.toString();
    }
}