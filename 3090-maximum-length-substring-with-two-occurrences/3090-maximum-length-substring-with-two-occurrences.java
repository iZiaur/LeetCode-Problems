class Solution {
    public int maximumLengthSubstring(String s) {
       int left=0;
        int len=Integer.MIN_VALUE;
        HashMap<Character,Integer> map=new HashMap<>();
       for(int right=0;right<s.length();right++){
           map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
           while(map.get(s.charAt(right))>2){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
           }
           len=Math.max(right-left+1,len);
       }

       return len;
    }
}