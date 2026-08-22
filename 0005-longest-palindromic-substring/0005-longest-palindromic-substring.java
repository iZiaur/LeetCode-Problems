class Solution {
    public boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
    public String longestPalindrome(String s) {
        int maxl=Integer.MIN_VALUE;
        String sf=null;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String n=s.substring(i,j+1);
                if(isPalindrome(n)){
                    if(maxl<n.length()){
                        sf=n;
                        maxl=n.length();
                    }
                }
            }
        }

        return sf;
    }
}