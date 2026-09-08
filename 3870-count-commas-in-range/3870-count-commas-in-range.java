class Solution {
    public int countCommas(int n) {
        StringBuilder str=new StringBuilder(String.valueOf(n));
        if(str.length()<4){
            return 0;
        }
        int rem=n-1000;

        return rem+1;
    }
}