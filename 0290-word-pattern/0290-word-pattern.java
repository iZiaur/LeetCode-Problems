class Solution {
    public boolean wordPattern(String pattern, String s) {
       
        HashMap<Character,String> map1=new HashMap<>();
        HashMap<String,Character> map2=new HashMap<>();
        String arr[]=s.split(" ");
         if (pattern.length() != arr.length) {
            return false;
        }

        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            if(!map1.containsKey(ch)){
                map1.put(ch,arr[i]);
            }
        }

        for(int i=0;i<arr.length;i++){
            if(!map2.containsKey(arr[i])){
                map2.put(arr[i],pattern.charAt(i));
            }
        }

        for(int i=0;i<pattern.length();i++){
            String val=map1.get(pattern.charAt(i));
            if(!val.equals(arr[i])){
                return false;
            }
            char ch=map2.get(arr[i]);
            if(ch!=pattern.charAt(i)){
                return false;
            }
        }

        return true;
    }
}