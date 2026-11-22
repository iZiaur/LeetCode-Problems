class Solution {
    public boolean checkString(String s) {
        int indexa=-1;
        int indexb=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                indexa=i;
            }
            if(s.charAt(i)=='b'){
                indexb=i;
            }
            if(indexa!=-1 && indexb!=-1 && indexa>indexb){
                return false;
            }
        }

        return true;
    }
}