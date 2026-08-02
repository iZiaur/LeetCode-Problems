class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map=new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }else{
                map.put(ch,map.get(ch)+1);
            }
        }

        int index=-1;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                index=s.indexOf(entry.getKey());
                break;
            }
        }

        

        return index;
    }
}