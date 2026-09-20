class Solution {
    public int reverseDegree(String s) {
     HashMap<Character,Integer> map=new HashMap<>();
     char ch='a';
     for(int i=26;i>=0;i--){
        map.put(ch++,i);
     }
     int sum=0;
     for(int i=0;i<s.length();i++){

        sum+=map.get(s.charAt(i)) * (i+1);
     }

     return sum;   
    }
}