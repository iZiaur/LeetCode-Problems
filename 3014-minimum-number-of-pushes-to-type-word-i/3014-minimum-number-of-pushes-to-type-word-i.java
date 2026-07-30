class Solution {
    public int minimumPushes(String word) {
        if(word.length()<=8){
            return word.length();
        }
        int count=0;

        // System.out.println(word.length());
        for(int i=0;i<word.length();i++){
            if(i<=7){
                count=count+1;
            }else if(i<=15){
                count=count+2;
            }else if(i<=23){
                count=count+3;
            }else{
                count=count+4;
            }
        }

        return count;
    }
}