class Solution {
    public int lengthOfLongestSubstring(String s) {
        int hash[]=new int[256];
        int l=0;
        int r=0;
        int max=0;
        Arrays.fill(hash,-1);
        while(r<s.length()){

            if(hash[s.charAt(r)]>=l){
                l=Math.max(hash[s.charAt(r)]+1,l);
            }
            max=Math.max(max,r-l+1);
            hash[s.charAt(r)]=r;
            r++;
        }
        return max;
    }
}