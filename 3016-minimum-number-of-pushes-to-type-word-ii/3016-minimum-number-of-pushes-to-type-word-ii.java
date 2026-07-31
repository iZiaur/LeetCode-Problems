class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer> map=new LinkedHashMap<>();

        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }else{

                map.put(ch,map.get(ch)+1);
            }
        }

        // for(Map.Entry<Character,Integer> entry:map.entrySet()){
        //     System.out.println(entry.getKey()+" "+entry.getValue());
        // }
        ArrayList<Integer> list=new ArrayList<>();
       
        for(int v:map.values()){
           list.add(v);
        }

        Collections.sort(list);
        Collections.reverse(list);
        int cost=0;
        for(int i=0;i<list.size();i++){
            if(i>=0 && i<=7){
                cost=cost+list.get(i)*1;
            }else if(i>=8 && i<=15){
                cost=cost+list.get(i)*2;
            }else if(i>=16 && i<=23){
                cost=cost+list.get(i)*3;
            }else{
                cost=cost+list.get(i)*4;
            }
        }

        return cost;
    }
}