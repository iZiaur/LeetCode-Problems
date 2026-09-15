class Solution {
    public boolean isPalindrome(String s,int i,int j){
        if(j>=s.length()) return false;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
    public int maxPalindromes(String s, int k) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(isPalindrome(s,i,i+k-1)){
                ans++;
                i+=k-1;
            }
            else if(isPalindrome(s,i,i+k)){
                ans++;
                i+=k;
            }
        }

        return ans;
    }
}